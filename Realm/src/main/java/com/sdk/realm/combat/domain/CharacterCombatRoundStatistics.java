package com.sdk.realm.combat.domain;

import java.util.ArrayList;
import java.util.List;

import com.sdk.realm.character.domain.GameCharacter;
import com.sdk.realm.criticalhit.domain.CriticalHit;

/*
 * I encompass all the statistics that apply to a character during a round of combat. 
 */
public class CharacterCombatRoundStatistics {

	private GameCharacter _character;
	private int _initiative;
	private int _alertness;
	private int _observation;
	private int _totalHits;
	private int _bleeding;
	private int _roundsStillStunned;
	private int _negativeModifier;
	private int _regeneration;
	private int _hitsAtStartOfRound;
	private int _hitsTakenDuringRound;
	private int _characterTotalHitPointsAtStartOfRound;
	private List<CriticalHit> _criticalHitsSuffered;
	

	/*
	 * Note that the initiative should be the sum of the regular initiative plus
	 * the initiative modifier.
	 */
	public CharacterCombatRoundStatistics(GameCharacter aCharacter, int anInitiative, int anAlertness, int anObservation, boolean firstRoundOfCombat) {
		super();
		_character = aCharacter;
		_initiative = anInitiative;
		_alertness = anAlertness;
		_observation = anObservation;
		_totalHits = aCharacter.getTotalHitPoints();
		if (firstRoundOfCombat) {
			_hitsAtStartOfRound = aCharacter.getTotalHitPoints();
			_characterTotalHitPointsAtStartOfRound = aCharacter.getTotalHitPoints();
		}
	}
	
	public CharacterCombatRoundStatistics() {
		super();
	}

	public CharacterCombatRoundStatistics cloneForCombat() {
		
		CharacterCombatRoundStatistics theReturn = new CharacterCombatRoundStatistics();
		
		int changesToCharacterTotalHits = 0;
		theReturn._character = getCharacter();
		if (theReturn.getCharacter() != null) {
			theReturn._initiative = RoundInitiativeDeterminer.determineBaseCombatInitiative(theReturn.getCharacter());
			theReturn.setCharacterTotalHitPointsAtStartOfRound(theReturn.getCharacter().getTotalHitPoints());
			changesToCharacterTotalHits = theReturn.getCharacter().getTotalHitPoints() - getCharacterTotalHitPointsAtStartOfRound(); 
		}
		theReturn._totalHits = getTotalHits() + changesToCharacterTotalHits;
		theReturn._hitsAtStartOfRound = getHitsAtEndOfRound() + changesToCharacterTotalHits;
		theReturn._bleeding = getBleeding();
		theReturn._roundsStillStunned = getRoundsStillStunned();
		theReturn._negativeModifier = getNegativeModifier();
		theReturn._regeneration = getRegeneration();
		theReturn._alertness = getAlertness();
		theReturn._observation = getObservation();
		List<CriticalHit> newCriticalHitsSufferedList = new ArrayList<CriticalHit>();
//		for (CriticalHit aCriticalHit : _criticalHitsSuffered) {
//			newCriticalHitsSufferedList.add(aCriticalHit);
//		}
		theReturn._criticalHitsSuffered = newCriticalHitsSufferedList;
		
		return theReturn;
	}
	public GameCharacter getCharacter() {
		return _character;
	}
	public void setCharacter(GameCharacter aCharacter) {
		_character = aCharacter;
	}
	public String getCharacterName() {
		return _character.getName();
	}
	
	public int getInitiative() {
		return _initiative;
	}
	public void setInitiative(int anInitiative) {
		_initiative= anInitiative;
	}
	
	public void setAlertness(int anAlertness) {
		_alertness = anAlertness;
	}
	
	public int getAlertness() {
		return _alertness;
	}
	
	public int getCharacterTotalHitPointsAtStartOfRound() {
		return _characterTotalHitPointsAtStartOfRound;
	}
	
	public void setCharacterTotalHitPointsAtStartOfRound(int someHitPoints) {
		_characterTotalHitPointsAtStartOfRound = someHitPoints;
	}
	
	public void setObservation(int anObservation) {
		_observation = anObservation;
	}
	
	public int getObservation() {
		return _observation;
	}
	
	public int getTotalHits() {
		return _totalHits;
	}
	
	public void setTotalHits(int numberOfHits) {
		_totalHits = numberOfHits;
	}
	
	public void addToInitiative(int anInt) {
		_initiative = _initiative + anInt;
	}
	
	public void addToAlertness(int anInt) {
		_alertness = _alertness + anInt;
	}

	public void addToObservation(int anInt) {
		_observation = _observation + anInt;
	}

	public int getBleeding() {
		return _bleeding;
	}

	public int getRoundsStillStunned() {
		return _roundsStillStunned;
	}

	public int getNegativeModifier() {
		return _negativeModifier;
	}

	public void setBleeding(int _bleeding) {
		this._bleeding = _bleeding;
	}

	public void setRoundsStillStunned(int roundsStillStunned) {
		this._roundsStillStunned = roundsStillStunned;
	}

	// this should always be negative - regardless of what was entered
	public void setNegativeModifier(int modifier) {
		
		if (modifier > 0) {
			_negativeModifier =  - modifier;
		} else {
			_negativeModifier = modifier;
		}
	}
	
	public int getRegeneration() {
		return _regeneration;
	}
	
	public void setRegeneration(int anInt) {
		_regeneration = anInt;
	}

	public int getHitsAtStartOfRound() {
		return _hitsAtStartOfRound;
	}
	
	public void setHitsAtStartOfRound(int anInt) {
		_hitsAtStartOfRound = anInt;
	}
	
	public int getHitsAtEndOfRound() {
		
		int calculatedHitsAtEndOfRound = _hitsAtStartOfRound - _hitsTakenDuringRound  - _bleeding + _regeneration;
		if (_character != null ) {
			return Math.min(calculatedHitsAtEndOfRound, _character.getTotalHitPoints());
		} else {
			return calculatedHitsAtEndOfRound;
		}
	}
	
	public int getHitsTakenDuringRound() {
		return _hitsTakenDuringRound;
	}
	public void setHitsTakenDuringRound(int someHits) {
		_hitsTakenDuringRound = someHits;
	}

	public List<CriticalHit> getCriticalHitsSuffered() {
		return _criticalHitsSuffered;
	}

	public void setCriticalHitsSuffered(List<CriticalHit> someCriticalHitsSuffered) {
		_criticalHitsSuffered = someCriticalHitsSuffered;
	}
	
	public void addCriticalHitSuffered(CriticalHit aCriticalHit) {
		_criticalHitsSuffered.add(aCriticalHit);
	}

	public void removeCriticalHitSuffered(CriticalHit aCriticalHit) {
		_criticalHitsSuffered.remove(aCriticalHit);
	}
}
