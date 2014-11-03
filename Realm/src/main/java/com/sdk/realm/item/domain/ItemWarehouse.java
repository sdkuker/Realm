package com.sdk.realm.item.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sdk.realm.item.persistance.ItemDAO;

public class ItemWarehouse {

	private static ItemWarehouse CURRENT;
	
	private List<Item> allItems = new ArrayList<Item>();
	
	public static ItemWarehouse getCurrent() {
		if (CURRENT == null) {
			initializeCurrent();
		}
		return CURRENT;
	}
	
	private static synchronized void initializeCurrent() {
		
		if (CURRENT == null) {
			ItemWarehouse temp = new ItemWarehouse();
			temp.allItems = (new ItemDAO()).getAllItems();
			CURRENT = temp;
		}
	}
	
	public List<Item> getAllItems() {
		return allItems;
	}
	
	public Item createAndAddNewItem() {
		Item anItem = new Item();
		anItem.setId(getNextAvailableID());
		allItems.add(anItem);
		return anItem;
	}
	
	public void deleteItem(Item anItem) {
		allItems.remove(anItem);
	}
	
	public void deleteAllItems() {
		allItems = new ArrayList<Item>();
	}
	
	/*
	 * Persist everything I currently have. Return true if everything worked ok
	 * and false if there was any problem at all.
	 */
	public boolean persistAll() {
		return (new ItemDAO()).setAllItemsTo(allItems);
	}

	public Item getItem(int anItemID){
		
		Item theItem = null;
		Iterator<Item> anIterator = allItems.iterator();
		
		while (anIterator.hasNext() && theItem == null) {
			Item nextItem = anIterator.next();
			if (nextItem.getId() == anItemID) {
				theItem = nextItem;
			}
		}
		
		return theItem;
	}
	
	public Item getItem(String anItemName){
		
		Item theItem = null;
		Iterator<Item> anIterator = allItems.iterator();
		
		while (anIterator.hasNext() && theItem == null) {
			Item nextItem = anIterator.next();
			if (nextItem.getName().equals(anItemName)) {
				theItem = nextItem;
			}
		}
		
		return theItem;
	}

	public int getNextAvailableID() {
		
		int theReturn = 0;
			
		Iterator<Item> anIterator = allItems.iterator();
		
		while (anIterator.hasNext()) {
			Item nextItem = anIterator.next();
			if (nextItem.getId() > theReturn ) {
				theReturn = nextItem.getId();
			}
		}
		
		theReturn++;
		return theReturn;
	}

}
