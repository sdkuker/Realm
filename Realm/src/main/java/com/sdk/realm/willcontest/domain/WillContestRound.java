package com.sdk.realm.willcontest.domain;

import com.sdk.realm.persistance.domain.PersistantDomainObject;

/*
 * I represent the results of an individual will contest combat or
 * encounter.  There will typically be several rounds in a will contest.s
 */
public class WillContestRound extends PersistantDomainObject {
	
	private int roundNumber;
	private int contestantOneTotalWill;
	private int contestantTwoTotalWill;
	// this is the key to the lookup of the consequence in the WillContestConcequencesWarehous
	private int concequenceValue;	
	private String consequenceDescription;
	private int contestantOnePermanentModifier;
	private int contestantOneTemporaryModifier;
	private int contestantOneTemporaryModifierExpirationRound;

	public int getRoundNumber() {
		return roundNumber;
	}
	
	public void setRoundNumber(int aNumber) {
		roundNumber = aNumber;
	}

	public int getContestantOneTotalWill() {
		return contestantOneTotalWill;
	}

	public void setContestantOneTotalWill(int contestantOneRoll) {
		this.contestantOneTotalWill = contestantOneRoll;
	}

	public int getContestantTwoTotalWill() {
		return contestantTwoTotalWill;
	}

	public void setContestantTwoTotalWill(int contestantTwoRoll) {
		this.contestantTwoTotalWill = contestantTwoRoll;
	}

	public int getConcequenceValue() {
		return concequenceValue;
	}

	public void setConcequenceValue(int concequenceValue) {
		this.concequenceValue = concequenceValue;
	}

	public int getContestantOnePermanentModifier() {
		return contestantOnePermanentModifier;
	}

	public void setContestantOnePermanentModifier(int contestantOnePermanentModifier) {
		this.contestantOnePermanentModifier = contestantOnePermanentModifier;
	}

	public int getContestantOneTemporaryModifier() {
		return contestantOneTemporaryModifier;
	}

	public void setContestantOneTemporaryModifier(int contestantOneTemporaryModifier) {
		this.contestantOneTemporaryModifier = contestantOneTemporaryModifier;
	}

	public int getContestantOneTemporaryModifierExpirationRound() {
		return contestantOneTemporaryModifierExpirationRound;
	}

	public void setContestantOneTemporaryModifierExpirationRound(
			int contestantOneTemporaryModifierExpirationRound) {
		this.contestantOneTemporaryModifierExpirationRound = contestantOneTemporaryModifierExpirationRound;
	}

	public String getConsequenceDescription() {
		return consequenceDescription;
	}

	public void setConsequenceDescription(String consequenceDescription) {
		this.consequenceDescription = consequenceDescription;
	}

}
