package com.sdk.realm.movement.maneuver.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sdk.realm.movement.maneuver.domain.MovementManeuver.MovementManeuverDifficulty;
import com.sdk.realm.movement.maneuver.persistance.MovementManeuverDAO;

/*
 * Contains all the movement manuevers known as well as methods for finding
 * them. This is a singleton class as critical hits are loaded from data
 * file and never change.
 */
public class MovementManeuverLibrary {

	private static MovementManeuverLibrary CURRENT = null;

	private List<MovementManeuver> allMovements = null;

	public static MovementManeuverLibrary getCurrent() {

		if (CURRENT == null) {
			initializeCurrent();
		}
		return CURRENT;
	}

	/*
	 * This is exposed only for testing - it should not be called by any domain
	 * consumer
	 */
	static void setCurrent(MovementManeuverLibrary aLibrary) {
		CURRENT = aLibrary;
	}

	private static void initializeCurrent() {
		if (CURRENT == null) {
			MovementManeuverLibrary temp = new MovementManeuverLibrary();
			temp.allMovements = (new MovementManeuverDAO())
					.getAllMovementManeuvers();
			CURRENT = temp;
		}
	}

	public List<MovementManeuver> getAllMovementManeuvers() {
		return allMovements;
	}

	/*
	 * This is exposed only for testing - it should not be called by any domain
	 * consumer
	 */
	void setMovementManeuvers(List<MovementManeuver> listOfMovementManeuvers) {
		allMovements = listOfMovementManeuvers;
	}

	/*
	 * return a set containing the names of each type of movement
	 */
	public Set<String> getAllMovementManeuverTypes() {
		MovementManeuverDifficulty[] values = MovementManeuverDifficulty
				.values();
		Set<String> theReturn = new HashSet<String>();
		for (MovementManeuverDifficulty aDifficulty : values) {
			theReturn.add(aDifficulty.name());
		}
		return theReturn;
	}

	public MovementManeuver getMovementManeuver(int rollValue) {
		MovementManeuver theReturn = null;
		MovementManeuver movementWithHighestRange = null;
		Iterator<MovementManeuver> movementIterator = allMovements.iterator();
		while (theReturn == null && movementIterator.hasNext()) {
			MovementManeuver aMovement = movementIterator.next();
			if (aMovement.getRange().isContainedInRange(rollValue)) {
				theReturn = aMovement;
			} else {
				if (movementWithHighestRange == null
						|| aMovement.getRange().getMaximum() > movementWithHighestRange
								.getRange().getMaximum()) {
					movementWithHighestRange = aMovement;
				}
			}
		}

		// if rollValue is higher than the value for any hit, take the one with
		// the highest max value
		if (theReturn == null && movementWithHighestRange != null) {
			if (rollValue > movementWithHighestRange.getRange().getMaximum()) {
				theReturn = movementWithHighestRange;
			}
		}

		return theReturn;
	}
}
