package com.sdk.realm.herblore.domain;

public class Herb {

	private String _classification = null;
	private String _name = null;
	private String _effect = null;
	private int _attackLevel = 0;
	private String _formAndPreperation = null;
	private String _costRarity = null;
	
	public Herb(String _classification, String _name, String _effect, Integer level,
			String formAndPrepertion, String rarity) {
		super();
		this._classification = _classification;
		this._name = _name;
		this._effect = _effect;
		if (level != null) {
			_attackLevel = level;	
		}
		_formAndPreperation = formAndPrepertion;
		_costRarity = rarity;
	}

	public Herb() {
	}

	public String getClassification() {
		return _classification;
	}

	public String getName() {
		return _name;
	}

	public String getEffect() {
		return _effect;
	}

	public int getAttackLevel() {
		return _attackLevel;
	}

	public String getCostRarity() {
		return _costRarity;
	}

	public String getFormAndPreperation() {
		return _formAndPreperation;
	}
}
