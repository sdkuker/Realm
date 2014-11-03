package com.sdk.realm.combat.domain;


/*
 * updates the number of rounds that characters will remain stunned
 * during the creation of a new round.
 */
public class StunnedCharacterCalculator {

	public static void updatedStunnedCharactersForNewRound(Round aRound) {
		
		for (CharacterCombatRoundStatistics aStatistic: aRound.getCharacterCombatRoundStatistics()) {
			if (aStatistic.getRoundsStillStunned() > 0) {
				aStatistic.setRoundsStillStunned(aStatistic.getRoundsStillStunned() - 1);
			}
		}
		
	}
}
