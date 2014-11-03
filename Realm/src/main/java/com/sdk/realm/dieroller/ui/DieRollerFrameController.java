package com.sdk.realm.dieroller.ui;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import com.sdk.realm.domain.common.Die;
import com.sdk.realm.ui.Controller;

public class DieRollerFrameController extends Controller {

	private static final int NUMBER_OF_RECENT_ROLLS_TO_DISPLAY = 10;
	private static final int LENGTH_OF_RECENT_ROLLS_STRING = 5;
	private DieRollerJFrame _dieRollerFrame = null;
	private Die _oneHundredSidedDie = null;
	private DefaultListModel _recentRollsListModel = null;
	private int _mostRecentRollValue = 0;
	private Integer _lastDisplayedRoll = null;
	private enum DieType {NORMAL, OPEN_ENDED, OPEN_ENDED_DOWN, OPEN_ENDED_UP, GM_CONFIGURED};
	
	public DieRollerFrameController() {
		super();
		_oneHundredSidedDie = new Die(100);
	}

	@Override
	public void makeFrameVisable() {
		_dieRollerFrame.pack();
		_dieRollerFrame.setVisible(true);
	}

	public void setFrame(DieRollerJFrame aFrame ) {
		_dieRollerFrame = aFrame;
		aFrame.setLocation(60,60);
	}
	
	void gmConfiguredDieButtonClicked() {
		rollDie(DieType.GM_CONFIGURED);
	}
	
	void openEndedUpDieButtonClicked() {

		rollDie(DieType.OPEN_ENDED_UP);
	}

	void openEndedDieDownButtonClicked() {

		rollDie(DieType.OPEN_ENDED_DOWN);
	}

	void openEndedDieButtonClicked() {

		rollDie(DieType.OPEN_ENDED);
	}

	void normalDieButtonClicked() {

		rollDie(DieType.NORMAL);
	}
	
	void currentRollJSpinnerStateChanged() {
		//_mostRecentRollValue = (Integer)_dieRollerFrame.getCurrentRollJSpinner().getValue();
		//updateCurrentRoll();
	}
	
	private void rollDie(DieType aDieType) {
		
		int currentTotal = 0;
		int numberOfRollsExecuted = 0;
		Die gmConfiguredDie = null;
		if (DieType.GM_CONFIGURED.equals(aDieType)) {
			int numberOfSides = new Integer((Integer)_dieRollerFrame.getGMConfiguredSidedJSpinner().getValue()).intValue();
			if (numberOfSides > 1) {
				gmConfiguredDie = new Die(numberOfSides);
			}
		}
		while ( numberOfRollsExecuted < getNumberOfDice()) {
			int thisRoll = 0;
			if (DieType.NORMAL.equals(aDieType)) {
				thisRoll = _oneHundredSidedDie.roll();
			} else {
				if (DieType.OPEN_ENDED.equals(aDieType)) {
					thisRoll = _oneHundredSidedDie.rollOpenEnded();
				} else {
					if (DieType.OPEN_ENDED_DOWN.equals(aDieType)) {
						thisRoll = _oneHundredSidedDie.rollOpenEndedDown();
					} else {
						if (DieType.OPEN_ENDED_UP.equals(aDieType)) {
							thisRoll = _oneHundredSidedDie.rollOpenEndedUp();
						} else {
							if (DieType.GM_CONFIGURED.equals(aDieType)) {
								if (gmConfiguredDie != null) {
									thisRoll = gmConfiguredDie.roll();
								}
							}
						}
					}
				}
			}
			currentTotal = currentTotal + thisRoll;
			numberOfRollsExecuted++;
		}
		_mostRecentRollValue = currentTotal;
		updateCurrentRoll();

	}

	private int getNumberOfDice() {
		return ((Integer)_dieRollerFrame.getNumberofDiceJSpinner().getValue()).intValue();
	}
	ListModel getRecentRollsListModel() {
		if (_recentRollsListModel == null) {
			initializeRecentRollsListModel();
		}
		return _recentRollsListModel;
	}
	private void initializeRecentRollsListModel() {
		_recentRollsListModel = new DefaultListModel();
		_recentRollsListModel.capacity();
	}

	private void updateCurrentRoll() {
		_lastDisplayedRoll = (Integer)_dieRollerFrame.getCurrentRollJSpinner().getValue();
		_dieRollerFrame.getCurrentRollJSpinner().setValue(_mostRecentRollValue);
		updateRecentRollsListModel();
	}
	
	private void updateRecentRollsListModel() {
		if (_lastDisplayedRoll != null && (! _recentRollsListModel.isEmpty()) && _lastDisplayedRoll.equals(_recentRollsListModel.get(0))) {
			return;
		}
		if (! (_recentRollsListModel.getSize() < NUMBER_OF_RECENT_ROLLS_TO_DISPLAY)) {
			_recentRollsListModel.removeElementAt(_recentRollsListModel.getSize() - 1);
		}
		// make everything a consistent number of characters.  Right pad with spaces.  The number s/b 
		// left justified.
		String displayString = _lastDisplayedRoll.toString();
		if (displayString.length() < LENGTH_OF_RECENT_ROLLS_STRING) {
			StringBuffer aBuffer = new StringBuffer(displayString);
			while(aBuffer.length() < LENGTH_OF_RECENT_ROLLS_STRING) {
				aBuffer.append(" ");
			}
			displayString = aBuffer.toString();
		}
		_recentRollsListModel.add(0, displayString);
	}

}
