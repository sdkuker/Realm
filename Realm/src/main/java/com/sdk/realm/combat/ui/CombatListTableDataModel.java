package com.sdk.realm.combat.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sdk.realm.combat.domain.CombatEncounter;

public class CombatListTableDataModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final String[] _columnNames = {"Description", "Last Modified"};
	private static final int MAXIMUM_NUMBER_OF_ROWS = 5;
	
	static final int DESCRIPTION_INDEX = 0;
	private static final int LAST_MODIFIED_INDEX = 1;

	private List<CombatEncounter> _combatEncounters = new ArrayList<CombatEncounter> ();
	private CombatListFrameController _myFrameController;
	
	public CombatListTableDataModel() {
	}

	void setMyFrameController(CombatListFrameController aController) {
		_myFrameController = aController;
	}
	
	public String getColumnName(int anIndex) {
		return _columnNames[anIndex];
	}

	public int getColumnCount() {
		return _columnNames.length;
	}

	public int getRowCount() {
		//return Math.max(MAXIMUM_NUMBER_OF_ROWS, _combatEncounters.size());
		return _combatEncounters.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Object theReturn= null;
		
		if (_combatEncounters.size() > rowIndex) {
			CombatEncounter anEncounter = _combatEncounters.get(rowIndex);
			switch(columnIndex) {
			case DESCRIPTION_INDEX:
				theReturn = anEncounter.getDescription();
				break;
			case LAST_MODIFIED_INDEX:
				theReturn = anEncounter.getDateLastModified();
				break;
			default:
				theReturn = "No Data for column index: " + columnIndex;
			}
		}
		
		return theReturn;
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		CombatEncounter anEncounter = null;
		
		if ((rowIndex + 1) > _combatEncounters.size()) {
			anEncounter = new CombatEncounter();
			_combatEncounters.add(anEncounter);
		} else {
			anEncounter = _combatEncounters.get(rowIndex);
		}

		if (columnIndex == DESCRIPTION_INDEX) {
			anEncounter.setDescription((String) aValue);
		}
				
		_myFrameController.combatEncounterChanged(anEncounter);
		fireTableCellUpdated(rowIndex, columnIndex);
	}


	public boolean isCellEditable(int row, int column) {
		if (LAST_MODIFIED_INDEX == column) {
			return false;
		} else {
			if (row < _combatEncounters.size()) {
				return true;
			} else {
				return false;
			}
			
		}
	}

	void setCombatEncounters(List<CombatEncounter> listOfEncounters) {
		_combatEncounters = listOfEncounters;
		fireTableDataChanged();
	}

	List<CombatEncounter> getCombatEncounters() {
		return _combatEncounters;
	}
}
