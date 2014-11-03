package com.sdk.realm.combat.persistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.sdk.realm.character.domain.CharacterWarehouse;
import com.sdk.realm.character.domain.GameCharacter;
import com.sdk.realm.combat.domain.CharacterCombatRoundStatistics;
import com.sdk.realm.combat.domain.CombatEncounter;
import com.sdk.realm.combat.domain.Round;
import com.sdk.realm.criticalhit.domain.CriticalHit;
import com.sdk.realm.criticalhit.domain.CriticalHitLibrary;

public class CombatEncounterDAO {

	private static final Logger _log = Logger
			.getLogger(CombatEncounterDAO.class);
	private static final String OPEN_STATUS_STRING = "Open";
	private static final String CLOSED_STATUS_STRING = "Closed";
	private static String OVERALL_DATA_DIRECTORY_LOCATION = "data";
	private static String COMBAT_DATA_DIRECTORY_LOCATION = "combat";
	private static final String FILE_EXTENSION = "xml";

	private List<CombatEncounter> _allEncounters = new ArrayList<CombatEncounter>();
	private CharacterWarehouse _myCharacterWarehouse;

	public CombatEncounterDAO() {
	}

	/*
	 * read all the combat encounters from the data files, then return that
	 * list. the data files must be in the 'data/combat' directory.
	 */
	public List<CombatEncounter> getAllEncounters() {

		if (_allEncounters.isEmpty()) {
			loadDataFromFiles();
		}
		return _allEncounters;
	}

	private void loadDataFromFiles() {

		File encounterFileDirectory = new File(combatDataDirectoryPath());
		_log.debug("Loading combat encounter data from directory: "
				+ encounterFileDirectory.getAbsolutePath());
		File[] encounterFiles = encounterFileDirectory.listFiles();
		if (encounterFiles != null) {
			for (File anEncounterFile : encounterFiles) {
				_log.debug("Loading combat encounter data from file: "
						+ anEncounterFile.getAbsolutePath());
				loadFile(anEncounterFile);
			}
		}
		_log.debug("Total of: " + _allEncounters.size() + " encounters loaded.");
	}

	/*
	 * unmarshall the file, covert to domain objects and load into the internal
	 * collection
	 */
	private void loadFile(File aFile) {

		try {
			JAXBContext jc = JAXBContext
					.newInstance("com.sdk.realm.combat.persistance");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			JAXBElement<CombatEncounterType> aJAXBElement = (JAXBElement<CombatEncounterType>) unmarshaller
					.unmarshal(aFile);
			CombatEncounterType aCombatEncounterType = (CombatEncounterType) aJAXBElement
					.getValue();
			convertToDomainObjectsAndStore(aCombatEncounterType);
		} catch (Exception e) {
			_log.error("unable to unmarshall file named: " + aFile.getName(), e);
			throw new RuntimeException(e);
		}
	}

	private void convertToDomainObjectsAndStore(
			CombatEncounterType aCombatEncounterType) {

		CombatEncounter theEncounter = new CombatEncounter();

		theEncounter.setId(UUID.fromString(aCombatEncounterType.getID()));
		theEncounter.setDateLastModified(new Date(aCombatEncounterType
				.getLastModified()));
		theEncounter.setDescription(aCombatEncounterType.getDescription());

		for (RoundType aRoundType : aCombatEncounterType.getRounds().getRound()) {
			theEncounter.addRound(createRound(aRoundType));
		}

		_allEncounters.add(theEncounter);
	}

	private Round createRound(RoundType aRoundType) {

		Round theReturn = new Round();

		theReturn.setRoundNumber(aRoundType.getRoundNumber());
		if (OPEN_STATUS_STRING.equals(aRoundType.getStatus())) {
			theReturn.setStatus(Round.STATUS.open);
		} else {
			theReturn.setStatus(Round.STATUS.closed);
		}
		for (CharacterCombatRoundStatisticsType aStatisticsType : aRoundType
				.getCharacterCombatRoundStatistics()
				.getCharacterCombatRoundStatistic()) {
			theReturn.addStatistic(createStatistic(aStatisticsType));
		}

		return theReturn;
	}

