package com.sdk.realm.willcontest.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sdk.realm.combat.domain.CombatEncounter;
import com.sdk.realm.willcontest.domain.WillContest;

public class WillContestListTableDataModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final String[] _columnNames = {"ContestantOne", "Contestant Two", "Status"};
	private static final int MAXIMUM_NUMBER_OF_ROWS = 5;
	
	static final int CONTESTANT_ONE_NAME_INDEX = 0;
	static final int CONTESTANT_TWO_NAME_INDEX = 1;
	private static final int STATUS_INDEX = 2;
	//private static final int GM_NOTES_INDEX = 3;

	private List<WillContest> willContests = new ArrayList<WillContest> ();
	private WillContestListFrameController myFrameController;
	
	public WillContestListTableDataModel() {
	}

	void setMyFrameController(WillContestListFrameController aController) {
		myFrameController = aController;
	}
	
	public String getColumnName(int anIndex) {
		return _columnNames[anIndex];
	}

	public int getColumnCount() {
		return _columnNames.length;
	}

	public int getRowCount() {
		return Math.max(MAXIMUM_NUMBER_OF_ROWS, willContests.size());
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Object theReturn= null;
		
		if (willContests.size() > rowIndex) {
			WillContest aContest = willContests.get(rowIndex);
			switch(columnIndex) {
			case CONTESTANT_ONE_NAME_INDEX:
				if (aContest.getContestantOne() != null) {
					theReturn = aContest.getContestantOne().getName();
				}
				break;
			case CONTESTANT_TWO_NAME_INDEX:
				if (aContest.getContestantTwo() != null) {
					theReturn = aContest.getContestantTwo().getName();
				}
				break;
			case STATUS_INDEX:
				theReturn = aContest.getCurrentStatus();
				break;
			default:
				theReturn = "No Data for column index: " + columnIndex;
			}
		}
		
		return theReturn;
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// can't update this one...
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	void setWillContests(List<WillContest> listOfContests) {
		willContests = listOfContests;
		fireTableDataChanged();
	}

	List<WillContest> getWillContests() {
		return willContests;
	}
}
