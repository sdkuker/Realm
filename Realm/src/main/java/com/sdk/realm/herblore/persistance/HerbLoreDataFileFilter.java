package com.sdk.realm.herblore.persistance;

import java.io.File;
import java.io.FileFilter;

/*
 * filter all files in a directory - accept only those that have an 
 * xml extension and have 'criticalHit' in the file name.
 */
public class HerbLoreDataFileFilter implements FileFilter {

	private static final String HERB_LORE_REQUIRED_SUBSTRING = "Herb Lore";
	private static final String HERB_LORE_REQUIRED_EXTENSION = "xml";
	
	public HerbLoreDataFileFilter() {
	}

	public boolean accept(File pathname) {
		
		return pathname.getName().endsWith(HERB_LORE_REQUIRED_EXTENSION) &&
			pathname.getName().indexOf(HERB_LORE_REQUIRED_SUBSTRING) != -1;
	}

}