	private CharacterCombatRoundStatistics createStatistic(
			CharacterCombatRoundStatisticsType aCharacterCombatRoundStatisticsType) {

		CharacterCombatRoundStatistics theReturn = new CharacterCombatRoundStatistics();

		GameCharacter myCharacter = getCharacterWarehouse().getCharacter(
				aCharacterCombatRoundStatisticsType.getCharacterId());
		if (myCharacter == null) {
			String explaination = "No character found with Id: "
					+ aCharacterCombatRoundStatisticsType.getCharacterId()
					+ ".  Unable to marshall the combat.";
			IllegalArgumentException myError = new IllegalArgumentException(
					explaination);
			_log.error(explaination, myError);
			throw myError;
		} else {
			theReturn.setCharacter(myCharacter);
		}
		theReturn.setInitiative(aCharacterCombatRoundStatisticsType
				.getInitiative());
		theReturn.setAlertness(aCharacterCombatRoundStatisticsType
				.getAlertness());
		theReturn.setObservation(aCharacterCombatRoundStatisticsType
				.getObservation());
		theReturn.setTotalHits(aCharacterCombatRoundStatisticsType
				.getTotalHits());
		theReturn
				.setBleeding(aCharacterCombatRoundStatisticsType.getBleeding());
		theReturn.setRoundsStillStunned(aCharacterCombatRoundStatisticsType
				.getRoundsStillStunned());
		theReturn.setNegativeModifier(aCharacterCombatRoundStatisticsType
				.getNegativeModifier());
		theReturn.setRegeneration(aCharacterCombatRoundStatisticsType
				.getRegeneration());
		theReturn.setHitsAtStartOfRound(aCharacterCombatRoundStatisticsType
				.getHitsAtStartOfRound());
		theReturn.setHitsTakenDuringRound(aCharacterCombatRoundStatisticsType
				.getHitsTakenDuringRound());
		theReturn
				.setCharacterTotalHitPointsAtStartOfRound(aCharacterCombatRoundStatisticsType
						.getCharacterTotalHitPointsAtStartOfRound());
		theReturn
				.setCriticalHitsSuffered(createCriticalHitsSufferedList(aCharacterCombatRoundStatisticsType
						.getCriticalHitsSuffered()));

		return theReturn;
	}

	private List<CriticalHit> createCriticalHitsSufferedList(
			CriticalHitReferenceCollectionType aCriticalHitCollectionType) {

		List<CriticalHit> theReturn = new ArrayList<CriticalHit>();

		if (aCriticalHitCollectionType != null) {
			for (CriticalHitReferenceType aCriticalHitReferenceType : aCriticalHitCollectionType
					.getCriticalHitReference()) {
				CriticalHit aCriticalHit = CriticalHitLibrary.getCurrent()
						.getCriticalHit(aCriticalHitReferenceType.getType(),
								aCriticalHitReferenceType.getSeverity(),
								aCriticalHitReferenceType.getRangeMinimum(),
								aCriticalHitReferenceType.getRangeMaximum());
				if (aCriticalHit != null) {
					theReturn.add(aCriticalHit);
				} else {
					StringBuilder explaination = new StringBuilder();
					explaination.append("Unable to find a critical hit in the critical hit libary");
					explaination.append(" for a hit reference of type: ");
					explaination.append(aCriticalHitReferenceType.getType());
					explaination.append(" and severity: ");
					explaination.append(aCriticalHitReferenceType.getSeverity());
					explaination.append(" with min range value of: ");
					explaination.append(aCriticalHitReferenceType.getRangeMinimum());
					explaination.append(" with max range value of: ");
					explaination.append(aCriticalHitReferenceType.getRangeMaximum());
					IllegalArgumentException myError = new IllegalArgumentException(
							explaination.toString());
					_log.error(explaination, myError);
					throw myError;
				}
			}			
		}

		
		return theReturn;
	}

	private CharacterWarehouse getCharacterWarehouse() {

		CharacterWarehouse theReturn = _myCharacterWarehouse;
		if (theReturn == null) {
			theReturn = CharacterWarehouse.getCurrent();
		}
		return theReturn;
	}

	/*
	 * only here to support testing.
	 */
	protected void setCharacterWarehouse(CharacterWarehouse aWarehouse) {
		_myCharacterWarehouse = aWarehouse;
	}

	/*
	 * Remove from the collection and delete the file
	 */
	public boolean delete(CombatEncounter anEncounter) {

		boolean theReturn = false;

		File encounterFile = new File(
				completeFilePath(anEncounter.getFileName()));
		if (encounterFile.delete()) {
			theReturn = _allEncounters.remove(anEncounter);
		}
		return theReturn;
	}

