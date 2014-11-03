package com.sdk.realm.combat.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.sdk.realm.character.domain.GameCharacter;
import com.sdk.realm.combat.persistance.CombatEncounterDAO;
import com.sdk.realm.criticalhit.domain.CriticalHit;


/*
 * I encompass a round of Combat.
 */
public class Round {
	
	private static final Logger _log = Logger.getLogger(CombatEncounterDAO.class);
	public static enum STATUS {open, closed};
	private List<CharacterCombatRoundStatistics> _characterStatistics = new ArrayList<CharacterCombatRoundStatistics>();
	private int _roundNumber = 0;
	private STATUS myStatus = STATUS.open;

	public void addStatistic(CharacterCombatRoundStatistics aStatistic) {
		_characterStatistics.add(aStatistic);
	}
	
	public int getRoundNumber() {
		return _roundNumber;
	}
	
	public void setRoundNumber(int anInt) {
		_roundNumber = anInt;
	}
	
	public STATUS getStatus() {
		return myStatus;
	}
	
	public void closeRound() {
		myStatus = STATUS.closed;
	}
	
	public void setStatus(STATUS aStatus) {
		myStatus = aStatus;
	}
	
	public List<CharacterCombatRoundStatistics> getCharacterCombatRoundStatistics() {
		return _characterStatistics;
	}
	
	public List<GameCharacter> getAllCharacters() {
		
		List<GameCharacter> allCharacters = new ArrayList<GameCharacter>();
		
		for (CharacterCombatRoundStatistics aStatistics : _characterStatistics) {
			allCharacters.add(aStatistics.getCharacter());
		}
		return allCharacters;
	}
	
	public void addCriticalHitSufferedForCharacter(GameCharacter aCharacter, CriticalHit aCriticalHit) {
		
		CharacterCombatRoundStatistics selectedStatistics = getStatisticsForCharacter(aCharacter);

		if (selectedStatistics != null) {
			selectedStatistics.addCriticalHitSuffered(aCriticalHit);
		} else {
			StringBuilder description = new StringBuilder();
			description.append("Unable to add critical hit suffered for character named: ");
			description.append(aCharacter.getName());
			description.append(" in round number: ");
			description.append(_roundNumber);
			description.append(" because no statistics for that character cound be found in the round.");
			_log.error(description.toString());
		}
	}
	
	public void removeCriticalHitSufferedForCharacter(GameCharacter aCharacter, CriticalHit aCriticalHit) {
		
		CharacterCombatRoundStatistics selectedStatistics = getStatisticsForCharacter(aCharacter);

		if (selectedStatistics != null) {
			selectedStatistics.removeCriticalHitSuffered(aCriticalHit);
		} else {
			StringBuilder description = new StringBuilder();
			description.append("Unable to remove critical hit suffered for character named: ");
			description.append(aCharacter.getName());
			description.append(" in round number: ");
			description.append(_roundNumber);
			description.append(" because no statistics for that character cound be found in the round.");
			_log.error(description.toString());
		}
	}
	CharacterCombatRoundStatistics getStatisticsForCharacter(GameCharacter aCharacter) {
		
		CharacterCombatRoundStatistics selectedStatistics = null;
		Iterator<CharacterCombatRoundStatistics> anIterator = _characterStatistics.iterator();
		
		while (anIterator.hasNext() && selectedStatistics == null) {
			CharacterCombatRoundStatistics someStatistics = anIterator.next();
			if (someStatistics.getCharacter().equals(aCharacter)) {
				selectedStatistics = someStatistics;
			}
		}
		return selectedStatistics;
	}
	
	public List<CriticalHit> getAllCriticalHitsForCharacter(GameCharacter aCharacter) {
		
		if(aCharacter != null) {
			return getStatisticsForCharacter(aCharacter).getCriticalHitsSuffered();
		} else {
			return new ArrayList<CriticalHit>();
		}
		
		
	}
}
