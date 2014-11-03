package com.sdk.realm.movement.maneuver.persistance;

import java.io.File;
import java.io.FileFilter;

/*
 * filter all files in a directory - accept only those that have an 
 * xml extension and have 'criticalHit' in the file name.
 */
public class MovementManeuverDataFileFilter implements FileFilter {

	private static final String MOVEMENT_MANEUVER_REQUIRED_SUBSTRING = "Movement Maneuver";
	private static final String MOVEMENT_MANEUVER_REQUIRED_EXTENSION = "xml";
	
	public MovementManeuverDataFileFilter() {
	}

	public boolean accept(File pathname) {
		
		return pathname.getName().endsWith(MOVEMENT_MANEUVER_REQUIRED_EXTENSION) &&
			pathname.getName().indexOf(MOVEMENT_MANEUVER_REQUIRED_SUBSTRING) != -1;
	}

}
