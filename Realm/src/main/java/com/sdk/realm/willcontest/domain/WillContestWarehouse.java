package com.sdk.realm.willcontest.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sdk.realm.item.domain.Item;
import com.sdk.realm.item.persistance.ItemDAO;
import com.sdk.realm.willcontest.persistance.WillContestDAO;

public class WillContestWarehouse {

	private static WillContestWarehouse CURRENT;
	
	private List<WillContest> contests = new ArrayList<WillContest>();
	
	public static WillContestWarehouse getCurrent() {
		
		if (CURRENT == null) {
			initializeCurrent();
		}
		return CURRENT;
	}
	
	private static synchronized void initializeCurrent() {
		
		if (CURRENT == null) {
			WillContestWarehouse temp = new WillContestWarehouse();
			temp.contests = (new WillContestDAO()).getAllContests();
			CURRENT = temp;
		}
	}
	
	public List<WillContest>  getAllContests() {
		
		return contests;
	}
	
	public WillContest getContest(int aContestId) {
		
		WillContest theReturn = null;
		Iterator<WillContest> anIterator = contests.listIterator();
		
		while (anIterator.hasNext() && theReturn == null) {
			WillContest aContest = anIterator.next();
			if (aContest.getId() == aContestId) {
				theReturn = aContest;
			}
		}
		return theReturn;
	}

	public WillContest createAndAddNewContest() {
		
		WillContest theReturn = new WillContest();
		theReturn.setId(getNextAvailableID());
		contests.add(theReturn);
		persistAll();
		
		return theReturn;
	}
	
	public boolean delete(WillContest aContest) {
		
		
		boolean theReturn = contests.remove(aContest);
		persistAll();
		return theReturn;
	}
	
	public void deleteAllContests() {
		
		contests = new ArrayList<WillContest>();
		persistAll();
	}
	
	/*
	 * Persist everything I currently have. Return true if everything worked ok
	 * and false if there was any problem at all.
	 */
	public boolean persistAll() {
		return (new WillContestDAO()).setAllContestsTo(contests);
	}

	public List<WillContest> getAllWillContests() {
		return contests;
	}
	
	public int getNextAvailableID() {
		
		int theReturn = 0;
			
		Iterator<WillContest> anIterator = contests.iterator();
		
		while (anIterator.hasNext()) {
			WillContest nextContest = anIterator.next();
			if (nextContest.getId() > theReturn ) {
				theReturn = nextContest.getId();
			}
		}
		
		theReturn++;
		return theReturn;
	}

}
