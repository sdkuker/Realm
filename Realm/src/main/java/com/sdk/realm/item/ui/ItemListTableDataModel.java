package com.sdk.realm.item.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sdk.realm.item.domain.Item;

public class ItemListTableDataModel extends AbstractTableModel {

	private static final long serialVersionUID = -8659825308215576186L;
	private static final String[] _columnNames = {"ID" , "Name", "Will", "Will Modifier"};
	private static final int MAXIMUM_NUMBER_OF_ROWS = 13;
	private static final int ITEM_ID_INDEX = 0;
	static final int ITEM_NAME_INDEX = 1;
	private static final int WILL_INDEX = 2;
	private static final int WILL_MODIFIER_INDEX = 3;
	
	private List<Item> items = new ArrayList<Item> ();
	private ItemListFrameController myFrameController;

	public ItemListTableDataModel() {
	}

	public String getColumnName(int anIndex) {
		return _columnNames[anIndex];
	}
	
	void setMyFrameController(ItemListFrameController aController) {
		myFrameController = aController;
	}
	public int getColumnCount() {
		
		return _columnNames.length;
	}

	public int getRowCount() {
		
		return Math.max(MAXIMUM_NUMBER_OF_ROWS, items.size());
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Object theReturn= null;
		
		if (items.size() > rowIndex) {
			Item anItem = items.get(rowIndex);
			switch(columnIndex) {
			case ITEM_ID_INDEX:
				theReturn = anItem.getId();
				break;
			case ITEM_NAME_INDEX:
				theReturn = anItem.getName();
				break;
			case WILL_INDEX:
				theReturn = anItem.getWill();
				break;
			case WILL_MODIFIER_INDEX:
				theReturn = anItem.getWillModifier();
				break;
			default:
				theReturn = "No Data for column index: " + columnIndex;
			}
		}
		
		return theReturn;
	}

	void setItems(List<Item> listOfItems) {
	
		items = listOfItems;
		fireTableDataChanged();
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		// you are not allowing them to update data here so just
		// skip this section.
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	List<Item> getItems() {
		return items;
	}
}
