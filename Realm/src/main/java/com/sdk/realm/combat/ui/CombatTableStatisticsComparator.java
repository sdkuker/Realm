package com.sdk.realm.combat.ui;

import java.util.Comparator;

import com.sdk.realm.combat.domain.CharacterCombatRoundStatistics;

public class CombatTableStatisticsComparator implements Comparator<CharacterCombatRoundStatistics> {

	public int compare(CharacterCombatRoundStatistics arg0, CharacterCombatRoundStatistics arg1) {
		// sort in decending order
		int theReturn = 0;
		
		if (arg0.getInitiative() < arg1.getInitiative()) {
			theReturn = 1;
		} else {
			if (arg0.getInitiative() > arg1.getInitiative()) {
				theReturn = -1;
			}
		}
		return theReturn;
	}

}
