package com.sdk.realm.criticalhit.persistance;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.sdk.realm.criticalhit.domain.CriticalHit;

/*
 * I provide access to the critical hit data stored on files.
 */
public class CriticalHitDAO {

	private static final Logger _log = Logger.getLogger(CriticalHitDAO.class);
	private static final String FILE_LOCATION = "data";
	
	private List<CriticalHit> _allCriticalHits = new ArrayList<CriticalHit>();
	
	public CriticalHitDAO() {
	}

	/*
	 * read all the critical hits from the data files, then return that list.
	 * the data files must be in the 'data' directory and must have 'criticalHit' 
	 * in their file name.
	 */
	public List<CriticalHit> getAllCriticalHits() {
		
		loadDataFromFiles();
		return _allCriticalHits;
	}
	
	private void loadDataFromFiles() {
		
		File directory = new File(FILE_LOCATION);
		File[] files = directory.listFiles(new CriticalHitsDataFileFilter());
		_log.debug("Loading critical hit data from: " + files.length + " files.");
		for (int index = 0; index < files.length; index++) {
			loadFile(files[index]);
		}
		_log.debug("Total of: " + _allCriticalHits.size() + " critical hits loaded.");
	}
	
	/*
	 * unmarshall the file, covert to domain objects and load into the internal collection
	 */
	private void loadFile(File aFile) {
		
		try {
			JAXBContext jc = JAXBContext.newInstance("com.sdk.realm.criticalhit.persistance");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			CriticalHitsLibraryType aLibraryType = (CriticalHitsLibraryType) unmarshaller.unmarshal(aFile);
			convertToDomainObjectsAndStore(aLibraryType);
		} catch (JAXBException e) {
			_log.error("unable to unmarshall file named: "  + aFile.getName(), e);
		}
	}
	
	private void convertToDomainObjectsAndStore(CriticalHitsLibraryType aLibraryType) {
		
		for (CriticalHitType aCriticalHitType: aLibraryType.getCriticalHitCollection().getCriticalHit()) {
			CriticalHit aCriticalHit = new CriticalHit(aCriticalHitType.getType(), aCriticalHitType.getSeverity(), aCriticalHitType.getRollValues().getMinimum(),
										aCriticalHitType.getRollValues().getMaximum(), aCriticalHitType.getDescription());
			_allCriticalHits.add(aCriticalHit);
		}
		
	}
}
