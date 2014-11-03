package com.sdk.realm.player.domain;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Test;

import com.sdk.realm.player.persistance.PlayerDAO;

public class PlayerWarehouseTest {
	
	private static final String TEST_FILE_LOCATION = "data//AllPlayersTest.xml";

	public PlayerWarehouseTest() {
		
	}
	
	@After
	public void cleanUp() {
		PlayerWarehouse.reset();
	}
	//@Test
	public void getAllPlayers() {
		
		PlayerDAO aDAO = getPlayerDAO();
		aDAO.setFileLocation(TEST_FILE_LOCATION);
		
		assertTrue(aDAO.getAllPlayers().size() > 0);
	}
	
	private PlayerDAO getPlayerDAO() {
		
		PlayerDAO aDAO = new PlayerDAO();
		aDAO.setFileLocation(TEST_FILE_LOCATION);
		return aDAO;
	}
	
	@Test
	public void addPlayers() {
		
		// first save the players - this will cause them to be written to the file
		PlayerDAO aDAO = getPlayerDAO();
		PlayerWarehouse.initializeWithDAO(aDAO);	
		Set<Player> aBunchOPlayers = new HashSet <Player> ();
		aBunchOPlayers.add(PlayerWarehouse.getCurrent().createPlayer("Stevie"));
		aBunchOPlayers.add(PlayerWarehouse.getCurrent().createPlayer("Beth"));
		aBunchOPlayers.add(PlayerWarehouse.getCurrent().createPlayer("Michelle"));
		aBunchOPlayers.add(PlayerWarehouse.getCurrent().createPlayer("Marie"));
		aBunchOPlayers.add(PlayerWarehouse.getCurrent().createPlayer("AmberTheDog"));
		boolean success = aDAO.setAllPlayersTo(aBunchOPlayers);
		
		// using a new dao, read the players.  this will cause them to be read from the 
		// file - make sure the sets are equivalent and the contents of the sets are equivalent.
		Set<Player> newPlayers = getPlayerDAO().getAllPlayers();
		assertTrue(success && isEquivalent(aBunchOPlayers, newPlayers));
	}
	
	/*
	 * make sure the sets are equivalent and the contents of the sets are equivalent.
	 */
	private boolean isEquivalent(Set<Player> setOne, Set<Player> setTwo) {
		
		System.out.println("set one size: " + setOne.size() + " set two size: " + setTwo.size());
		boolean areSetsEquivalent = false;
		if (setOne == null && setTwo == null) {
			areSetsEquivalent = true;
		} else {
			areSetsEquivalent = setOne.equals(setTwo);
			if (areSetsEquivalent) {
				Iterator<Player> anIterator = setOne.iterator();
				boolean nonEquivalentPlayerFound = false;
				while (anIterator.hasNext() && (! nonEquivalentPlayerFound)) {
					Player aPlayer = anIterator.next();
					nonEquivalentPlayerFound = ! PlayerComparison.areAllFieldsEqual(aPlayer, getPlayer(setTwo, aPlayer.getId()));
				}
				areSetsEquivalent = ! nonEquivalentPlayerFound;
			}
		}
		return areSetsEquivalent;
	}
	
	/*
	 * return the player from the collection with the desired id.
	 * return null if one is not in the collection.
	 */
	private Player getPlayer(Set<Player> setOfPlayers, int aPlayerID) {
		
		Player theReturn = null;
		if (setOfPlayers!= null) {
			Iterator<Player> anIterator = setOfPlayers.iterator();
			while (anIterator.hasNext() && theReturn == null) {
				Player aPlayer = anIterator.next();
				if (aPlayer.getId() == aPlayerID) {
					theReturn = aPlayer;
				}
			}
		} 
		return theReturn;
	}
}
