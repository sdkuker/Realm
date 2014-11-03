package com.sdk.realm.player.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sdk.realm.character.domain.CharacterWarehouse;
import com.sdk.realm.player.persistance.PlayerDAO;

public class PlayerWarehouse {

	private static PlayerWarehouse CURRENT = null;
	
	private Set<Player> _allPlayers = new HashSet<Player> ();
	PlayerDAO _playerDAO;
	
	public static PlayerWarehouse getCurrent() {
		
		if (CURRENT == null) {
			initializeCurrent(new PlayerDAO());
		}
		return CURRENT;
	}
	
	public static void reset() {
		CURRENT = null;
	}

	/*
	 * This is exposed only for testing - it should not be called by any domain consumer
	 */
	public static void setCurrent(PlayerWarehouse aWarehouse) {
		CURRENT = aWarehouse;
	}
	/*
	 * This is exposed only for testing - it should not be called by any domain consumer
	 */
	public synchronized static void initializeWithDAO(PlayerDAO aPlayerDAO) {
		if (CURRENT == null) {
			initializeCurrent(aPlayerDAO);			
		} else {
			CURRENT.setPlayerDAO(aPlayerDAO);
			CURRENT._allPlayers = aPlayerDAO.getAllPlayers();
		}
	}

	
	private synchronized static void initializeCurrent(PlayerDAO aPlayerDAO) {
		if (CURRENT == null) {
			PlayerWarehouse temp = new PlayerWarehouse();
			temp.setPlayerDAO(aPlayerDAO);
			CURRENT = temp;
			temp._allPlayers = temp._playerDAO.getAllPlayers();
		}
	}
	
	public void setPlayerDAO(PlayerDAO aPlayerDAO) {
		_playerDAO = aPlayerDAO;
	}
	
	public Player createPlayer() {
		Player theReturn = new Player();
		theReturn.setId(getNextAvailablePlayerID());
		_allPlayers.add(theReturn);
		
		return theReturn;
	}
	public Player createPlayer(String aPlayerName) {
		Player theReturn = createPlayer();
		theReturn.setName(aPlayerName);
		
		return theReturn;
	}
	
	public Player createPlayer(int id, String aPlayerName) {
		Player theReturn = new Player();
		theReturn.setId(id);
		theReturn.setName(aPlayerName);
		_allPlayers.add(theReturn);
		
		return theReturn;
	}

	
	public Set<Player> getAllPlayers() {
		return _allPlayers;
	}
	
	/* 
	 * Set all the players to those in the input argument.
	 */
	public void setAllPlayers(Set<Player> aSetOfPlayers) {
		_allPlayers = aSetOfPlayers;
	}
	
	/*
	 * Persist everything I currently have. Return true if everything worked ok
	 * and false if there was any problem at all.
	 */
	public boolean persistAll() {
		
		return _playerDAO.setAllPlayersTo(_allPlayers);
	}
	
	int getNextAvailablePlayerID() {
		
		int theReturn = 0;
			
		Iterator<Player> anIterator = _allPlayers.iterator();
		
		while (anIterator.hasNext()) {
			Player nextPlayer = anIterator.next();
			if (nextPlayer.getId() > theReturn ) {
				theReturn = nextPlayer.getId();
			}
		}
		
		theReturn++;
		return theReturn;
	}

	public Player getPlayer(int aPlayerID){
		
		Player thePlayer = null;
		Iterator<Player> anIterator = _allPlayers.iterator();
		
		while (anIterator.hasNext() && thePlayer == null) {
			Player nextPlayer = anIterator.next();
			if (nextPlayer.getId() == aPlayerID) {
				thePlayer = nextPlayer;
			}
		}
		
		return thePlayer;
	}
	
	public Player getPlayerNamed(String aPlayerName){
		
		Player thePlayer = null;
		Iterator<Player> anIterator = _allPlayers.iterator();
		
		while (anIterator.hasNext() && thePlayer == null) {
			Player nextPlayer = anIterator.next();
			if (nextPlayer.getName().equals(aPlayerName)) {
				thePlayer = nextPlayer;
			}
		}
		
		return thePlayer;
	}
	
	/*
	 * Return a description of any problems deleting the player
	 */
	public String deletePlayer(Player aPlayer, boolean persistPlayersAfterDeletion) {
		
		String errorDescription = canBeRemoved(aPlayer);
		
		if (errorDescription == null) {
			_allPlayers.remove(aPlayer);
			if (persistPlayersAfterDeletion) {
				persistAll();
			}
		}
		return errorDescription;
	}
	
	/*
	 * Return a description of any problems deleting any player
	 */
	public String deleteAllPlayers() {
		
		StringBuffer errorDescription = new StringBuffer();
		Set<Player> myPlayerSet = new HashSet<Player>();
		myPlayerSet.addAll(_allPlayers);
		
		
		for (Player aPlayer: myPlayerSet) {
			String individualPlayerErrorDescription = deletePlayer(aPlayer, false);
			if (individualPlayerErrorDescription != null) {
				errorDescription.append(individualPlayerErrorDescription);
				errorDescription.append('\n');
			}
		}
		persistAll();
		
		if (errorDescription.length() > 0) {
			return errorDescription.toString();
		} else {
			return null;
		}
	}

	/*
	 * If the player can be removed, return null.
	 * If the player can't be removed, return a string containing
	 * a description of why not.
	 */
	public String canBeRemoved(Player aPlayer) {

		String errorString = null;
		
		if (CharacterWarehouse.getCurrent().hasAnyCharacters(aPlayer)) {
			errorString = "Can not delete " +  aPlayer.getName() + " because he has characters.  You must delete his characters first.";
		}
		
		return errorString;
	}
	
}
