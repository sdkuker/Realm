package com.sdk.realm.character.domain;

public class CharacterComparison {

	/*
	 * Return true if the identity of the characters is equal
	 */
	public static boolean areIdentitiesEqual(GameCharacter characterOne, GameCharacter characterTwo) {
		
		boolean theReturn = false;
		if (characterOne == null && characterTwo == null) {
			theReturn = true;
		} else {
			if (characterOne != null && characterTwo != null) {
				if (characterOne == characterTwo) {
					theReturn = true;
				} else {
					theReturn = characterOne.getId() == characterTwo.getId();
				}
			}
		}
		return theReturn;

	}
	
	/*
	 * Return true if all the fields of the two Characters are equal including
	 * the identity fields.
	 */
	public static boolean areAllFieldsEqual(GameCharacter characterOne, GameCharacter characterTwo) {
	
		boolean theReturn = false;
		if (characterOne == null && characterTwo == null) {
			theReturn = true;
		} else {
			if (characterOne != null && characterTwo != null) {
				if (characterOne == characterTwo) {
					theReturn = true;
				} else {
					theReturn = characterOne.getId() == characterTwo.getId()
					&& characterOne.getAlertnessSkill()== characterTwo.getAlertnessSkill()
					&& characterOne.getArmorType() == characterTwo.getArmorType()
					&& characterOne.getDefensiveBonus() == characterTwo.getDefensiveBonus()
					&& characterOne.getInitiative() == characterTwo.getInitiative()
					&& characterOne.getInitiativeModifier() == characterTwo.getInitiativeModifier()
					&& characterOne.getWill() == characterTwo.getWill()
					&& characterOne.getWillModifier() == characterTwo.getWillModifier()
					&& characterOne.getLevel() == characterTwo.getLevel()
					&& characterOne.getName().equals(characterTwo.getName())
					&& characterOne.getObservationSkill() == characterTwo.getObservationSkill()
					&& characterOne.getPerception() == characterTwo.getPerception()
					&& characterOne.getPlayer().equals(characterTwo.getPlayer())
					&& characterOne.getSenseAmbushSkill() == characterTwo.getSenseAmbushSkill()
					&& characterOne.getStalkSkill() == characterTwo.getStalkSkill();
				}
			}
		}
		return theReturn;

	}
}
