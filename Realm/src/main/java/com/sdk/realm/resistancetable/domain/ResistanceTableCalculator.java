package com.sdk.realm.resistancetable.domain;

public class ResistanceTableCalculator {

	public ResistanceTableCalculator() {
		
	}

	/*
	 * Calculate and return the roll needed to resist an attack.
	 */
	public int calculateRollRequiredToResistAttack(int attackerLevel, int targetLevel) {
		
		int resistanceRequired = 0;
		int attackerComponent = 0;
		int targetComponent = 0;
		
		if (attackerLevel > 15) {
			attackerComponent = 30 + attackerLevel;  // 45-15 from 'attack down' script 
		} else {
			if (attackerLevel > 10) {
				attackerComponent = 35 + ((attackerLevel - 10) * 2);
			} else {
				if (attackerLevel > 5) {
					attackerComponent = 20 + ((attackerLevel -5 ) * 3);
				} else {
					attackerComponent = (attackerLevel -1) * 5;
				}
			}
		}
		
		if (targetLevel > 15) {
			targetComponent = 30 + targetLevel;  // 45-15 from 'attack down' script 
		} else {
			if (targetLevel > 10) {
				targetComponent = 35 + ((targetLevel - 10) * 2);
			} else {
				if (targetLevel > 5) {
					targetComponent = 20 + ((targetLevel -5 ) * 3);
				} else {
					targetComponent = (targetLevel -1) * 5;
				}
			}
		}

		resistanceRequired = 50 + attackerComponent - targetComponent;
		
		return resistanceRequired;
	}
}
