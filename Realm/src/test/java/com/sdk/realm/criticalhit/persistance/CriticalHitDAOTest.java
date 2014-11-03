package com.sdk.realm.criticalhit.persistance;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sdk.realm.criticalhit.persistance.CriticalHitDAO;

public class CriticalHitDAOTest {

	public CriticalHitDAOTest() {
		
	}
	
	@Test
	public void getAllCriticalHits() {
		
		CriticalHitDAO aDAO = new CriticalHitDAO();
		
		assertTrue(aDAO.getAllCriticalHits().size() > 0);
	}
}
