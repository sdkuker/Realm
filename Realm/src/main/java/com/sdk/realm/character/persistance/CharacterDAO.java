package com.sdk.realm.character.persistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.sdk.realm.character.domain.DefensiveAttributes;
import com.sdk.realm.character.domain.GameCharacter;
import com.sdk.realm.player.domain.Player;
import com.sdk.realm.player.domain.PlayerWarehouse;

public class CharacterDAO {

	private static final Logger _log = Logger.getLogger(CharacterDAO.class);
	
	private String _fileLocation = "data//AllCharacters.xml";
	private List<GameCharacter> _allCharacters = new ArrayList<GameCharacter>();
	private PlayerWarehouse _myPlayerWarehouse = null;
	
	public CharacterDAO() {
	}

	/*
	 * read all the characters from the data files, then return that list.
	 * the data file must be in the location specified in the _fileLocation
	 * field.
	 */
	public List<GameCharacter> getAllCharacters() {
		
		loadDataFromFile();
		return _allCharacters;
	}
	
	void setFileLocation(String aFileLocation) {
		_fileLocation = aFileLocation;
	}
	
	private void loadDataFromFile() {
		
		File characterFile = new File(_fileLocation);
		_log.debug("Loading character data from: " + characterFile.getAbsolutePath());
		loadFile(characterFile);
		_log.debug("Total of: " + _allCharacters.size() + " characters loaded.");
	}
	
	/*
	 * unmarshall the file, covert to domain objects and load into the internal collection
	 */
	private void loadFile(File aFile) {
		
		try {
			JAXBContext jc = JAXBContext.newInstance("com.sdk.realm.character.persistance");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			JAXBElement<CharacterLibraryType>  aJAXBElement = (JAXBElement <CharacterLibraryType>) unmarshaller.unmarshal(aFile);
			CharacterLibraryType aCharacterLibraryType = (CharacterLibraryType) aJAXBElement.getValue();
			convertToDomainObjectsAndStore(aCharacterLibraryType);
		} catch (Exception e) {
			_log.error("unable to unmarshall file named: "  + aFile.getName(), e);
		}
	}
	
	private void convertToDomainObjectsAndStore(CharacterLibraryType aCharacterLibraryType) {
		
		for (CharacterType aCharacterType: aCharacterLibraryType.getCharacterCollection().getCharacter()) {
			_allCharacters.add(createCharacter(aCharacterType));
		}
	}

	private GameCharacter createCharacter(CharacterType aCharacterType) {
		
		GameCharacter theReturn = new GameCharacter();
		
		theReturn.setAlertnessSkill(aCharacterType.getAlertnessSkill());
		theReturn.setArmorType(aCharacterType.getArmorType());
		theReturn.setHasAdrenalDefense(aCharacterType.isHasAdrenalDefense());
		theReturn.setHasShield(aCharacterType.isHasShield());
		theReturn.setId(new Integer(aCharacterType.getID()).intValue());
		theReturn.setInitiative(aCharacterType.getInitiative());
		theReturn.setInitiativeModifier(aCharacterType.getInitiativeModifier());
		theReturn.setLevel(aCharacterType.getLevel());
		theReturn.setName(aCharacterType.getName());
		theReturn.setObservationSkill(aCharacterType.getObservationSkill());
		theReturn.setPerception(aCharacterType.getPerception());
		Player myPlayer = getPlayerWarehouse().getPlayer(new Integer(aCharacterType.getPlayerID()).intValue());
		theReturn.setPlayer(myPlayer);
		theReturn.setSenseAmbushSkill(aCharacterType.getSenseAmbushSkill());
		theReturn.setStalkSkill(aCharacterType.getStalkSkill());
		theReturn.setDefensiveAttributes(createDefensiveAttributes(aCharacterType.getDefensiveAttributes()));
		//TODO
		// hit points were added in version 0.5.  this null check is for backwards compatability.  Get rid of
		// it in version 0.6 when marks' files have been updated to include this field.
		if (aCharacterType.getHitPoints() != null) {
			theReturn.setHitPoints(aCharacterType.getHitPoints());
		} else {
			theReturn.setHitPoints(0);
		}
		//TODO - remove this code.
		// the hit point modifier was added in version 0.6.  this null check is for backwards compatability.  Get rid of
		// it in version 0.7 when marks' files have been updated to include this field.
		if (aCharacterType.getHitPointsModifier() != null) {
			theReturn.setHitPointsModifier(aCharacterType.getHitPointsModifier());
		} else {
			theReturn.setHitPointsModifier(0);
		}

		//TODO - remove this code...
		// Will and will modifiers were added in version 0.6.  this null check is for backwards compatability.  Get rid of
		// it in version 0.7 when marks' files have been updated to include this field.
		if (aCharacterType.getWill() != null) {
			theReturn.setWill(aCharacterType.getWill());
			theReturn.setWillModifier(aCharacterType.getWillModifier());
		} else {
			theReturn.setHitPoints(0);
			theReturn.setWill(0);
			theReturn.setWillModifier(0);
		}

		return theReturn;
	}
	
