package com.sdk.realm.willcontest.domain;

import com.sdk.realm.domain.common.Range;

public class WillContestConsequence {

	private String description;
	private int permanentBonus;
	private int temporaryBonus;
	private int durationInRoundsOfTemporaryBonus;
	private Range range;
	
	
	public WillContestConsequence() {
		super();
	}
	
	public WillContestConsequence(String description, int permanentBonus,
			int temporaryBonus, int durationInRoundsOfTemporaryBonus, Range aRange) {
		super();
		this.description = description;
		this.permanentBonus = permanentBonus;
		this.temporaryBonus = temporaryBonus;
		this.durationInRoundsOfTemporaryBonus = durationInRoundsOfTemporaryBonus;
		this.range = aRange;
	}

	public String getDescription() {
		return description;
	}
	public int getPermanentBonus() {
		return permanentBonus;
	}
	public int getTemporaryBonus() {
		return temporaryBonus;
	}
	public int getDurationInRoundsOfTemporaryBonus() {
		return durationInRoundsOfTemporaryBonus;
	}
	public boolean isValidForValue(int aValue) {
		return range.isContainedInRange(aValue);
	}
}
