package com.sdk.realm.movement.maneuver.persistance;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MovementManeuverDAOTest {

	public MovementManeuverDAOTest() {
		
	}
	
	@Test
	public void getAllMovementManeuvers() {
		
		MovementManeuverDAO aDAO = new MovementManeuverDAO();
		
		assertTrue(aDAO.getAllMovementManeuvers().size() > 1);
	}
}