	/*
	 * Persist the encounter - make sure it's in my collection of them and
	 * persist to the file system. You can only persist if there is a file name
	 * specified though.
	 */
	public CombatEncounterPersistenceResult persist(CombatEncounter anEncounter) {

		CombatEncounterPersistenceResult theReturn = validateEncounter(anEncounter);
		if (!theReturn.hasValidationErrors()) {
			boolean successfulPersistence = persistEncounter(anEncounter);
			if (!successfulPersistence) {
				theReturn = new CombatEncounterPersistenceResult(
						CombatEncounterPersistenceResult.STATUS.notPersisted,
						CombatEncounterPersistenceResult.REASON.unexpectedError);
			}
		}
		return theReturn;
	}

	private CombatEncounterPersistenceResult validateEncounter(
			CombatEncounter anEncounter) {

		CombatEncounterPersistenceResult theReturn;
		boolean isFileNameInvalid = true;
		boolean isFileNameAlreadyUsed = false;
		if (anEncounter.getFileName() != null
				&& anEncounter.getFileName().length() > 0) {
			isFileNameInvalid = false;
		}

		if (!isFileNameInvalid) {
			for (CombatEncounter oneOfMyEncounters : _allEncounters) {
				if (anEncounter.getFileName().equals(
						oneOfMyEncounters.getFileName())
						&& (!anEncounter.getId().equals(
								oneOfMyEncounters.getId()))) {
					isFileNameAlreadyUsed = true;
				}
			}
		}
		if (isFileNameAlreadyUsed | isFileNameInvalid) {
			theReturn = new CombatEncounterPersistenceResult(
					CombatEncounterPersistenceResult.STATUS.notPersisted,
					CombatEncounterPersistenceResult.REASON.validationError);
			if (isFileNameAlreadyUsed) {
				theReturn
						.addValidationError(CombatEncounterPersistenceResult.VALIDATION_ERROR.fileNameAlreadyUsed);
			}
			if (isFileNameInvalid) {
				theReturn
						.addValidationError(CombatEncounterPersistenceResult.VALIDATION_ERROR.noFileNameSpecified);
			}
		} else {
			theReturn = new CombatEncounterPersistenceResult(
					CombatEncounterPersistenceResult.STATUS.persisted, null);
		}
		return theReturn;
	}

	private String completeFilePath(String aFileName) {

		StringBuffer aBuffer = new StringBuffer(combatDataDirectoryPath());
		aBuffer.append("//");
		aBuffer.append(aFileName);
		aBuffer.append(".");
		aBuffer.append(FILE_EXTENSION);

		return aBuffer.toString();
	}

	private String combatDataDirectoryPath() {

		StringBuffer aBuffer = new StringBuffer(OVERALL_DATA_DIRECTORY_LOCATION);
		aBuffer.append("//");
		aBuffer.append(COMBAT_DATA_DIRECTORY_LOCATION);
		return aBuffer.toString();

	}

	private boolean persistEncounter(CombatEncounter anEncounter) {

		createCombatFileDirectory();
		// always update the last modified date/time before saving it
		anEncounter.setDateLastModified(new Date());
		ObjectFactory anObjectFactory = new ObjectFactory();
		CombatEncounterType aCombatEncounterType = convertToJAXBObjects(
				anEncounter, anObjectFactory);
		JAXBElement<CombatEncounterType> jaxbElement = anObjectFactory
				.createCombatEncounter(aCombatEncounterType);
		boolean persistanceSucceeded = true;
		try {
			FileOutputStream anOutputStream = new FileOutputStream(
					completeFilePath(anEncounter.getFileName()));
			_log.debug("Saving combat encounter in file: "
					+ completeFilePath(anEncounter.getFileName()));
			JAXBContext jc = JAXBContext
					.newInstance("com.sdk.realm.combat.persistance");
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					new Boolean(true));
			marshaller.marshal(jaxbElement, anOutputStream);
			anOutputStream.close();
			_log.debug("Saving combat encounter to the file system succeeded");
		} catch (JAXBException e) {
			_log.error(
					"Unable to save the combat encounter data - JAXB Exception: ",
					e);
			persistanceSucceeded = false;
		} catch (FileNotFoundException e1) {
			_log.error(
					"Unable to save the combat encounter data - File Not Found Exception: ",
					e1);
			persistanceSucceeded = false;
		} catch (IOException e2) {
			_log.error("Unable to save the combat encounter - IO Exception: ",
					e2);
		}
		if (!_allEncounters.contains(anEncounter)) {
			_allEncounters.add(anEncounter);
		}

