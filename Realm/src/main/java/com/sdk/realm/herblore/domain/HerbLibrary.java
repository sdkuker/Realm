package com.sdk.realm.herblore.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import com.sdk.realm.herblore.persistance.HerbLoreDAO;

/*
 * Contains all the herb known as well as methods for finding
 * them. This is a singleton class as herb are loaded from data
 * file and never change.
 */
public class HerbLibrary {

	private static HerbLibrary CURRENT = null;
	
	private List<Herb> _allHerbs = null;
	private Random _randomNumberGenerator = null;
	
	public static HerbLibrary getCurrent() {
		
		if (CURRENT == null) {
			initializeCurrent();
		}
		return CURRENT;
	}
	
	/*
	 * This is exposed only for testing - it should not be called by any domain consumer
	 */
	static void setCurrent(HerbLibrary aLibrary) {
		CURRENT = aLibrary;
	}
	
	private static void initializeCurrent() {
		if (CURRENT == null) {
			HerbLibrary temp = new HerbLibrary();
			temp._allHerbs = (new HerbLoreDAO()).getAllHerbs();
			temp._randomNumberGenerator = new Random();
			CURRENT = temp;
		}
	}
	

	public Herb getRandomHerb() {
		int herbPosition = _randomNumberGenerator.nextInt(_allHerbs.size());
		return _allHerbs.get(herbPosition);
	}
	
	/*
	 * return a list of all the herbs that have the input argument in the herbs
	 * name.
	 */
	public List<Herb> getHerbsContainingName(String aNameFragment) {
		
		List<Herb> theReturn = new ArrayList<Herb>();
		ListIterator<Herb> anIterator = _allHerbs.listIterator();
		while (anIterator.hasNext()) {
			Herb anHerb = anIterator.next();
			if (anHerb.getName().toLowerCase().contains(aNameFragment.toLowerCase())) {
				theReturn.add(anHerb);
			}
		}
		
		return theReturn;
	}
	
	/*
	 * return a list of all the herbs that have the input argument in the herbs
	 * classification.
	 */
	public List<Herb> getHerbsContainingClassification(String aNameFragment) {
		
		List<Herb> theReturn = new ArrayList<Herb>();
		ListIterator<Herb> anIterator = _allHerbs.listIterator();
		while (anIterator.hasNext()) {
			Herb anHerb = anIterator.next();
			if (anHerb.getClassification().toLowerCase().contains(aNameFragment.toLowerCase())) {
				theReturn.add(anHerb);
			}
		}
		
		return theReturn;
	}
}
