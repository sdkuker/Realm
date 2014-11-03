package com.sdk.realm.character.persistance;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.sdk.realm.character.domain.CharacterComparison;
import com.sdk.realm.character.domain.GameCharacter;
import com.sdk.realm.player.domain.Player;
import com.sdk.realm.player.domain.PlayerWarehouse;
import com.sdk.realm.player.persistance.PlayerDAO;

public class CharacterDAOTest {

	private static String TEST_FILE_LOCATION = "data//AllCharactersTest.xml";
	
	private static Player PLAYER_ONE;
	private static Player PLAYER_TWO;
	private static Player PLAYER_THREE;
	private static Player PLAYER_FOUR;
	
	public CharacterDAOTest() {
		
	}
	//@Test
	public void getAllCharacters() {
		
		assertTrue(getCharacterDAO().getAllCharacters().size() > 0);
	}
	
	CharacterDAO getCharacterDAO() {
		CharacterDAO temp = new CharacterDAO();
		temp.setFileLocation(TEST_FILE_LOCATION);
		return temp;
	}
	
	@Test
	public void addCharacters() {
		
		// first save the characters - this will cause them to be written to the file
		getCharacterDAO().setPlayerWarehouse(createPlayerWarehouse());
		List<GameCharacter> aBunchOCharacters = new ArrayList <GameCharacter> ();
		GameCharacter characterOne = new GameCharacter("CharacterOne",PLAYER_ONE, 1, 2, 3, 4, 5, true, false, 6, 7, 8, 9, 10, 11, 12, 13);
		characterOne.setId(1001);
		GameCharacter characterTwo = new GameCharacter("CharacterTwo",PLAYER_TWO, 1, 2, 3, 4, 5, true, false, 6, 7, 8, 9, 10, 11, 12, 13);
		characterTwo.setId(1002);
		GameCharacter characterThree = new GameCharacter("CharacterThree",PLAYER_THREE, 1, 2, 3, 4, 5, true, false, 6, 7, 8, 9, 10, 11, 12, 13);
		characterThree.setId(1003);
		GameCharacter characterFour = new GameCharacter("CharacterFour",PLAYER_FOUR, 1, 2, 3, 4, 5, true, false, 6, 7, 8, 9, 10, 11, 12, 13);
		characterFour.setId(1004);
		aBunchOCharacters.add(characterOne);
		aBunchOCharacters.add(characterTwo);
		aBunchOCharacters.add(characterThree);
		aBunchOCharacters.add(characterFour);
		boolean success = getCharacterDAO().setAllCharactersTo(aBunchOCharacters);
		
		// using a new dao, read the characters.  this will cause them to be read from the 
		// file - make sure they are equivalent.
		getCharacterDAO().setPlayerWarehouse(createPlayerWarehouse());

		List<GameCharacter> newCharacters = getCharacterDAO().getAllCharacters();
		assertTrue(success && isEquivalent(aBunchOCharacters, newCharacters));
	}
	
	private PlayerWarehouse createPlayerWarehouse() {
		
		PlayerDAO aDAO = new PlayerDAO();
		aDAO.setFileLocation(TEST_FILE_LOCATION);
		
		PlayerWarehouse aWarehouse = new PlayerWarehouse();
		aWarehouse.setPlayerDAO(aDAO);
		PLAYER_ONE = aWarehouse.createPlayer("PlayerOne");
		PLAYER_TWO = aWarehouse.createPlayer("PlayerTwo");
		PLAYER_THREE = aWarehouse.createPlayer("PlayerThree");
		PLAYER_FOUR = aWarehouse.createPlayer("PlayerFour");
		
		Set<Player> aSetOfPlayers = new HashSet<Player>();
		aSetOfPlayers.add(PLAYER_ONE);
		aSetOfPlayers.add(PLAYER_TWO);
		aSetOfPlayers.add(PLAYER_THREE);
		aSetOfPlayers.add(PLAYER_FOUR);
		
		PlayerWarehouse.setCurrent(aWarehouse);
		
		return aWarehouse;		
	}
	
	
	/*
	 * make sure the sets are equivalent and the contents of the sets are equivalent.
	 */
	private boolean isEquivalent(List<GameCharacter> listOne, List<GameCharacter> listTwo) {
		
		boolean areListsEquivalent = false;
		if (listOne == null && listTwo == null) {
			areListsEquivalent = true;
		} else {
			areListsEquivalent = listOne.equals(listTwo);
			if (areListsEquivalent) {
				Iterator<GameCharacter> anIterator = listOne.iterator();
				boolean nonEquivalentCharacterFound = false;
				while (anIterator.hasNext() && (! nonEquivalentCharacterFound)) {
					GameCharacter aCharacter = anIterator.next();
					nonEquivalentCharacterFound = ! CharacterComparison.areAllFieldsEqual(aCharacter, getCharacter(listTwo, aCharacter.getId()));
				}
				areListsEquivalent = ! nonEquivalentCharacterFound;
			}
		}
		return areListsEquivalent;
	}

	/*
	 * return the character from the collection with the desired id.
	 * return null if one is not in the collection.
	 */
	private GameCharacter getCharacter(List<GameCharacter> listOfCharacters, int aCharacterID) {
		
		GameCharacter theReturn = null;
		if (listOfCharacters!= null) {
			Iterator<GameCharacter> anIterator = listOfCharacters.iterator();
			while (anIterator.hasNext() && theReturn == null) {
				GameCharacter aCharacter = anIterator.next();
				if (aCharacter.getId() == aCharacterID) {
					theReturn = aCharacter;
				}
			}
		} 
		return theReturn;
	}

}
