package com.sdk.realm.character.domain;

/*
 * Contains the defensive related attributes for a character.
 */
public class DefensiveAttributes {

	private int quicknessBonus;
	private int racialModifier;
	private int armorChoice;
	private int armorOnArmor;
	private int shieldChoice;
	private int skillChoice1;
	private int skillChoice2;
	private int specialAbility;
	private int miscItemChoice;
	private int adrenalineDefense;
	
	public DefensiveAttributes() {
		
	}

	public int totalDefensiveBonus() {
		return quicknessBonus
				+ racialModifier 
				+ armorChoice
				+ armorOnArmor
				+ shieldChoice
				+ skillChoice1
				+ skillChoice2
				+ specialAbility
				+ miscItemChoice
				+ adrenalineDefense;
	}
	
	public int totalDefensiveBonusMinusAdrenalDefense() {
		return totalDefensiveBonus() - adrenalineDefense;
	}
	
	public int getQuicknessBonus() {
		return quicknessBonus;
	}

	public void setQuicknessBonus(int quicknessBonus) {
		this.quicknessBonus = quicknessBonus;
	}

	public int getRacialModifier() {
		return racialModifier;
	}

	public void setRacialModifier(int racialModifier) {
		this.racialModifier = racialModifier;
	}

	public int getArmorChoice() {
		return armorChoice;
	}

	public void setArmorChoice(int armorChoice) {
		this.armorChoice = armorChoice;
	}

	public int getArmorOnArmor() {
		return armorOnArmor;
	}

	public void setArmorOnArmor(int armorOnArmor) {
		this.armorOnArmor = armorOnArmor;
	}

	public int getShieldChoice() {
		return shieldChoice;
	}

	public void setShieldChoice(int shieldChoice) {
		this.shieldChoice = shieldChoice;
	}

	public int getSkillChoice1() {
		return skillChoice1;
	}

	public void setSkillChoice1(int skillChoice1) {
		this.skillChoice1 = skillChoice1;
	}

	public int getSkillChoice2() {
		return skillChoice2;
	}

	public void setSkillChoice2(int skillChoice2) {
		this.skillChoice2 = skillChoice2;
	}

	public int getSpecialAbility() {
		return specialAbility;
	}

	public void setSpecialAbility(int specialAbility) {
		this.specialAbility = specialAbility;
	}

	public int getMiscItemChoice() {
		return miscItemChoice;
	}

	public void setMiscItemChoice(int miscItemChoice) {
		this.miscItemChoice = miscItemChoice;
	}

	public int getAdrenalineDefense() {
		return adrenalineDefense;
	}

	public void setAdrenalineDefense(int adrenalineDefense) {
		this.adrenalineDefense = adrenalineDefense;
	}

}