	private DefensiveAttributes createDefensiveAttributes(CharacterDefensiveAttributesType aDefensiveAttributesType) {
		
		DefensiveAttributes theReturn = new DefensiveAttributes();
		
		theReturn.setAdrenalineDefense(aDefensiveAttributesType.getAdrenalineDefense());
		theReturn.setArmorChoice(aDefensiveAttributesType.getArmorChoice());
		theReturn.setArmorOnArmor(aDefensiveAttributesType.getArmorOnArmor());
		theReturn.setMiscItemChoice(aDefensiveAttributesType.getMiscItemChoice());
		theReturn.setQuicknessBonus(aDefensiveAttributesType.getQuicknessBonus());
		theReturn.setRacialModifier(aDefensiveAttributesType.getRacialModifier());
		theReturn.setShieldChoice(aDefensiveAttributesType.getShieldChoice());
		theReturn.setSkillChoice1(aDefensiveAttributesType.getSkillChoice1());
		theReturn.setSkillChoice2(aDefensiveAttributesType.getSkillChoice2());
		theReturn.setSpecialAbility(aDefensiveAttributesType.getSpecialAbility());
		
		return theReturn;
	}
	
	private PlayerWarehouse getPlayerWarehouse() {
		
		PlayerWarehouse theReturn = _myPlayerWarehouse;
		if (theReturn == null) {
			theReturn = PlayerWarehouse.getCurrent();
		}
		return theReturn;
	}
	
	/*
	 * only here to support testing.
	 */
	protected void setPlayerWarehouse(PlayerWarehouse aWarehouse) {
		_myPlayerWarehouse = aWarehouse;
	}
	
	/*
	 * replace all the characters I know about with the ones defined in aListOfCharacters.  do this
	 * in my in-memory collection as well as on the file system.
	 */
	public boolean setAllCharactersTo(List<GameCharacter> aListOfCharacters) {
		
		ObjectFactory anObjectFactory = new ObjectFactory();
		CharacterLibraryType aCharacterLibraryType = convertToJAXBObjects(aListOfCharacters, anObjectFactory);
		JAXBElement<CharacterLibraryType> jaxbElement = anObjectFactory.createCharacterLibrary(aCharacterLibraryType);
		boolean persistanceSucceeded = true;
		try {
			FileOutputStream anOutputStream = new FileOutputStream(_fileLocation);
			_log.debug("Saving characters to file system: " + aListOfCharacters.size() + " characters are being saved to file: " + _fileLocation);
			JAXBContext jc = JAXBContext.newInstance("com.sdk.realm.character.persistance");
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
			marshaller.marshal(jaxbElement, anOutputStream);
			_log.debug("Saving characters to the files system succeeded");
		} catch (JAXBException e) {
			_log.error("Unable to save the character data - JAXB Exception: ", e);
			persistanceSucceeded = false;
		} catch (FileNotFoundException e1) {
			_log.error("Unable to save the character data - File Not Found Exception: ", e1);
			persistanceSucceeded = false;
		}
		_allCharacters = aListOfCharacters;
		
		return persistanceSucceeded;
	}
	
