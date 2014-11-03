package com.sdk.realm.item.domain;

import com.sdk.realm.persistance.domain.PersistantDomainObject;
import com.sdk.realm.willcontest.domain.WillContestant;

/*
 * I am an item that exists in a game.
 */
public class Item extends PersistantDomainObject implements WillContestant {

	private String name;
	private int will;
	private int willModifier;
	
	public String getWillContestantId() {
		return "Item-" + getId();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWill() {
		return will;
	}
	public void setWill(int will) {
		this.will = will;
	}
	public int getWillModifier() {
		return willModifier;
	}
	public void setWillModifier(int willModifier) {
		this.willModifier = willModifier;
	}
	public int getTotalWill() {
		return will + willModifier;
	}

}
