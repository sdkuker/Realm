package com.sdk.realm.willcontest.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sdk.realm.willcontest.consequence.persistance.WillContestConsequencesDAO;

public class WillContestConsequencesWarehouse {

	private static WillContestConsequencesWarehouse CURRENT;
	
	private List<WillContestConsequence> consequences = new ArrayList<WillContestConsequence>();
	
	public static WillContestConsequencesWarehouse getCurrent() {
		
		if (CURRENT == null) {
			initializeCurrent();
		}
		return CURRENT;
	}
	
	private static synchronized void initializeCurrent() {
		
		if (CURRENT == null) {
			WillContestConsequencesWarehouse temp = new WillContestConsequencesWarehouse();
			temp.consequences = (new WillContestConsequencesDAO()).getAllConsequences();
			CURRENT = temp;
		}
	}
	
	public WillContestConsequence getConsequence(int aConsequenceValue) {
		
		WillContestConsequence theReturn = null;
		Iterator<WillContestConsequence> anIterator = consequences.listIterator();
		
		while (anIterator.hasNext() && theReturn == null) {
			WillContestConsequence aConsequence = anIterator.next();
			if (aConsequence.isValidForValue(aConsequenceValue)) {
				theReturn = aConsequence;
			}
		}
		
		return theReturn;
	}
}