	private CharacterLibraryType convertToJAXBObjects(List<GameCharacter> aListOfCharacters, ObjectFactory anObjectFactory) {
		
		CharacterLibraryType aCharacterLibraryType = anObjectFactory.createCharacterLibraryType();
		CharacterCollectionType aCharacterCollectionType = anObjectFactory.createCharacterCollectionType();
		aCharacterLibraryType.setCharacterCollection(aCharacterCollectionType);
		for (GameCharacter aCharacter : aListOfCharacters) {
			CharacterType aCharacterType = anObjectFactory.createCharacterType();
			aCharacterType.setAlertnessSkill(aCharacter.getAlertnessSkill());
			aCharacterType.setArmorType(aCharacter.getArmorType());
			aCharacterType.setHasAdrenalDefense(aCharacter.isHasAdrenalDefense());
			aCharacterType.setHasShield(aCharacter.isHasShield());
			aCharacterType.setInitiative(aCharacter.getInitiative());
			aCharacterType.setInitiativeModifier(aCharacter.getInitiativeModifier());
			aCharacterType.setID(new Integer(aCharacter.getId()).toString());
			aCharacterType.setLevel(aCharacter.getLevel());
			aCharacterType.setName(aCharacter.getName());
			aCharacterType.setObservationSkill(aCharacter.getObservationSkill());
			aCharacterType.setPerception(aCharacter.getPerception());
			aCharacterType.setPlayerID(new Integer(aCharacter.getPlayer().getId()).toString());
			aCharacterType.setSenseAmbushSkill(aCharacter.getSenseAmbushSkill());
			aCharacterType.setStalkSkill(aCharacter.getStalkSkill());
			aCharacterType.setDefensiveAttributes(createCharacterDefensiveAttributesType(aCharacter.getDefensiveAttributes(), anObjectFactory));
			aCharacterType.setHitPoints(aCharacter.getHitPoints());
			aCharacterType.setHitPointsModifier(aCharacter.getHitPointsModifier());
			aCharacterType.setWill(aCharacter.getWill());
			aCharacterType.setWillModifier(aCharacter.getWillModifier());
			aCharacterCollectionType.getCharacter().add(aCharacterType);
		}
		return aCharacterLibraryType;
	}
	
	private CharacterDefensiveAttributesType createCharacterDefensiveAttributesType(DefensiveAttributes aDefensiveAttributes, ObjectFactory anObjectFactory) {
		
		CharacterDefensiveAttributesType aDefensiveAttributesType = anObjectFactory.createCharacterDefensiveAttributesType();
		aDefensiveAttributesType.setAdrenalineDefense(aDefensiveAttributes.getAdrenalineDefense());
		aDefensiveAttributesType.setArmorChoice(aDefensiveAttributes.getArmorChoice());
		aDefensiveAttributesType.setArmorOnArmor(aDefensiveAttributes.getArmorOnArmor());
		aDefensiveAttributesType.setMiscItemChoice(aDefensiveAttributes.getMiscItemChoice());
		aDefensiveAttributesType.setQuicknessBonus(aDefensiveAttributes.getQuicknessBonus());
		aDefensiveAttributesType.setRacialModifier(aDefensiveAttributes.getRacialModifier());
		aDefensiveAttributesType.setShieldChoice(aDefensiveAttributes.getShieldChoice());
		aDefensiveAttributesType.setSkillChoice1(aDefensiveAttributes.getSkillChoice1());
		aDefensiveAttributesType.setSkillChoice2(aDefensiveAttributes.getSkillChoice2());
		aDefensiveAttributesType.setSpecialAbility(aDefensiveAttributes.getSpecialAbility());
		
		return aDefensiveAttributesType;
	}
}
