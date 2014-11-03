package com.sdk.realm.herblore.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sdk.realm.herblore.domain.Herb;

public class SearchResultsTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 580476308399454078L;
	//private String[] _columnNames = {"Name", "Classification", "Effect", "Attack Level", "Form/Prep", "Cost/Rarity"};
	private String[] _columnNames = {"Name", "Classification"};
	private List<Herb> _searchResults = new ArrayList<Herb>();

	public SearchResultsTableModel() {
		super();
	}

	public int getColumnCount() {
		
		return _columnNames.length;
	}
	
	@Override
    public String getColumnName(int column) {
    	
    	String columnName = "asked for column out of range";
    	
    	if (column < (getColumnCount())) {
    		columnName = _columnNames[column];
    	}
    	
    	return columnName;
    }

	public int getRowCount() {
		
		return _searchResults.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Object theReturn = null;
		
		Herb desiredHerb = _searchResults.get(rowIndex);

		switch(columnIndex) {
		case 0:
			theReturn = desiredHerb.getName();
			break;
		case 1:
			theReturn = desiredHerb.getClassification();
			break;
		case 2:
			theReturn = desiredHerb.getEffect();
			break;
		case 3:
			theReturn = desiredHerb.getAttackLevel();
			break;
		case 4:
			theReturn = desiredHerb.getFormAndPreperation();
			break;
		case 5:
			theReturn = desiredHerb.getCostRarity();
			break;
		default:
			theReturn = "unknown";
		}
		return theReturn;
	}

	void setSearchResults(List<Herb> newSearchResults) {
		_searchResults = newSearchResults;
		fireTableDataChanged();
	}
	
	Herb getResultAtRow(int rowIndex) {
		return _searchResults.get(rowIndex);
	}
}
