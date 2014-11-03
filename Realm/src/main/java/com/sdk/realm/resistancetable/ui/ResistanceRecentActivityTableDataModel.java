package com.sdk.realm.resistancetable.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sdk.realm.resistancetable.domain.ResistanceCalculation;

public class ResistanceRecentActivityTableDataModel extends AbstractTableModel {

	private static final long serialVersionUID = -8889902635368046065L;
	private static final String[] _columnNames = {"Attacker Level", "Target Level", "Target Resists At" };
	private static final int MAXIMUM_NUMBER_OF_ROWS = 10;
	
	private List<ResistanceCalculation> _savedCalculationList = new ArrayList<ResistanceCalculation> ();

	public ResistanceRecentActivityTableDataModel() {
	}

	public String getColumnName(int anIndex) {
		return _columnNames[anIndex];
	}
	public int getColumnCount() {
		
		return _columnNames.length;
	}

	public int getRowCount() {
		// constant number of rows
		return MAXIMUM_NUMBER_OF_ROWS;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Integer theReturn= null;
		
		if (_savedCalculationList.size() > rowIndex) {
			ResistanceCalculation aCalc = _savedCalculationList.get(rowIndex);
			if (columnIndex == 0) {
				theReturn = aCalc.getAttackerLevel();
			} else {
				if (columnIndex == 1) {
					theReturn = aCalc.getTargetlevel();
				} else {
					theReturn = aCalc.getRollRequiredToResistAttack();
				}
			}
		}
		
		return theReturn;
	}

	void setSavedCalculations(List<ResistanceCalculation> listOfCalculations) {
		
		if (listOfCalculations.size() > MAXIMUM_NUMBER_OF_ROWS) {
			// take the ones at the beginning of the list
			_savedCalculationList = listOfCalculations.subList(0, MAXIMUM_NUMBER_OF_ROWS);
		} else {
			_savedCalculationList = listOfCalculations;
		}
	}
}
