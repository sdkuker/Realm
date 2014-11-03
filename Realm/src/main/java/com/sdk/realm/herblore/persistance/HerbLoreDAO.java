package com.sdk.realm.herblore.persistance;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.sdk.realm.criticalhit.domain.CriticalHit;
import com.sdk.realm.criticalhit.persistance.CriticalHitType;
import com.sdk.realm.criticalhit.persistance.CriticalHitsDataFileFilter;
import com.sdk.realm.criticalhit.persistance.CriticalHitsLibraryType;
import com.sdk.realm.herblore.domain.Herb;

/*
 * I provide access to the herb lore data stored on files.
 */
public class HerbLoreDAO {

	private static final Logger _log = Logger.getLogger(HerbLoreDAO.class);
	private static final String FILE_LOCATION = "data";
	
	private List<Herb> _allHerbs = new ArrayList<Herb>();
	
	public HerbLoreDAO() {
	}

	/*
	 * read all the herbs from the data files, then return that list.
	 * the data files must be in the 'data' directory and must have 'herb lore' 
	 * in their file name.
	 */
	public List<Herb> getAllHerbs() {
		
		loadDataFromFiles();
		return _allHerbs;
	}
	
	private void loadDataFromFiles() {
		
		File directory = new File(FILE_LOCATION);
		File[] files = directory.listFiles(new HerbLoreDataFileFilter());
		_log.debug("Loading herb lore data from: " + files.length + " files.");
		for (int index = 0; index < files.length; index++) {
			loadFile(files[index]);
		}
		_log.debug("Total of: " + _allHerbs.size() + " herbs loaded.");
	}
	
	/*
	 * unmarshall the file, covert to domain objects and load into the internal collection
	 */
	private void loadFile(File aFile) {
		
		try {
			JAXBContext jc = JAXBContext.newInstance("com.sdk.realm.herblore.persistance");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			HerbLibraryType aLibraryType = (HerbLibraryType) unmarshaller.unmarshal(aFile);
			convertToDomainObjectsAndStore(aLibraryType);
		} catch (JAXBException e) {
			_log.error("unable to unmarshall file named: "  + aFile.getName(), e);
		}
	}
	
	private void convertToDomainObjectsAndStore(HerbLibraryType aLibraryType) {
		
		for (HerbType aHerbType: aLibraryType.getHerbCollection().getHerb()) {
			String formAndPreparation = aHerbType.getForm();
			if (aHerbType.getPreperation() != null) {
				formAndPreparation = formAndPreparation + "/" + aHerbType.getPreperation();
			}
			Herb aHerb = new Herb(aHerbType.getClazz(), aHerbType.getName(), aHerbType.getEffect(),
					aHerbType.getAttackLevel(), formAndPreparation ,aHerbType.getCostAndRarity());
			_allHerbs.add(aHerb);
		}
		
	}
}
