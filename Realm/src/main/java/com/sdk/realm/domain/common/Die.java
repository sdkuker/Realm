package com.sdk.realm.domain.common;

import java.util.Random;

/*
 * I am a die - a single instance of a dice.  
 */
public class Die {

	// note that this threshold really only applies to a 100 sided die
	private static final int OPEN_ENDED_ROLL_UPPER_THRESHOLD = 96;
	private static final int OPEN_ENDED_ROLL_LOWER_THRESHOLD = 4;
	private int _sided= 0;
	private Random _randomNumberGenerator = null;
	
	public Die(int sided) {
		_sided = sided;
		_randomNumberGenerator = new Random();
	}

	public int roll() {
		return generateRandomNumber();
	}
	
	public int rollOpenEnded() {
		int theReturn = 0;
		boolean finished = false;
		boolean lastRollWasOpenEndedDown = false;
		
		while (! finished) {
			int currentRoll = generateRandomNumber();
			if (lastRollWasOpenEndedDown) {
				theReturn = theReturn - currentRoll;
			} else {
				theReturn = theReturn + currentRoll;
			}
			if (currentRoll < OPEN_ENDED_ROLL_UPPER_THRESHOLD &&  currentRoll > OPEN_ENDED_ROLL_LOWER_THRESHOLD) {
				finished = true;
			}
			if (currentRoll > OPEN_ENDED_ROLL_LOWER_THRESHOLD ) {
				lastRollWasOpenEndedDown = false;
			} else {
				lastRollWasOpenEndedDown = true;
			}
		}
		return theReturn;
	}
	
	public int rollOpenEndedUp() {
		int theReturn = 0;
		boolean finished = false;
		
		while (! finished) {
			int currentRoll = generateRandomNumber();
			theReturn = theReturn + currentRoll;
			if (currentRoll < OPEN_ENDED_ROLL_UPPER_THRESHOLD) {
				finished = true;
			}
		}
		return theReturn;
	}

	public int rollOpenEndedDown() {
		int theReturn = 0;
		boolean finished = false;
		boolean lastRollWasOpenEndedDown = false;
		
		while (! finished) {
			int currentRoll = generateRandomNumber();
			if (lastRollWasOpenEndedDown) {
				theReturn = theReturn - currentRoll;
			} else {
				theReturn = theReturn + currentRoll;
			}
			if (currentRoll > OPEN_ENDED_ROLL_LOWER_THRESHOLD) {
				finished = true;
				lastRollWasOpenEndedDown = false;
			} else {
				lastRollWasOpenEndedDown= true;
			}
		}
		return theReturn;
	}

	
	/*
	 * generates a random number between 1 and (_sided)
	 */
	private int generateRandomNumber() {
		return  _randomNumberGenerator.nextInt(_sided) + 1;
	}
}