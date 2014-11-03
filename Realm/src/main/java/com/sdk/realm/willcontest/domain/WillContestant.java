package com.sdk.realm.willcontest.domain;

/*
 * I am someone or something that can take part in a Will contest.
 */
public interface WillContestant {
	
	/*
	 * Return the will contestant persistence id.  This is different than 
	 * the contestant's item id or character id.
	 */
	String getWillContestantId();
	
	/*
	 * Return the native will of the contestant.
	 */
	int getWill();
	void setWill(int aWillValue);
	
	/*
	 * Return the modifier for the Will - assigned my
	 * the GM I do believe
	 */
	int getWillModifier();
	void setWillModifier(int aWillModifierValue);
	
	/*
	 * Return the total of the will and will modifier
	 */
	int getTotalWill();
	
	/*
	 * Return the name of the contestant
	 */
	String getName();
}
