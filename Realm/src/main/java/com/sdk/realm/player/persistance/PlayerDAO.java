package com.sdk.realm.player.persistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.sdk.realm.player.domain.Player;
import com.sdk.realm.player.domain.PlayerWarehouse;

public class PlayerDAO {

	private static final Logger _log = Logger.getLogger(PlayerDAO.class);
	private String _fileLocation = "data//AllPlayers.xml";
	
	private Set<Player> _allPlayers = new HashSet<Player>();
	
	public PlayerDAO() {
	}

	/*
	 * read all the players from the data files, then return that list.
	 * the data files must be in the 'data' directory and must have 'player' 
	 * in their file name.
	 */
	public Set<Player> getAllPlayers() {
		
		if (_allPlayers.size() == 0){
			loadDataFromFile();
		}

		return _allPlayers;
	}
	
	private synchronized void loadDataFromFile() {
		
		File playerFile = new File(_fileLocation);
		_log.debug("Loading player data from: " + playerFile.getAbsolutePath());
		loadFile(playerFile);
		_log.debug("Total of: " + _allPlayers.size() + " players loaded.");
	}
	
	/*
	 * unmarshall the file, covert to domain objects and load into the internal collection
	 */
	private void loadFile(File aFile) {
		
		try {
			JAXBContext jc = JAXBContext.newInstance("com.sdk.realm.player.persistance");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			JAXBElement<PlayerWarehouseType>  aJAXBElement = (JAXBElement <PlayerWarehouseType>) unmarshaller.unmarshal(aFile);
			PlayerWarehouseType aPlayerWarehouseType = (PlayerWarehouseType) aJAXBElement.getValue();
			convertToDomainObjectsAndStore(aPlayerWarehouseType, aFile);
		} catch (Exception e) {
			_log.error("unable to unmarshall file named: "  + aFile.getName(), e);
		}
	}
	
	private void convertToDomainObjectsAndStore(PlayerWarehouseType aPlayerWarehouseType, File aFile) {
		
		for (PlayerType aPlayerType: aPlayerWarehouseType.getPlayerCollection().getPlayer()) {
			Player aPlayer = PlayerWarehouse.getCurrent().createPlayer(new Integer(aPlayerType.getID()).intValue(), aPlayerType.getName());
			_allPlayers.add(aPlayer);
		}
		
	}

	public void setFileLocation(String aFileLocation) {
		_fileLocation = aFileLocation;
	}
	/*
	 * replace all the players I know about with the ones defined in aSetOfPlayers.  do this
	 * in my in-memory collection as well as on the file system.
	 */
	public boolean setAllPlayersTo(Set<Player> aSetOfPlayers) {
		
		ObjectFactory anObjectFactory = new ObjectFactory();
		PlayerWarehouseType aPlayerWarehouseType = convertToJAXBObjects(aSetOfPlayers, anObjectFactory);
		JAXBElement<PlayerWarehouseType> jaxbElement = anObjectFactory.createPlayerWarehouse(aPlayerWarehouseType);
		boolean persistanceSucceeded = true;
		try {
			FileOutputStream anOutputStream = new FileOutputStream(_fileLocation);
			_log.debug("Saving players to file system: " + aSetOfPlayers.size() + " players are being saved to file: " + _fileLocation);
			JAXBContext jc = JAXBContext.newInstance("com.sdk.realm.player.persistance");
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
			marshaller.marshal(jaxbElement, anOutputStream);
			_log.debug("Saving players to the files system succeeded");
		} catch (JAXBException e) {
			_log.error("Unable to save the player data - JAXB Exception: ", e);
			persistanceSucceeded = false;
		} catch (FileNotFoundException e1) {
			_log.error("Unable to save the player data - File Not Found Exception: ", e1);
			persistanceSucceeded = false;
		}
		_allPlayers = aSetOfPlayers;
		
		return persistanceSucceeded;
	}
	
	private PlayerWarehouseType convertToJAXBObjects(Set<Player> aSetOfPlayers, ObjectFactory anObjectFactory) {
		
		PlayerWarehouseType aPlayerWarehouseType = anObjectFactory.createPlayerWarehouseType();
		PlayerCollectionType aPlayerCollectionType = anObjectFactory.createPlayerCollectionType();
		aPlayerWarehouseType.setPlayerCollection(aPlayerCollectionType);
		for (Player aPlayer : aSetOfPlayers) {
			PlayerType aPlayerType = anObjectFactory.createPlayerType();
			aPlayerType.setID(new Integer(aPlayer.getId()).toString());
			aPlayerType.setName(aPlayer.getName());
			aPlayerCollectionType.getPlayer().add(aPlayerType);
		}
		return aPlayerWarehouseType;
	}
}
