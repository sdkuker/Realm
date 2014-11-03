package com.sdk.realm.combat.domain;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.sdk.realm.combat.persistance.CombatEncounterDAO;
import com.sdk.realm.combat.persistance.CombatEncounterPersistenceResult;

public class CombatEncounterWarehouse {

	private static CombatEncounterWarehouse CURRENT;
	
	private CombatEncounterDAO _myDAO;
	
	public static CombatEncounterWarehouse getCurrent() {
		
		if (CURRENT == null) {
			initializeCurrent();
		}
		return CURRENT;
	}

	/*
	 * This is exposed only for testing - it should not be called by any domain consumer
	 */
	public static void setCurrent(CombatEncounterWarehouse aWarehouse) {
		CURRENT = aWarehouse;
	}
	
	private static void initializeCurrent() {
		if (CURRENT == null) {
			CombatEncounterWarehouse temp = new CombatEncounterWarehouse();
			temp._myDAO = new CombatEncounterDAO();
			CURRENT = temp;
		}
	}
	
	public List<CombatEncounter> getAllCombatEncounters() {
		return _myDAO.getAllEncounters();
	}
	
	/* 
	 * Record the changes to the encounter.  This could be an
	 * add or just a change.  
	 */
	public CombatEncounterPersistenceResult updateCombatEncounter(CombatEncounter anEncounter) {

		 return _myDAO.persist(anEncounter);
	}
	
	
	public CombatEncounter createAndAddNewCombatEncounter() {
		
		CombatEncounter anEncounter = new CombatEncounter();
		_myDAO.persist(anEncounter);
		
		return anEncounter;
	}
	
	
	public void delete(CombatEncounter anEncounter) {
		_myDAO.delete(anEncounter);
	}
	
	public CombatEncounter getCombatEncounter(UUID anEncounterId){
		
		CombatEncounter theEncounter = null;
		Iterator<CombatEncounter> anIterator = getAllCombatEncounters().iterator();
		
		while (anIterator.hasNext() && theEncounter == null) {
			CombatEncounter nextEncounter = anIterator.next();
			if (nextEncounter.getId() == anEncounterId) {
				theEncounter = nextEncounter;
			}
		}
		
		return theEncounter;
	}
}
