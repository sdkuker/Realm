package com.sdk.realm.willcontest.persistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.sdk.realm.willcontest.domain.WillContest;
import com.sdk.realm.willcontest.domain.WillContestRound;
import com.sdk.realm.willcontest.domain.WillContestant;
import com.sdk.realm.willcontest.domain.WillContestantWarehouse;

public class WillContestDAO {

	private static final Logger log = Logger.getLogger(WillContestDAO.class);
	private String fileLocation = "data//WillContests.xml";
	
	private List<WillContest> allContests = new ArrayList<WillContest>();
	
	/*
	 * read all the contests from the data files, then return that list.
	 * the data file must be in the 'data' directory and must be named
	 * WillContests.xml
	 */
	public List<WillContest> getAllContests() {
		
		if (allContests.size() == 0) {
			loadDataFromFile();
		}
		return allContests;
	}
	private synchronized void loadDataFromFile() {
		
		File willContestFile = new File(fileLocation);
		log.debug("Loading will contest data from: " + willContestFile.getAbsolutePath());
		loadFile(willContestFile);
		log.debug("Total of: " + allContests.size() + " will contests loaded.");

	}
	
	/*
	 * unmarshall the file, covert to domain objects and load into the internal collection
	 */
	private void loadFile(File aFile) {
		
		try {
			JAXBContext jc = JAXBContext.newInstance("com.sdk.realm.willcontest.persistance");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			JAXBElement<WillContestLibraryType>  aJAXBElement = (JAXBElement <WillContestLibraryType>) unmarshaller.unmarshal(aFile);
			WillContestLibraryType aLibraryType = (WillContestLibraryType) aJAXBElement.getValue();
			convertToDomainObjectsAndStore(aLibraryType, aFile);
		} catch (Exception e) {
			log.error("unable to unmarshall file named: "  + aFile.getName(), e);
		}
	}

	private void convertToDomainObjectsAndStore(WillContestLibraryType aWillContestLibraryType, File aFile) {
		
		for (WillContestType aContestType: aWillContestLibraryType.getWillContestCollection().getWillContest()) {
			WillContest aContest = new WillContest();
			aContest.setContestantOne(findContestant(aContestType.getContestantOne()));
			aContest.setContestantTwo(findContestant(aContestType.getContestantTwo()));
			aContest.setId(aContestType.getId());
			for (WillContestRoundType aRoundType: aContestType.getRounds().getWillContestRound()) {
				WillContestRound aRound = new WillContestRound();
				aRound.setId(aRoundType.getId());
				aRound.setConcequenceValue(aRoundType.getConsequenceValue());
				aRound.setConsequenceDescription(aRoundType.getConsequenceDescription());
				aRound.setContestantOnePermanentModifier(aRoundType.getContestantOnePermanentModifier());
				aRound.setContestantOneTemporaryModifier(aRoundType.getContestantOneTemporarytModifier());
				aRound.setContestantOneTemporaryModifierExpirationRound(aRoundType.getContestantOneTemporaryModifierExpirationRound());
				aRound.setContestantOneTotalWill(aRoundType.getContestantOneTotalWill());
				aRound.setContestantTwoTotalWill(aRoundType.getContestantTwoTotalWill());
				aRound.setRoundNumber(aRoundType.getRoundNumber());
				
				aContest.addRound(aRound);
			}
			allContests.add(aContest);
		}
		
	}

	private WillContestant findContestant(WillContestantType aWillContestantType) {
		
		WillContestant theReturn = null;
		
		if (aWillContestantType != null && aWillContestantType.getId() != null) {
			String idStringValue = aWillContestantType.getId();
			Iterator<WillContestant> contestantIterator = WillContestantWarehouse.getCurrent().getAllContestants().iterator();
			while (contestantIterator.hasNext() && theReturn == null) {
				WillContestant aContestant = contestantIterator.next();
				if (aContestant.getWillContestantId().equals(idStringValue)) {
					theReturn = aContestant;
				}
			}

		}
		return theReturn;
	}
	
