package com.sdk.realm.combat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.sdk.realm.character.domain.CharacterWarehouse;
import com.sdk.realm.character.domain.GameCharacter;
import com.sdk.realm.combat.domain.Round.STATUS;

/*
 * I am a combat encounter.
 */
public class CombatEncounter {

	private UUID id;
	private String description;
	private Date dateLastModified;
	List<Round> rounds = new ArrayList<Round>();

	public CombatEncounter() {
		super();
		id = UUID.randomUUID();
	}

	public CombatEncounter(String description, Date dateLastModified) {
		super();
		id = UUID.randomUUID();
		this.description = description;
		this.dateLastModified = dateLastModified;

	}

	public void addRound(Round aRound) {
		rounds.add(aRound);
	}

	public String getDescription() {
		return description;
	}

	/*
	 * Note that this is just the name of the file - it does NOT contain the
	 * entire file path.
	 */
	public String getFileName() {
		return id.toString();
	}

	public Date getDateLastModified() {
		return dateLastModified;
	}

	public UUID getId() {
		return id;
	}

	/*
	 * If there is no open round, create one and return it.
	 */
	public Round getOpenRound() {

		Round theReturn = null;

		for (Round aRound : rounds) {
			if (STATUS.open.equals(aRound.getStatus())) {
				theReturn = aRound;
			}
		}

		if (theReturn == null) {
			theReturn = createNextRound();
		}

		return theReturn;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public Round getRound(int roundNumber) {

		Round theReturn = null;

		for (Round aRound : rounds) {
			if (aRound.getRoundNumber() == roundNumber) {
				theReturn = aRound;
			}
		}
		return theReturn;
	}

	public Round createNextRound() {

		Round newRound = new Round();

		if (rounds.size() == 0) {
			// first round in the game. create one and add characters.
			newRound.setRoundNumber(1);
			for (GameCharacter aCharacter : CharacterWarehouse.getCurrent()
					.getAllCharacters()) {
				int charactersInitiative = RoundInitiativeDeterminer
						.determineBaseCombatInitiative(aCharacter);
				CharacterCombatRoundStatistics aStatistic = new CharacterCombatRoundStatistics(
						aCharacter, charactersInitiative, aCharacter
								.getAlertnessSkill(), aCharacter
								.getObservationSkill(), true);
				newRound.addStatistic(aStatistic);
			}
		} else {
			Round openRound = getOpenRound();
			for (CharacterCombatRoundStatistics aStatistic : openRound
					.getCharacterCombatRoundStatistics()) {
				CharacterCombatRoundStatistics newStatistic = aStatistic
						.cloneForCombat();
				newRound.addStatistic(newStatistic);
			}
			synchronizeStatisticsWithCharacterWarehouse(newRound);

			openRound.closeRound();
			newRound.setRoundNumber(openRound.getRoundNumber() + 1);
		}

		RoundInitiativeDeterminer.determineRoundInitiative(newRound);
		RoundAlertnessDeterminer.determineRoundAlertness(newRound);
		RoundObservationDeterminer.determineRoundObservation(newRound);
		StunnedCharacterCalculator
				.updatedStunnedCharactersForNewRound(newRound);

		rounds.add(newRound);
		CombatEncounterWarehouse.getCurrent().updateCombatEncounter(this);

		return newRound;
	}

	/*
	 * Make sure that there is a statistic for every character currently in the
	 * CharacterWarehouse
	 */
	private void synchronizeStatisticsWithCharacterWarehouse(Round aRound) {

		List<GameCharacter> warehouseCharacters = CharacterWarehouse.getCurrent()
				.getAllCharacters();
		List<CharacterCombatRoundStatistics> originalStatistics = aRound
				.getCharacterCombatRoundStatistics();
		List<CharacterCombatRoundStatistics> newStatistics = new ArrayList<CharacterCombatRoundStatistics>();
		List<CharacterCombatRoundStatistics> deletedStatistics = new ArrayList<CharacterCombatRoundStatistics>();

		// see if a character was added to the warehouse and doesn't currently
		// have a statistic
		for (GameCharacter aCharacter : warehouseCharacters) {
			if (!characterHasStatistic(aCharacter, originalStatistics)) {
				int charactersInitiative = RoundInitiativeDeterminer
						.determineBaseCombatInitiative(aCharacter);
				newStatistics.add(new CharacterCombatRoundStatistics(
						aCharacter, charactersInitiative, aCharacter
								.getAlertnessSkill(), aCharacter
								.getObservationSkill(), true));
			}
		}
		if (newStatistics.size() > 0) {
			aRound.getCharacterCombatRoundStatistics().addAll(newStatistics);
		}

		// now make sure that every statistic has a character
		for (CharacterCombatRoundStatistics aStatistic : originalStatistics) {
			if (!warehouseCharacters.contains(aStatistic.getCharacter())) {
				deletedStatistics.add(aStatistic);
			}
		}
		if (deletedStatistics.size() > 0) {
			aRound.getCharacterCombatRoundStatistics().removeAll(
					deletedStatistics);
		}
	}

	private boolean characterHasStatistic(GameCharacter aCharacter,
			List<CharacterCombatRoundStatistics> listOfStatistics) {

		boolean hasStatistic = false;
		Iterator<CharacterCombatRoundStatistics> statisticsIterator = listOfStatistics
				.iterator();

		while (statisticsIterator.hasNext() && (!hasStatistic)) {
			CharacterCombatRoundStatistics aStatistic = statisticsIterator
					.next();
			if (aStatistic.getCharacter().equals(aCharacter)) {
				hasStatistic = true;
			}
		}

		return hasStatistic;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
