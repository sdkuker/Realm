package com.sdk.realm.herblore.ui;

import java.util.Comparator;

import com.sdk.realm.herblore.domain.Herb;

public class SearchResultsTableHerbComparator implements Comparator<Object> {

	public SearchResultsTableHerbComparator() {
	}

	// sort in order of classificcation and then name
	public int compare(Object o1, Object o2) {
		Herb herb1 = (Herb) o1;
		Herb herb2 = (Herb) o2;
		
		int theReturn = 0;
		
		if (herb1.getClassification().compareTo(herb2.getClassification())== 0) {
			theReturn = herb1.getName().compareTo(herb2.getName());
		} else {
			theReturn = herb1.getClassification().compareTo(herb2.getClassification());
		}
		
		return theReturn;
	}

}
