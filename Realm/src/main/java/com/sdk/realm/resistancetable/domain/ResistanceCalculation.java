package com.sdk.realm.resistancetable.domain;

/*
 * I am the data needed to calc a resistance roll and the results of that calculation
 */
public class ResistanceCalculation {

	private int attackerLevel = 0;
	private int targetLevel = 0;
	private int rollRequiredToResistAttack = 0;
	
	public ResistanceCalculation() {
	}

	public int getAttackerLevel() {
		return attackerLevel;
	}

	public int getTargetlevel() {
		return targetLevel;
	}

	public int getRollRequiredToResistAttack() {
		return rollRequiredToResistAttack;
	}

	public void setAttackerLevel(int attackerLevel) {
		this.attackerLevel = attackerLevel;
	}

	public void setTargetLevel(int targetLevel) {
		this.targetLevel = targetLevel;
	}

	public void setRollRequiredToResistAttack(int rollRequiredToResistAttack) {
		this.rollRequiredToResistAttack = rollRequiredToResistAttack;
	}

}
