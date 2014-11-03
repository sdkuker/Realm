package com.sdk.realm.willcontest.ui;

import java.util.Iterator;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

import com.sdk.realm.combat.domain.Round;
import com.sdk.realm.ui.Controller;
import com.sdk.realm.willcontest.domain.WillContest;
import com.sdk.realm.willcontest.domain.WillContestRound;
import com.sdk.realm.willcontest.domain.WillContestWarehouse;
import com.sdk.realm.willcontest.domain.WillContestant;
import com.sdk.realm.willcontest.domain.WillContestantWarehouse;

public class WillContestFrameController extends Controller {

	private DefaultComboBoxModel contestantOneComboBoxModel;
	private DefaultComboBoxModel contestantTwoComboBoxModel;
	private WillContestListFrameController willContestListFrameController;
	private WillContestJFrame willContestFrame;
	private int willContestID;
	private WillContest willContest;
	private WillContestRound displayedRound;
	private WillContestRound openRound;

	public WillContestFrameController(WillContestListFrameController aWillContestListFrameController) {
		super();
		contestantOneComboBoxModel = new DefaultComboBoxModel();
		contestantTwoComboBoxModel = new DefaultComboBoxModel();
		willContestListFrameController = aWillContestListFrameController;
	}
	
	public void setFrame(WillContestJFrame aFrame) {
		willContestFrame = aFrame;
		aFrame.setLocation(280,180);
	}

	@Override
	public void makeFrameVisable() {
		refreshFromDomain();
		willContestFrame.pack();
		willContestFrame.setVisible(true);
	}
	
	void refreshFromDomain() {
		WillContest  myContest = WillContestWarehouse.getCurrent().getContest(willContestID);
		if (myContest != null) {
			willContest = myContest;
			contestantOneComboBoxModel.setSelectedItem(null);
			contestantTwoComboBoxModel.setSelectedItem(null);
			refreshDomainFields();
		} else {
			refreshContestantComboBoxes();
		}
		willContestListFrameController.refreshTableFromDomain();
	}

	ComboBoxModel getContestantOneComboBoxModel() {
		return contestantOneComboBoxModel;
	}
	
	ComboBoxModel getContestantTwoComboBoxModel() {
		return contestantTwoComboBoxModel;
	}

	
	void createAndDisplayNewContest() {
		
		WillContest aContest = WillContestWarehouse.getCurrent().createAndAddNewContest();
		willContestID = aContest.getId();
		openRound = null;
		displayedRound = null;
		willContestFrame.getDisplayedRoundJSpinner().getModel().setValue(0);
		WillContestWarehouse.getCurrent().persistAll();
		refreshFromDomain();
		
	}
	void nextRoundJButtonClicked() {
		
		// populate the contestants
		String currentlySelectedContestantOneName = (String) contestantOneComboBoxModel.getSelectedItem();
		WillContestant contestantOne = WillContestantWarehouse.getCurrent().getContestantNamed(currentlySelectedContestantOneName);
		willContest.setContestantOne(contestantOne);
		
		String currentlySelectedContestantTwoName = (String) contestantTwoComboBoxModel.getSelectedItem();
		WillContestant contestantTwo = WillContestantWarehouse.getCurrent().getContestantNamed(currentlySelectedContestantTwoName);
		willContest.setContestantTwo(contestantTwo);
		
		WillContestRound newRound = willContest.generateNextRound();
		openRound = newRound;
		setDisplayedRound(newRound);
		updateDisplayedRoundJSpinnerValue();
		WillContestWarehouse.getCurrent().persistAll();
		refreshFromDomain();
		//((SpinnerNumberModel) willContestFrame.getDisplayedRoundJSpinner().getModel()).setMaximum(newRound.getId());
	}
	
	void updateDisplayedRoundJSpinnerValue() {
		
		if (getDisplayedRound() != null) {
			willContestFrame.getDisplayedRoundJSpinner().setValue(getDisplayedRound().getRoundNumber());	
		}
	}
	
