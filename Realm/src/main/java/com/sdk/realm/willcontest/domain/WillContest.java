package com.sdk.realm.willcontest.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

import com.sdk.realm.domain.common.Die;
import com.sdk.realm.persistance.domain.PersistantDomainObject;

/*
 * I am a contest of wills between two contestants. I contain all
 * data about the contest.
 */
public class WillContest extends PersistantDomainObject {
	
	private static final Logger LOG = Logger.getLogger(WillContest.class);

	/*
	 * if the contest is between an item and a character,
	 * the item should be first.  All modifiers are applied
	 * to contestantOne.  These can be negative if 
	 * contestantTwo won.
	 */ 
	private WillContestant contestantOne;	
	private WillContestant contestantTwo;
	private Die myDie = new Die(100);
	
	private List<WillContestRound> rounds = new ArrayList<WillContestRound>();
	
	public WillContest() {
		super();
	}
	
	/*
	 * If the contest is between an item and a character, the firstContestant 
	 * should be the item.
	 */
	public WillContest(WillContestant firstContestant, WillContestant secondContestant) {
		super();
		contestantOne = firstContestant;
		contestantTwo = secondContestant;
	}
		
	public WillContestant getContestantOne() {
		return contestantOne;
	}
	
	public WillContestant getContestantTwo() {
		return contestantTwo;
	}

	public List<WillContestRound> getRounds() {
		return rounds;
	}
	
	public int getNumberOfRounds() {
		return rounds.size();
	}
	
	/*
	 * Generate the next round and return it.
	 */
	public WillContestRound generateNextRound() {

		WillContestRound currentRound = getCurrentRound();
		WillContestRound nextRound = new WillContestRound();
		nextRound.setRoundNumber(currentRound.getRoundNumber() + 1);

		int contestantOneOpenEndedRoll = myDie.rollOpenEnded();
		int temporaryModifier = 0;
		int contestantOneWill = getContestantOne().getTotalWill()
				+ contestantOneOpenEndedRoll
				+ currentRound.getContestantOnePermanentModifier();
		if (nextRound.getRoundNumber() < currentRound.getContestantOneTemporaryModifierExpirationRound()) {
			contestantOneWill = contestantOneWill
					+ currentRound.getContestantOneTemporaryModifier();
			temporaryModifier = currentRound.getContestantOneTemporaryModifier();
		}
		LOG.debug("Will Contest Round Generation - Round Number: " + nextRound.getRoundNumber());
		LOG.debug("Contestant One roll:" + contestantOneOpenEndedRoll + " " +
					" + temp modifier: " + temporaryModifier + 
					" + permanent modifier: " + currentRound.getContestantOnePermanentModifier() + 
					" + will plus modifier: " + getContestantOne().getTotalWill() + 
					" = " + contestantOneWill);

		int contestantTwoOpenEndedRoll = myDie.rollOpenEnded();
		int contestantTwoWill = getContestantTwo().getTotalWill()
				+ contestantTwoOpenEndedRoll;
		
		LOG.debug("Contestant Two roll:" + contestantTwoOpenEndedRoll + " " +
				" + will plus modifier: " + getContestantTwo().getTotalWill() + 
				" = " + contestantTwoWill);

		
		int result = contestantOneWill - contestantTwoWill;
		
		nextRound.setConcequenceValue(result);
		nextRound.setContestantOneTotalWill(contestantOneWill);
		nextRound.setContestantTwoTotalWill(contestantTwoWill);
		
		WillContestConsequence myConsequence = WillContestConsequencesWarehouse.getCurrent().getConsequence(result);
		nextRound.setContestantOnePermanentModifier(myConsequence.getPermanentBonus());
		nextRound.setContestantOneTemporaryModifier(myConsequence.getTemporaryBonus());
		nextRound.setContestantOneTemporaryModifierExpirationRound(nextRound.getRoundNumber() + myConsequence.getDurationInRoundsOfTemporaryBonus());
		nextRound.setConsequenceDescription(myConsequence.getDescription());
		
		addRound(nextRound);
		
		return nextRound;
	}
	
	public void addRound(WillContestRound aRound ) {
		rounds.add(aRound);
	}
	
	private WillContestRound getCurrentRound() {
		WillContestRound theReturn = new WillContestRound();
		// it's the one with the highest round number
		for (WillContestRound aRound: rounds) {
			if (aRound.getRoundNumber() > theReturn.getRoundNumber()) {
				theReturn = aRound;
			}
		}
		
		return theReturn;
	}

	public WillContestRound getRound(int roundNumber) {
		
		WillContestRound theReturn = null;
		Iterator<WillContestRound> anIterator = rounds.iterator();
		
		while (anIterator.hasNext() && theReturn == null) {
			WillContestRound aRound = anIterator.next();
			if (theReturn == null && aRound.getRoundNumber() == roundNumber) {
				theReturn = aRound;
			}
		}
		return theReturn;
	}

	public String getCurrentStatus() {

		StringBuilder aBuilder = new StringBuilder();
		aBuilder.append("Round Number: ");
		aBuilder.append(getRounds().size());
		
		return aBuilder.toString();
	}

	public void setContestantOne(WillContestant contestantOne) {
		this.contestantOne = contestantOne;
	}

	public void setContestantTwo(WillContestant contestantTwo) {
		this.contestantTwo = contestantTwo;
	}

}
