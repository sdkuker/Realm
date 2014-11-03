package com.sdk.realm.combat.persistance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.sdk.realm.combat.domain.CombatEncounter;

public class CombatEncounterDAOTest {

	private static String TEST_ENCOUNTER_DESCRIPTION = "Test Encounter";
	private CombatEncounterDAO combatEncounterDAO;
	
	@Before
	public  void setUp() {
		combatEncounterDAO = new CombatEncounterDAO();	
	}
	
	@Test
	public void testSimpleEncounterPersistenceAndDeletion() {
		
		CombatEncounter aCombatEncounter = new CombatEncounter();
		aCombatEncounter.setDescription(TEST_ENCOUNTER_DESCRIPTION);
		UUID ecounterID = aCombatEncounter.getId();
		
		CombatEncounterPersistenceResult persistenceResult = combatEncounterDAO.persist(aCombatEncounter);
		
		assertTrue("successfull", persistenceResult.wasSuccessfull());
		assertFalse("has errors", persistenceResult.hasValidationErrors());
		
		// create a new dao and have it read the encounter file you just saved.
		CombatEncounterDAO secondDAO = new CombatEncounterDAO();
		List<CombatEncounter> persistedCombatEncounters = secondDAO.getAllEncounters();
		assertNotNull("persisted encounters list not null", persistedCombatEncounters);
		
		// make sure the one you created is in the list
		CombatEncounter retrievedEncounter = null;
		for (CombatEncounter anEncounter: persistedCombatEncounters) {
			if (anEncounter.getId().equals(ecounterID)) {
				retrievedEncounter = anEncounter;
			}
		}
		assertNotNull("correct encounter found", retrievedEncounter);
		
		// lastly, remove the encounter - deleting the persisted file
		secondDAO.delete(retrievedEncounter);
		CombatEncounterDAO thirdDAO = new CombatEncounterDAO();
		List<CombatEncounter> remainingPersistedCombatEncounters = thirdDAO.getAllEncounters();
		assertNotNull("persisted encounters list not null", remainingPersistedCombatEncounters);
		
		// make sure the one you created is in the list
		CombatEncounter deletedEncounter = null;
		for (CombatEncounter anEncounter: remainingPersistedCombatEncounters) {
			if (anEncounter.getId().equals(ecounterID)) {
				deletedEncounter = anEncounter;
			}
		}
		assertNull("correct encounter not deleted", deletedEncounter);
		
	}
}