		return persistanceSucceeded;
	}

	/*
	 * Create this directory if it doesn't already exist.
	 */
	private void createCombatFileDirectory() {

		File combatFileDirectory = new File(combatDataDirectoryPath());
		if (!combatFileDirectory.exists()) {
			combatFileDirectory.mkdir();
		}
	}

	private CombatEncounterType convertToJAXBObjects(
			CombatEncounter anEncounter, ObjectFactory anObjectFactory) {

		CombatEncounterType aCombatEncounterType = anObjectFactory
				.createCombatEncounterType();

		aCombatEncounterType.setDescription(anEncounter.getDescription());
		aCombatEncounterType.setID(anEncounter.getId().toString());
		aCombatEncounterType.setLastModified(anEncounter.getDateLastModified()
				.getTime());

		RoundCollectionType aRoundCollectionType = anObjectFactory
				.createRoundCollectionType();
		aCombatEncounterType.setRounds(aRoundCollectionType);
		for (Round aRound : anEncounter.getRounds()) {
			RoundType aRoundType = anObjectFactory.createRoundType();
			aRoundType.setRoundNumber(aRound.getRoundNumber());
			if (Round.STATUS.open.equals(aRound.getStatus())) {
				aRoundType.setStatus(OPEN_STATUS_STRING);
			} else {
				aRoundType.setStatus(CLOSED_STATUS_STRING);
			}
			CharacterCombatRoundStatisticsCollectionType aStatisticsCollectionType = anObjectFactory
					.createCharacterCombatRoundStatisticsCollectionType();
			for (CharacterCombatRoundStatistics aStatistics : aRound
					.getCharacterCombatRoundStatistics()) {
				CharacterCombatRoundStatisticsType aStatisticsType = anObjectFactory
						.createCharacterCombatRoundStatisticsType();
				aStatisticsType.setBleeding(aStatistics.getBleeding());
				aStatisticsType.setCharacterId(aStatistics.getCharacter()
						.getId());
				aStatisticsType.setHitsAtStartOfRound(aStatistics
						.getHitsAtStartOfRound());
				aStatisticsType.setHitsTakenDuringRound(aStatistics
						.getHitsTakenDuringRound());
				aStatisticsType.setInitiative(aStatistics.getInitiative());
				aStatisticsType.setAlertness(aStatistics.getAlertness());
				aStatisticsType.setObservation(aStatistics.getObservation());
				aStatisticsType.setNegativeModifier(aStatistics
						.getNegativeModifier());
				aStatisticsType.setRegeneration(aStatistics.getRegeneration());
				aStatisticsType.setRoundsStillStunned(aStatistics
						.getRoundsStillStunned());
				aStatisticsType.setTotalHits(aStatistics.getTotalHits());
				aStatisticsType
						.setCharacterTotalHitPointsAtStartOfRound(aStatistics
								.getCharacterTotalHitPointsAtStartOfRound());
				CriticalHitReferenceCollectionType aCriticalHitCollectionType = anObjectFactory
						.createCriticalHitReferenceCollectionType();
				aStatisticsType
						.setCriticalHitsSuffered(aCriticalHitCollectionType);

				if (aStatistics.getCriticalHitsSuffered() != null) {
					for (CriticalHit aCriticalHit : aStatistics
							.getCriticalHitsSuffered()) {
						CriticalHitReferenceType aCriticalHitReferenceType = anObjectFactory
								.createCriticalHitReferenceType();
						aCriticalHitReferenceType.setRangeMaximum(aCriticalHit
								.getRange().getMaximum());
						aCriticalHitReferenceType.setRangeMinimum(aCriticalHit
								.getRange().getMinimum());
						aCriticalHitReferenceType.setSeverity(aCriticalHit
								.getSeverity());
						aCriticalHitReferenceType.setType(aCriticalHit.getType());
						aCriticalHitCollectionType.getCriticalHitReference().add(
								aCriticalHitReferenceType);
					}					
				}

				aStatisticsCollectionType.getCharacterCombatRoundStatistic()
						.add(aStatisticsType);
			}
			aRoundType
					.setCharacterCombatRoundStatistics(aStatisticsCollectionType);

			aRoundCollectionType.getRound().add(aRoundType);
		}

		return aCombatEncounterType;
	}

}
