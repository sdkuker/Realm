package com.sdk.realm.player.domain;

public class PlayerComparison {

	/*
	 * Return true if the identity of the players is equal
	 */
	public static boolean areIdentitiesEqual(Player playerOne, Player playerTwo) {
		
		boolean theReturn = false;
		if (playerOne == null && playerTwo == null) {
			theReturn = true;
		} else {
			if (playerOne != null && playerTwo != null) {
				if (playerOne == playerTwo) {
					theReturn = true;
				} else {
					theReturn = playerOne.getId() == playerTwo.getId();
				}
			}
		}
		return theReturn;
		
	}
	
	/*
	 * Return true if all the fields of the two Players are equal including
	 * the identity fields.
	 */
	public static boolean areAllFieldsEqual(Player playerOne, Player playerTwo) {
		
		boolean theReturn = false;
		if (playerOne == null && playerTwo == null) {
			theReturn = true;
		} else {
			if (playerOne != null && playerTwo != null) {
				if (playerOne == playerTwo) {
					theReturn = true;
				} else {
					theReturn = playerOne.getId() == playerTwo.getId()
						&& playerOne.getName().equals(playerTwo.getName());
				}
			}
		}
		return theReturn;

	}
}
