package com.sdk.realm.player.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sdk.realm.player.domain.Player;
import com.sdk.realm.player.domain.PlayerWarehouse;

public class PlayerTableDataModel extends AbstractTableModel {

	private static final long serialVersionUID = -8659825308215576186L;
	private static final String[] _columnNames = {"ID", "Name"};
	private static final int MAXIMUM_NUMBER_OF_ROWS = 10;
	static final int ID_INDEX = 0;
	private static final int NAME_INDEX = 1;
	
	private List<Player> _players = new ArrayList<Player> ();
	private PlayerFrameController _myFrameController;
	private PlayerComparator _playerComparator = new PlayerComparator();

	public PlayerTableDataModel() {
	}

	public String getColumnName(int anIndex) {
		return _columnNames[anIndex];
	}
	
	void setMyFrameController(PlayerFrameController aController) {
		_myFrameController = aController;
	}
	public int getColumnCount() {
		
		return _columnNames.length;
	}

	public int getRowCount() {

		return Math.max(MAXIMUM_NUMBER_OF_ROWS, _players.size() + 1);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Object theReturn= null;
		
		if (_players.size() > rowIndex) {
			Player aPlayer = _players.get(rowIndex);
			if (columnIndex == NAME_INDEX) {
				theReturn = aPlayer.getName();
			} else {
				if (columnIndex == ID_INDEX){
					theReturn = new Integer(aPlayer.getId());
				}
			}
		}
		
		return theReturn;
	}

	void setPlayers(List<Player> listOfPlayers) {
			_players = listOfPlayers;
			Collections.sort(_players, _playerComparator);
			fireTableDataChanged();
	}
	
	Player getPlayerAtRow(int aRowNumber) {
		return _players.get(aRowNumber);
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		Player aPlayer = null;
		
		if ((rowIndex + 1) > _players.size()) {
			aPlayer = PlayerWarehouse.getCurrent().createPlayer();
			_players.add(aPlayer);
		} else {
			aPlayer = _players.get(rowIndex);
		}

		if (columnIndex == NAME_INDEX) {
			aPlayer.setName((String) aValue);
		}
			
		_myFrameController.playersChanged(_players);
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public boolean isCellEditable(int row, int column) {
		
		boolean theReturn = false;
		if (column == NAME_INDEX) {
			theReturn = true;
		}
		
		return theReturn;
	}
}
