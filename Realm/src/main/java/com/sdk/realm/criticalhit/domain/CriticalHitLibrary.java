package com.sdk.realm.criticalhit.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sdk.realm.criticalhit.persistance.CriticalHitDAO;

/*
 * Contains all the critical hits known as well as methods for finding
 * them. This is a singleton class as critical hits are loaded from data
 * file and never change.
 */
public class CriticalHitLibrary {

	private static CriticalHitLibrary CURRENT = null;
	
	private List<CriticalHit> _allCriticalHits = null;
	
	public static CriticalHitLibrary getCurrent() {
		
		if (CURRENT == null) {
			initializeCurrent();
		}
		return CURRENT;
	}

	/*
	 * This is exposed only for testing - it should not be called by any domain consumer
	 */
	static void setCurrent(CriticalHitLibrary aLibrary) {
		CURRENT = aLibrary;
	}
	
	private static void initializeCurrent() {
		if (CURRENT == null) {
			CriticalHitLibrary temp = new CriticalHitLibrary();
			temp._allCriticalHits = (new CriticalHitDAO()).getAllCriticalHits();
			CURRENT = temp;
		}
	}
	
	public List<CriticalHit> getAllCriticalHits() {
		return _allCriticalHits;
	}
	
	/*
	 * This is exposed only for testing - it should not be called by any domain consumer
	 */
	void setCriticalHits(List<CriticalHit> listOfCriticalHits) {
		_allCriticalHits = listOfCriticalHits;
	}
	
	/*
	 * return a set containing one instance of all the type in the library
	 */
	public Set<String> getAllCriticalHitTypes() {
		Set<String> theReturn = new HashSet<String>();
		for (CriticalHit aCriticalHit: _allCriticalHits) {
			theReturn.add(aCriticalHit.getType());
		}
		return theReturn;
	}
	
	public Set<String> getAllCriticalHitSeverities() {
		
		Set<String> theReturn = new HashSet<String>();
		for (CriticalHit aCriticalHit: _allCriticalHits) {
			if (aCriticalHit.getSeverity() != null && aCriticalHit.getSeverity().length() > 0) {
				theReturn.add(aCriticalHit.getSeverity());
			}
		}
		return theReturn;
	}
	
	/*
	 * return null if one is not found that fits the input parms unless one is found that 
	 * matches type and severity, but it's roll value is too low - then take the one with the
	 * highest roll value.
	 */
	public CriticalHit getCriticalHit(String type, String severity, int rollValue) {
		
		CriticalHit theReturn = null;
		CriticalHit hitWithHighestRange = null;
		Iterator<CriticalHit> hitsIterator = _allCriticalHits.iterator();
		while (theReturn == null && hitsIterator.hasNext()) {
			CriticalHit aHit = hitsIterator.next();
			if (aHit.getType().equals(type) && aHit.getSeverity().equals(severity)) {
				if(aHit.getRange().isContainedInRange(rollValue)) {
					theReturn = aHit;
				} else {
					if (hitWithHighestRange == null || aHit.getRange().getMaximum() > hitWithHighestRange.getRange().getMaximum()) {
						hitWithHighestRange = aHit;
					}
				}
			}
		}
		
		// if rollValue is higher than the value for any hit, take the one with the highest max value
		if (theReturn == null && hitWithHighestRange != null) {
			if (rollValue > hitWithHighestRange.getRange().getMaximum()) {
				theReturn = hitWithHighestRange;
			}
		}
		
		return theReturn;
	}
	
	/*
	 * return null if one is not found that fits the input parms
	 */
	public CriticalHit getCriticalHit(String type, String severity, int minimumRange, int maximumRange) {
		
		CriticalHit theReturn = null;
		Iterator<CriticalHit> hitsIterator = _allCriticalHits.iterator();
		
		while (theReturn == null && hitsIterator.hasNext()) {
			CriticalHit aHit = hitsIterator.next();
			if (aHit.getType().equals(type) && aHit.getSeverity().equals(severity)) {
				if(aHit.getRange().getMinimum() == minimumRange && aHit.getRange().getMaximum() == maximumRange) {
					theReturn = aHit;
				} 
			}
		}
		
		return theReturn;
	}
	/*
	 * return a collection of criticals that meet the input parameters. the collection will be empty
	 * if there are no criticals that match the conditions.
	 */
	public List<CriticalHit> getCriticalHits(String type, String severity ) {
		
		List<CriticalHit> theReturn = new ArrayList<CriticalHit> ();
		
		Iterator<CriticalHit> hitsIterator = _allCriticalHits.iterator();
		while (hitsIterator.hasNext()) {
			CriticalHit aHit = hitsIterator.next();
			if (aHit.getType().equals(type) && aHit.getSeverity().equals(severity)) {
				theReturn.add(aHit);
			}
		}

		return theReturn;
	}
	
	/*
	 * return a collection of criticals for the input type. the collection will be empty
	 * if there are no criticals that match the conditions.
	 */
	public Set<String> getCriticalHitSeveritiesForType(String type) {
		
		Set<String> theReturn = new HashSet<String> ();
		
		Iterator<CriticalHit> hitsIterator = _allCriticalHits.iterator();
		while (hitsIterator.hasNext()) {
			CriticalHit aHit = hitsIterator.next();
			if (aHit.getType().equals(type)) {
				theReturn.add(aHit.getSeverity());
			}
		}

		return theReturn;
	}
}
