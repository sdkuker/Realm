package com.sdk.realm.player.ui;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;

import com.sdk.realm.character.ui.CharacterListTableDataModel;
import com.sdk.realm.player.domain.Player;
import com.sdk.realm.player.domain.PlayerWarehouse;
import com.sdk.realm.ui.Controller;

public class PlayerFrameController extends Controller {

	private PlayerJFrame _playerFrame = null;

	public PlayerFrameController(PlayerJFrame aFrame) {
		super();
		_playerFrame = aFrame;
		aFrame.setLocation(100,100);
		_playerFrame.getPlayerTable().putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		_playerFrame.getPlayerTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		initializeTableColumnSizes(_playerFrame.getPlayerTable());
	}

	
	private void initializeTableColumnSizes(JTable characterListTable) {
		
		Enumeration<TableColumn> columnsEnumeration = _playerFrame.getPlayerTable().getColumnModel().getColumns();
		while (columnsEnumeration.hasMoreElements()) {
			TableColumn aColumn = columnsEnumeration.nextElement();
			if (aColumn.getModelIndex() == PlayerTableDataModel.ID_INDEX) {
				aColumn.setPreferredWidth(5);
			} else {
				aColumn.setPreferredWidth(100);
			}
		}
	}
	@Override
	public void makeFrameVisable() {
		refreshTableFromDomain();
		_playerFrame.pack();
		_playerFrame.setVisible(true);
	}

	private void refreshTableFromDomain() {
		
		List<Player> players = new ArrayList<Player>(PlayerWarehouse.getCurrent().getAllPlayers());
		_playerFrame.getTableDataModel().setPlayers(players);
		_playerFrame.getPlayerTable().repaint();
	}
	
	/*
	 * respond to a 'player changed' event.  Send the players to the domain and persist
	 * every change automatically.
	 */
	void playersChanged(List<Player> aListOfPlayers) {
		
		PlayerWarehouse.getCurrent().setAllPlayers(new HashSet<Player>(aListOfPlayers));
		PlayerWarehouse.getCurrent().persistAll();
		refreshTableFromDomain();
	}
	
	void deletePlayerJButtonClicked() {
		
		int selectedRow = _playerFrame.getPlayerTable().getSelectedRow();
		Player selectedPlayer = _playerFrame.getTableDataModel().getPlayerAtRow(selectedRow);
		
		String playerRemovalErrorDescription = PlayerWarehouse.getCurrent().deletePlayer(selectedPlayer, true);
		
		if (playerRemovalErrorDescription != null) {
			JOptionPane.showMessageDialog(_playerFrame, playerRemovalErrorDescription);
		} else {
			refreshTableFromDomain();
		}
	}
	
	void deleteAllPlayersJButtonClicked() {
				
		String playerRemovalErrorDescription = PlayerWarehouse.getCurrent().deleteAllPlayers();
		
		if (playerRemovalErrorDescription != null) {
			JOptionPane.showMessageDialog(_playerFrame, playerRemovalErrorDescription);
		} 
		refreshTableFromDomain();
	}
}
