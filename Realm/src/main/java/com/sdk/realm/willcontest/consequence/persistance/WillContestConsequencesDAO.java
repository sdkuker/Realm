package com.sdk.realm.willcontest.consequence.persistance;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.sdk.realm.domain.common.Range;
import com.sdk.realm.player.domain.Player;
import com.sdk.realm.player.domain.PlayerWarehouse;
import com.sdk.realm.player.persistance.PlayerType;
import com.sdk.realm.player.persistance.PlayerWarehouseType;
import com.sdk.realm.willcontest.domain.WillContestConsequence;

public class WillContestConsequencesDAO {

	private static final Logger log = Logger.getLogger(WillContestConsequencesDAO.class);
	private String fileLocation = "data//WillContestConsequences.xml";
	
	private List<WillContestConsequence> allConsequences = new ArrayList<WillContestConsequence>();
	
	/*
	 * read all the consequences from the data files, then return that list.
	 * the data file must be in the 'data' directory and must be named
	 * WillConsequences.xml
	 */
	public List<WillContestConsequence> getAllConsequences() {
		
		if (allConsequences.size() == 0) {
			loadDataFromFile();
		}
		return allConsequences;
	}
	private synchronized void loadDataFromFile() {
		
		File willContestConsequencesFile = new File(fileLocation);
		log.debug("Loading will contest consequences data from: " + willContestConsequencesFile.getAbsolutePath());
		loadFile(willContestConsequencesFile);
		log.debug("Total of: " + allConsequences.size() + " will contest consequences loaded.");
	}
	
	/*
	 * unmarshall the file, covert to domain objects and load into the internal collection
	 */
	private void loadFile(File aFile) {
		
		try {
			JAXBContext jc = JAXBContext.newInstance("com.sdk.realm.willcontest.consequence.persistance");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			JAXBElement<WillContestConsequenceLibraryType>  aJAXBElement = (JAXBElement <WillContestConsequenceLibraryType>) unmarshaller.unmarshal(aFile);
			WillContestConsequenceLibraryType aLibraryType = (WillContestConsequenceLibraryType) aJAXBElement.getValue();
			convertToDomainObjectsAndStore(aLibraryType, aFile);
		} catch (Exception e) {
			log.error("unable to unmarshall file named: "  + aFile.getName(), e);
		}
	}

	private void convertToDomainObjectsAndStore(WillContestConsequenceLibraryType aWillContestConsequenceLibraryType, File aFile) {
		
		for (WillContestConsequenceType aConsequenceType: aWillContestConsequenceLibraryType.getWillContestConsequenceCollection().getWillContestConsequence()) {
			String description = aConsequenceType.getDescription();
			int permanentBonus = aConsequenceType.getPermanentBonus();
			int temporaryBonus = aConsequenceType.getTemporaryBonus();
			int durationInRoundsOfTemporaryBonus = aConsequenceType.getDurationInRoundsOfTemporaryBounus();
			DiceRollRangeType aRangeType = aConsequenceType.getRollValues();
			Range aRange = new Range(aRangeType.getMinimum(), aRangeType.getMaximum());
			
			WillContestConsequence aConsequence = new WillContestConsequence(description, permanentBonus, temporaryBonus, durationInRoundsOfTemporaryBonus, aRange);
			allConsequences.add(aConsequence);
		}
		
	}

}