	/*
	 * replace all the contests I know about with the ones defined in listOfContests.  do this
	 * in my in-memory collection as well as on the file system.
	 */
	public boolean setAllContestsTo(List<WillContest> listOfContests) {
		
		ObjectFactory anObjectFactory = new ObjectFactory();
		WillContestLibraryType aWillContestLibraryType = convertToJAXBObjects(listOfContests, anObjectFactory);
		JAXBElement<WillContestLibraryType> jaxbElement = anObjectFactory.createWillContestLibrary(aWillContestLibraryType);
		boolean persistanceSucceeded = true;
		try {
			FileOutputStream anOutputStream = new FileOutputStream(fileLocation);
			log.debug("Saving will contests to file system: " + listOfContests.size() + " contests are being saved to file: " + fileLocation);
			JAXBContext jc = JAXBContext.newInstance("com.sdk.realm.willcontest.persistance");
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
			marshaller.marshal(jaxbElement, anOutputStream);
			log.debug("Saving will contests to the files system succeeded");
		} catch (JAXBException e) {
			log.error("Unable to save the will contest data - JAXB Exception: ", e);
			persistanceSucceeded = false;
		} catch (FileNotFoundException e1) {
			log.error("Unable to save the will contest data - File Not Found Exception: ", e1);
			persistanceSucceeded = false;
		}
		allContests = listOfContests;
		
		return persistanceSucceeded;
	}

	private WillContestLibraryType convertToJAXBObjects(List<WillContest> listOfContests, ObjectFactory anObjectFactory)  {
		
		WillContestLibraryType aLibraryType = anObjectFactory.createWillContestLibraryType();
		WillContestCollectionType aContestCollectionType = anObjectFactory.createWillContestCollectionType();
		aLibraryType.setWillContestCollection(aContestCollectionType);
		
		for (WillContest aWillContest: listOfContests) {
			WillContestType aContestType = anObjectFactory.createWillContestType();
			aContestCollectionType.getWillContest().add(aContestType);
			aContestType.setId(aWillContest.getId());
			if (aWillContest.getContestantOne() != null) {
				WillContestantType contestantTypeOne = anObjectFactory.createWillContestantType();
				contestantTypeOne.setId(aWillContest.getContestantOne().getWillContestantId());
				aContestType.setContestantOne(contestantTypeOne);
			}
			if (aWillContest.getContestantTwo() != null) {
				WillContestantType contestantTypeTwo = anObjectFactory.createWillContestantType();
				contestantTypeTwo.setId(aWillContest.getContestantTwo().getWillContestantId());
				aContestType.setContestantTwo(contestantTypeTwo);
			}
			WillContestRoundCollectionType aRoundCollectionType = anObjectFactory.createWillContestRoundCollectionType();
			aContestType.setRounds(aRoundCollectionType);
			for (WillContestRound aRound: aWillContest.getRounds()) {
				WillContestRoundType aRoundType = anObjectFactory.createWillContestRoundType();
				aRoundCollectionType.getWillContestRound().add(aRoundType);
				aRoundType.setId(aRound.getId());
				aRoundType.setConsequenceDescription(aRound.getConsequenceDescription());
				aRoundType.setConsequenceValue(aRound.getConcequenceValue());
				aRoundType.setContestantOnePermanentModifier(aRound.getContestantOnePermanentModifier());
				aRoundType.setContestantOneTemporarytModifier(aRound.getContestantOneTemporaryModifier());
				aRoundType.setContestantOneTemporaryModifierExpirationRound(aRound.getContestantOneTemporaryModifierExpirationRound());
				aRoundType.setContestantOneTotalWill(aRound.getContestantOneTotalWill());
				aRoundType.setContestantTwoTotalWill(aRound.getContestantTwoTotalWill());
				aRoundType.setRoundNumber(aRound.getRoundNumber());
			}	
		}
		return aLibraryType;
	}
}
