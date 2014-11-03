package com.sdk.realm.character.domain;

import com.sdk.realm.persistance.domain.PersistantDomainObject;
import com.sdk.realm.player.domain.Player;
import com.sdk.realm.willcontest.domain.WillContestant;

public class GameCharacter extends PersistantDomainObject implements WillContestant {

	private String _name = null;
	private Player _player = null;
	private int _observationSkill;
	private int _initiative;
	private int _initiativeModifier;
	private int _level;
	private int _armorType;
	private boolean _hasShield = false;
	private boolean _hasAdrenalDefense = false;
	private int _stalkSkill;
	private int _senseAmbushSkill;
	private int _alertnessSkill;
	private int _perception;
	private int _hitPoints;
	private int _hitPointsModifier;
	private DefensiveAttributes _defensiveAttributes;
	private int _will;
	private int _willModifier;
	
	public GameCharacter() {
		super();
		_defensiveAttributes = new DefensiveAttributes();
	}
	
	public GameCharacter(String _name, Player _player, int observationSkill,
			int _initiative, int _initiativeModifier,int _level, int type,
			boolean shield, boolean adrenalDefense, int stalkSkill,
			int ambushSkill, int alertnessSkill, int perception, int hitPoints,
			int hitPointsModifier, int will, int willModifier) {
		super();
		_id = CharacterWarehouse.getCurrent().getNextAvailableCharacterID();
		this._name = _name;
		this._player = _player;
		_observationSkill = observationSkill;
		this._initiative = _initiative;
		this._initiativeModifier = _initiativeModifier;
		this._level = _level;
		_armorType = type;
		_hasShield = shield;
		_hasAdrenalDefense = adrenalDefense;
		_stalkSkill = stalkSkill;
		_senseAmbushSkill = ambushSkill;
		_alertnessSkill = alertnessSkill;
		_perception = perception;
		_defensiveAttributes = new DefensiveAttributes();
		_hitPoints = hitPoints;
		_hitPointsModifier = hitPointsModifier;
		_will = will;
		_willModifier = willModifier;
	}

	public String getWillContestantId() {
		return "Character-" + getId();
	}

	public String getName() {
		return _name;
	}

	public Player getPlayer() {
		return _player;
	}

	public int getObservationSkill() {
		return _observationSkill;
	}
	
	public int getHitPoints() {
		return _hitPoints;
	}
	
	public int getTotalHitPoints() {
		return _hitPoints + _hitPointsModifier;
	}
	
	public int getHitPointsModifier() {
		return _hitPointsModifier;
	}

	public int getInitiative() {
		return _initiative;
	}
	
	public int getInitiativeModifier() {
		return _initiativeModifier;
	}
	
	public int getWill() {
		return _will;
	}
	
	public int getWillModifier() {
		return _willModifier;
	}
	
	public int getTotalWill() {
		return _will + _willModifier;
	}

	public int getLevel() {
		return _level;
	}

	public int getArmorType() {
		return _armorType;
	}

	public int getDefensiveBonus() {
		
		return _defensiveAttributes.totalDefensiveBonus();
	}

	public int getDefensiveBonusMinusAdrenalDefense() {
		return _defensiveAttributes.totalDefensiveBonusMinusAdrenalDefense();
	}
	public boolean isHasShield() {
		return _hasShield;
	}

	public boolean isHasAdrenalDefense() {
		return _hasAdrenalDefense;
	}

	public int getStalkSkill() {
		return _stalkSkill;
	}

	public int getSenseAmbushSkill() {
		return _senseAmbushSkill;
	}

	public int getAlertnessSkill() {
		return _alertnessSkill;
	}

	public int getPerception() {
		return _perception;
	}

	public void setName(String _name) {
		this._name = _name;
	}

	public void setPlayer(Player _player) {
		this._player = _player;
	}

	public void setObservationSkill(int skill) {
		_observationSkill = skill;
	}

	public void setInitiative(int _initiative) {
		this._initiative = _initiative;
	}
	
	public void setInitiativeModifier(int anInitModifier) {
		_initiativeModifier = anInitModifier;
	}
	
	public void setWill(int anInt) {
		_will = anInt;
	}
	
	public void setWillModifier(int aWillModifier) {
		_willModifier = aWillModifier;
	}

	public void setLevel(int _level) {
		this._level = _level;
	}
	
	public void setHitPoints(int somePoints) {
		_hitPoints = somePoints;
	}
	
	public void setHitPointsModifier(int aModifier) {
		_hitPointsModifier = aModifier;
	}

	public void setArmorType(int type) {
		_armorType = type;
	}

	public void setHasShield(boolean shield) {
		_hasShield = shield;
	}

	public void setHasAdrenalDefense(boolean adrenalDefense) {
		_hasAdrenalDefense = adrenalDefense;
	}

	public void setStalkSkill(int skill) {
		_stalkSkill = skill;
	}

	public void setSenseAmbushSkill(int ambushSkill) {
		_senseAmbushSkill = ambushSkill;
	}

	public void setAlertnessSkill(int skill) {
		_alertnessSkill = skill;
	}

	public void setPerception(int _perception) {
		this._perception = _perception;
	}

	public DefensiveAttributes getDefensiveAttributes() {
		if (_defensiveAttributes == null) {
			_defensiveAttributes = new DefensiveAttributes();
		}
		return _defensiveAttributes;
	}

	public void setDefensiveAttributes(DefensiveAttributes attributes) {
		_defensiveAttributes = attributes;
	}

}
