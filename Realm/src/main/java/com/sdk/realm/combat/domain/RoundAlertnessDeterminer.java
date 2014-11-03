package com.sdk.realm.combat.domain;

import com.sdk.realm.domain.common.Die;

/**
 * Sets alertness for a round
 */
public class RoundAlertnessDeterminer {

	private static final Die ONE_HUNDRED_SIDED_DIE = new Die(100);
	
	public static void determineRoundAlertness(Round aRound) {
		
		for (CharacterCombatRoundStatistics aStatistic: aRound.getCharacterCombatRoundStatistics()) {
			aStatistic.addToAlertness(ONE_HUNDRED_SIDED_DIE.rollOpenEnded());
		}
		
	}

}
