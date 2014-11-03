package com.sdk.realm.resistancetable.ui;

import java.util.ArrayList;
import java.util.List;

import com.sdk.realm.resistancetable.domain.ResistanceCalculation;
import com.sdk.realm.resistancetable.domain.ResistanceTableCalculator;
import com.sdk.realm.ui.Controller;

public class ResistanceTableFrameController extends Controller {

	private ResistanceTableFrame _resistanceTableFrame = null;
	private ResistanceTableCalculator _resistanceTableCalculator = null;
	private List<ResistanceCalculation> _savedCalculationList = new ArrayList<ResistanceCalculation> ();
	
	public ResistanceTableFrameController(ResistanceTableFrame aFrame, ResistanceTableCalculator aCalculator) {
		
		super();
		_resistanceTableFrame = aFrame;
		aFrame.setLocation(40,40);
		_resistanceTableCalculator = aCalculator;
	}

	public void saveResistanceRollButtonClicked() {
		ResistanceCalculation aCalculation = new ResistanceCalculation();
		aCalculation.setAttackerLevel(getAttackerLevel());
		aCalculation.setTargetLevel(getTargetLevel());
		aCalculation.setRollRequiredToResistAttack(getRollRequiredFromTextField());
		_savedCalculationList.add(0, aCalculation);
		getTableDataModel().setSavedCalculations(_savedCalculationList);
		getTableDataModel().fireTableDataChanged();
		
	}
	
	private ResistanceRecentActivityTableDataModel getTableDataModel() {
		return (ResistanceRecentActivityTableDataModel) _resistanceTableFrame.getRecentActivityJTable().getModel();
	}
	
	public void makeFrameVisable() {
		_resistanceTableFrame.pack();
		_resistanceTableFrame.setVisible(true);
	}
	
	void attackSpinnerValueChanged() {
		calculateAndDisplayResistanceRoll();
	}
	void targetSpinnerValueChanged() {
		calculateAndDisplayResistanceRoll();
	}
	
	private int getAttackerLevel() {
		return ((Integer)_resistanceTableFrame.getAttackJSpinner().getValue()).intValue();
	}
	
	private int getTargetLevel() {
		return ((Integer)_resistanceTableFrame.getTargetJSpinner().getValue()).intValue();
	}

	private int getRollRequiredFromTextField() {
		return ( new Integer(_resistanceTableFrame.getResistanceRollJTextField().getText())).intValue();
	}

	void calculateAndDisplayResistanceRoll() {
		int resistanceRequired = _resistanceTableCalculator.calculateRollRequiredToResistAttack(getAttackerLevel(), getTargetLevel());
		_resistanceTableFrame.getResistanceRollJTextField().setText(new Integer(resistanceRequired).toString());
	}
}
