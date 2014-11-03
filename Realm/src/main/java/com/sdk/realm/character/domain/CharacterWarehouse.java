package com.sdk.realm.character.domain;

import java.util.Iterator;
import java.util.List;

import com.sdk.realm.character.persistance.CharacterDAO;
import com.sdk.realm.player.domain.Player;

public class CharacterWarehouse {

	private static CharacterWarehouse CURRENT = null;
	
	private List<GameCharacter> _allCharacters = null;
	
	public static CharacterWarehouse getCurrent() {
		
		if (CURRENT == null) {
			initializeCurrent();
		}
		return CURRENT;
	}

	/*
	 * This is exposed only for testing - it should not be called by any domain consumer
	 */
	public static void setCurrent(CharacterWarehouse aWarehouse) {
		CURRENT = aWarehouse;
	}
	
	private static void initializeCurrent() {
		if (CURRENT == null) {
			CharacterWarehouse temp = new CharacterWarehouse();
			temp._allCharacters = (new CharacterDAO()).getAllCharacters();
			CURRENT = temp;
		}
	}
	
	public List<GameCharacter> getAllCharacters() {
		return _allCharacters;
	}
	
	/* 
	 * Set all the characters to those in the input argument.
	 */
	public void setAllCharacters(List<GameCharacter> aSetOfCharacters) {
		_allCharacters = aSetOfCharacters;
	}
	
	/*
	 * Persist everything I currently have. Return true if everything worked ok
	 * and false if there was any problem at all.
	 */
	public boolean persistAll() {
		
		return (new CharacterDAO()).setAllCharactersTo(_allCharacters);
	}
	
	public GameCharacter createAndAddNewCharacter() {
		GameCharacter aCharacter = new GameCharacter();
		_allCharacters.add(aCharacter);
		
		return aCharacter;
	}
	
	public void deleteCharacter(GameCharacter aCharacter) {
		_allCharacters.remove(aCharacter);
	}
	
	public void deleteAllCharacters() {
		_allCharacters.clear();
	}
	
	public GameCharacter getCharacter(int aCharacterID){
		
		GameCharacter theCharacter = null;
		Iterator<GameCharacter> anIterator = _allCharacters.iterator();
		
		while (anIterator.hasNext() && theCharacter == null) {
			GameCharacter nextCharacter = anIterator.next();
			if (nextCharacter.getId() == aCharacterID) {
				theCharacter = nextCharacter;
			}
		}
		
		return theCharacter;
	}
	
	public int getNextAvailableCharacterID() {
		
		int theReturn = 0;
			
		Iterator<GameCharacter> anIterator = _allCharacters.iterator();
		
		while (anIterator.hasNext()) {
			GameCharacter nextCharacter = anIterator.next();
			if (nextCharacter.getId() > theReturn ) {
				theReturn = nextCharacter.getId();
			}
		}
		
		theReturn++;
		return theReturn;
	}

	public GameCharacter getCharacter(String aCharacterName){
		
		GameCharacter theCharacter = null;
		Iterator<GameCharacter> anIterator = _allCharacters.iterator();
		
		while (anIterator.hasNext() && theCharacter == null) {
			GameCharacter nextCharacter = anIterator.next();
			if (nextCharacter.getName().equals(aCharacterName)) {
				theCharacter = nextCharacter;
			}
		}
		
		return theCharacter;
	}
	
	public boolean hasAnyCharacters(Player aPlayer){
		
		boolean playerHasCharacters = false;
		Iterator<GameCharacter> anIterator = _allCharacters.iterator();
		
		while (anIterator.hasNext() && (! playerHasCharacters)) {
			GameCharacter nextCharacter = anIterator.next();
			if (nextCharacter.getPlayer().equals(aPlayer)) {
				playerHasCharacters = true;
			}
		}
		
		return playerHasCharacters;
	}

}
