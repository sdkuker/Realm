package com.sdk.realm.combat.domain;

import com.sdk.realm.character.domain.GameCharacter;
import com.sdk.realm.domain.common.Die;

/**
 * set the initiatives for the input statistics
 */
public class RoundInitiativeDeterminer {
	
	private static final Die ONE_HUNDRED_SIDED_DIE = new Die(100);
	
	public static void determineRoundInitiative(Round aRound) {
		
		for (CharacterCombatRoundStatistics aStatistic: aRound.getCharacterCombatRoundStatistics()) {
			aStatistic.addToInitiative(ONE_HUNDRED_SIDED_DIE.rollOpenEnded());
		}
		
	}
	
	/*
	 * determine the base or static initiative for each character.  This is
	 * before any random die rolls are added to it.
	 */
	public static int determineBaseCombatInitiative(GameCharacter aCharacter) {
		
		return aCharacter.getInitiative() + aCharacter.getInitiativeModifier();
		
	}


}
