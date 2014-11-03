package com.sdk.realm.movement.maneuver.ui;

import java.util.Arrays;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import com.sdk.realm.domain.common.Die;
import com.sdk.realm.movement.maneuver.domain.MovementManeuver;
import com.sdk.realm.movement.maneuver.domain.MovementManeuverLibrary;
import com.sdk.realm.movement.maneuver.domain.MovementManeuver.MovementManeuverDifficulty;
import com.sdk.realm.ui.Controller;

public class MovementManeuverFrameController extends Controller {

	private static final int NUMBER_OF_MOVEMENTS_TO_DISPLAY = 5;
	private DefaultComboBoxModel difficultyComboBoxModel;
	private DefaultListModel recentMovementsListModel;
	private MovementManeuverJFrame movementManeuverFrame;
	private Die oneHundredSidedDie = null;
	private int mostRecentRollValue = 0;
	private String lastDisplayedMovement;
	
	public MovementManeuverFrameController() {
		super();
		oneHundredSidedDie = new Die(100);
	}

	public void makeFrameVisable() {
		movementManeuverFrame.pack();
		movementManeuverFrame.setVisible(true);
	}
	
	public void setFrame(MovementManeuverJFrame aFrame) {
		movementManeuverFrame = aFrame;
		aFrame.setLocation(80,80);
	}

	ComboBoxModel getDifficultyComboBoxModel() {
		if (difficultyComboBoxModel == null) {
			initializeDifficultyComboBoxModel();
		}
		return difficultyComboBoxModel;
	}
	private void initializeDifficultyComboBoxModel() {
		Object[] allTypes = MovementManeuverLibrary.getCurrent().getAllMovementManeuverTypes().toArray();
		Arrays.sort(allTypes);
		difficultyComboBoxModel = new DefaultComboBoxModel(allTypes);
	}
	
	void difficultyJComboBoxItemSelected() {
		clearCurrentManueuverDescriptionJTextArea();
	}
	
	ListModel getRecentMovementsListModel() {
		if (recentMovementsListModel == null) {
			initializeRecentMovementsListModel();
		}
		return recentMovementsListModel;
	}
	private void initializeRecentMovementsListModel() {
		recentMovementsListModel = new DefaultListModel();
		recentMovementsListModel.capacity();
	}
	
	void listMovementManeuversButtonClicked() {
		
		int rollResult = new Integer((Integer)movementManeuverFrame.getRollResultJSpinner().getModel().getValue()).intValue();
		MovementManeuver selectedManeuver = MovementManeuverLibrary.getCurrent().getMovementManeuver(rollResult);
		StringBuffer aStringBuffer = new StringBuffer();
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.TRIVIAL, aStringBuffer);
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.ROUTINE, aStringBuffer);
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.EASY, aStringBuffer);
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.LIGHT, aStringBuffer);
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.MEDIUM, aStringBuffer);
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.HARD, aStringBuffer);
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.VERY_HARD, aStringBuffer);
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.EXTREMELY_HARD, aStringBuffer);
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.SHEER_FOLLY, aStringBuffer);
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.ABSURD, aStringBuffer);
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.INSANE, aStringBuffer);
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.PHENOMENAL, aStringBuffer);
		addMovementDescription(selectedManeuver, MovementManeuverDifficulty.VIRTUALLY_IMPOSSIBLE, aStringBuffer);
		
		movementManeuverFrame.getCurrentMovementDescriptionJTextArea().setText(aStringBuffer.toString());
	}
	
	private void addMovementDescription(MovementManeuver selectedManeuver, MovementManeuverDifficulty aDifficulty, StringBuffer aStringBuffer) {
		aStringBuffer.append(aDifficulty.name());
		aStringBuffer.append(":");
		aStringBuffer.append(selectedManeuver.getMovementManeuverResult(aDifficulty));
		aStringBuffer.append("\n");
	}
	
	void getMovementManeuverButtonClicked() {
		
		moveCurrentManeuverToRecentMovements();
		
		String difficultyString = (String) movementManeuverFrame.getDifficultyJComboBox().getSelectedItem();
		int rollResult = new Integer((Integer)movementManeuverFrame.getRollResultJSpinner().getModel().getValue()).intValue();
		MovementManeuver selectedManeuver = MovementManeuverLibrary.getCurrent().getMovementManeuver(rollResult);
		MovementManeuverDifficulty aDifficulty = MovementManeuverDifficulty.valueOf(difficultyString);
		String displayText = null;
		
		if (selectedManeuver == null) {
			displayText = "No movement maneuver was found that matches the difficulty and roll";
		}
		else {
			displayText = selectedManeuver.getMovementManeuverResult(aDifficulty);
		}
		movementManeuverFrame.getCurrentMovementDescriptionJTextArea().setText(displayText);
	}
	
	void rollResultSpinnerStateChanged() {
		clearCurrentManueuverDescriptionJTextArea();
	}
	
	void openEndedRollButtonClicked() {
		mostRecentRollValue = oneHundredSidedDie.rollOpenEnded();
		updateRollResult();
	}
	
	private void updateRollResult() {
		movementManeuverFrame.getRollResultJSpinner().getModel().setValue(mostRecentRollValue);
		clearCurrentManueuverDescriptionJTextArea();
	}
	
	private void moveCurrentManeuverToRecentMovements() {
		String currentContents = movementManeuverFrame.getCurrentMovementDescriptionJTextArea().getText();
		if (currentContents != null && currentContents.length() > 0) {
			lastDisplayedMovement = currentContents;
			updateRecentMovementsListModel();
		}
	}
	
	private void clearCurrentManueuverDescriptionJTextArea() {
		movementManeuverFrame.getCurrentMovementDescriptionJTextArea().setText(null);
	}
	
	private void updateRecentMovementsListModel() {
		if (! (recentMovementsListModel.getSize() < NUMBER_OF_MOVEMENTS_TO_DISPLAY)) {
			recentMovementsListModel.removeElementAt(recentMovementsListModel.getSize() - 1);
		}
		recentMovementsListModel.add(0, lastDisplayedMovement);
	}
}
