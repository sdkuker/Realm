package com.sdk.realm.criticalhit.persistance;

import java.io.File;
import java.io.FileFilter;

/*
 * filter all files in a directory - accept only those that have an 
 * xml extension and have 'criticalHit' in the file name.
 */
public class CriticalHitsDataFileFilter implements FileFilter {

	private static final String CRITICAL_HIT_REQUIRED_SUBSTRING = "Critical Hits";
	private static final String CRITICAL_HIT_REQUIRED_EXTENSION = "xml";
	
	public CriticalHitsDataFileFilter() {
	}

	public boolean accept(File pathname) {
		
		return pathname.getName().endsWith(CRITICAL_HIT_REQUIRED_EXTENSION) &&
			pathname.getName().indexOf(CRITICAL_HIT_REQUIRED_SUBSTRING) != -1;
	}

}
