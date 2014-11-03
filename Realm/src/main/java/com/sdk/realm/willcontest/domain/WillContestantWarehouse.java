package com.sdk.realm.willcontest.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.sdk.realm.character.domain.CharacterWarehouse;
import com.sdk.realm.item.domain.ItemWarehouse;


public class WillContestantWarehouse {
	
	private static WillContestantWarehouse CURRENT;

	public static WillContestantWarehouse getCurrent() {
		
		if (CURRENT == null) {
			initializeCurrent();
		}
		return CURRENT;
	}
	
	private static synchronized void initializeCurrent() {
		
		if (CURRENT == null) {
			WillContestantWarehouse temp = new WillContestantWarehouse();
			CURRENT = temp;
		}
	}
	
	public List<WillContestant> getAllContestants() {
		
		List<WillContestant> theReturn = new ArrayList<WillContestant>();
		
		theReturn.addAll(CharacterWarehouse.getCurrent().getAllCharacters());
		theReturn.addAll(ItemWarehouse.getCurrent().getAllItems());
	
		return theReturn;
	}

	public WillContestant getContestantNamed(String aContestantName) {
		
		WillContestant theReturn = null;
		ListIterator<WillContestant> anIterator = getAllContestants().listIterator();
		
		while(theReturn == null && anIterator.hasNext()) {
			WillContestant aContestant = anIterator.next();
			if (aContestant.getName().equals(aContestantName)) {
				theReturn = aContestant;
			}
		}
		return theReturn;
	}
}
