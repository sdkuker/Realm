package com.sdk.realm.herblore.persistance;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sdk.realm.herblore.persistance.HerbLoreDAO;

public class HerbLoreDAOTest {

	public HerbLoreDAOTest() {
		
	}
	
	@Test
	public void getAllHerbs() {
		
		HerbLoreDAO aDAO = new HerbLoreDAO();
		
		assertTrue(aDAO.getAllHerbs().size() > 0);
	}
}