	void displayedRoundJSpinnerStateChanged() {
		int selectedRound = ((Integer)willContestFrame.getDisplayedRoundJSpinner().getValue()).intValue();
		if (selectedRound > 0 &&  ! (willContest.getNumberOfRounds() < selectedRound)) {
			setDisplayedRound(willContest.getRound(selectedRound));
		}
		refreshFromDomain();
	}
	private void refreshContestantComboBoxes() {
		Object currentlySelectedComboBoxOneItem = contestantOneComboBoxModel
				.getSelectedItem();
		Object currentlySelectedComboBoxTwoItem = contestantTwoComboBoxModel
				.getSelectedItem();
		contestantOneComboBoxModel.removeAllElements();
		contestantTwoComboBoxModel.removeAllElements();
		Iterator<WillContestant> contestantIterator = WillContestantWarehouse
				.getCurrent().getAllContestants().iterator();
		while (contestantIterator.hasNext()) {
			String contestantName = contestantIterator.next().getName();
			contestantOneComboBoxModel.addElement(contestantName);
			contestantTwoComboBoxModel.addElement(contestantName);
		}
		if (currentlySelectedComboBoxOneItem != null) {
			contestantOneComboBoxModel
					.setSelectedItem(currentlySelectedComboBoxOneItem);
		} else {
			if (willContest != null
					&& willContest.getContestantOne() != null) {
				contestantOneComboBoxModel.setSelectedItem(willContest
						.getContestantOne().getName());
			}
		}
		if (currentlySelectedComboBoxTwoItem != null) {
			contestantTwoComboBoxModel
					.setSelectedItem(currentlySelectedComboBoxTwoItem);
		} else {
			if (willContest != null
					&& willContest.getContestantTwo() != null) {
				contestantTwoComboBoxModel.setSelectedItem(willContest
						.getContestantTwo().getName());
			}
		}
	}
	public int getWillContestID() {
		return willContestID;
	}
	
	public void setWillContestID(int anID) {
		willContestID = anID;
	}

	private void refreshDomainFields() {
		refreshContestantComboBoxes();
		if (openRound != null) {
			willContestFrame.getOpenRoundJLabel().setText(new Integer(openRound.getRoundNumber()).toString());
		} else {
			willContestFrame.getOpenRoundJLabel().setText("0");
		}
		if (displayedRound != null) {
			willContestFrame.getRoundNumberFormattedTextField().setValue(displayedRound.getRoundNumber());
			willContestFrame.getContestantOneTotalWillFormattedTextField().setValue(displayedRound.getContestantOneTotalWill());
			willContestFrame.getContestantTwoTotalWillFormattedTextField().setValue(displayedRound.getContestantTwoTotalWill());
			willContestFrame.getPermanentModifierFormattedTextField().setValue(displayedRound.getContestantOnePermanentModifier());
			willContestFrame.getTemporaryModifierFormattedJTextField().setValue(displayedRound.getContestantOneTemporaryModifier());
			willContestFrame.getTemporaryModifierExpirationRoundFormattedTextField().setValue(displayedRound.getContestantOneTemporaryModifierExpirationRound());	
			willContestFrame.getConsequenceJTextArea().setText(displayedRound.getConsequenceDescription());
		} else {
			willContestFrame.getRoundNumberFormattedTextField().setValue(0);
			willContestFrame.getContestantOneTotalWillFormattedTextField().setValue(0);
			willContestFrame.getContestantTwoTotalWillFormattedTextField().setValue(0);
			willContestFrame.getPermanentModifierFormattedTextField().setValue(0);
			willContestFrame.getTemporaryModifierFormattedJTextField().setValue(0);
			willContestFrame.getTemporaryModifierExpirationRoundFormattedTextField().setValue(0);	
			willContestFrame.getConsequenceJTextArea().setText(null);

		}
	}

	private WillContestRound getDisplayedRound() {
		return displayedRound;
	}

	void setDisplayedRound(WillContestRound displayedRound) {
		this.displayedRound = displayedRound;
	}
	
	void setOpenRound(WillContestRound anOpenRound) {
		this.openRound = anOpenRound;
	}

}
