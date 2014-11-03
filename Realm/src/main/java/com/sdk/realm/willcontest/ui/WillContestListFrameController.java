package com.sdk.realm.willcontest.ui;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.sdk.realm.combat.ui.CombatFrameController;
import com.sdk.realm.ui.Controller;
import com.sdk.realm.willcontest.domain.WillContest;
import com.sdk.realm.willcontest.domain.WillContestRound;
import com.sdk.realm.willcontest.domain.WillContestWarehouse;

public class WillContestListFrameController extends Controller {

	private WillContestListJFrame willContestListFrame;
	private WillContestFrameController willContestFrameController;
	
	public WillContestListFrameController(WillContestListJFrame aFrame) {
		super();
		willContestListFrame = aFrame;
		aFrame.setLocation(140,140);
		willContestListFrame.getWillContestListJTable().putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		initializeTableColumnSizes(aFrame.getWillContestListJTable());

	}

	@Override
	public void makeFrameVisable() {
		refreshTableFromDomain();
		willContestListFrame.pack();
		willContestListFrame.setVisible(true);
	}

	void refreshTableFromDomain() {
		
		List<WillContest> willContests = new ArrayList<WillContest>();
		willContests.addAll(WillContestWarehouse.getCurrent().getAllWillContests());
		willContestListFrame.getTableDataModel().setWillContests(willContests);
		willContestListFrame.getWillContestListJTable().repaint();
	}
		
	private void initializeTableColumnSizes(JTable willContestListTable) {
		
		Enumeration<TableColumn> columnsEnumeration = willContestListTable.getColumnModel().getColumns();
		while (columnsEnumeration.hasMoreElements()) {
			TableColumn aColumn = columnsEnumeration.nextElement();
			if (aColumn.getModelIndex() == WillContestListTableDataModel.CONTESTANT_ONE_NAME_INDEX || 
				aColumn.getModelIndex() == WillContestListTableDataModel.CONTESTANT_TWO_NAME_INDEX) {
				aColumn.setPreferredWidth(50);
			} else {
				aColumn.setPreferredWidth(100);
			}
		}
	}

	void deleteWillContestJButtonClicked() {
		
		if (willContestListFrame.getWillContestListJTable().getSelectedRowCount() < 1) {
			JOptionPane.showMessageDialog(willContestListFrame, "Must select at least one conttest to delete");
		} else {
			int[] selectedContestRows = willContestListFrame.getWillContestListJTable().getSelectedRows();
			for (int index = 0; index < selectedContestRows.length; index++) {
				WillContest selectedContest = willContestListFrame.getTableDataModel().getWillContests().get(selectedContestRows[index]);
				WillContestWarehouse.getCurrent().delete(selectedContest);
			}
			refreshTableFromDomain();
		}
	}
	
	void deleteAllWillContestsJButtonClicked() {
		
		WillContestWarehouse.getCurrent().deleteAllContests();
		refreshTableFromDomain();
	}

	void openContestJButtonClicked() {
		
		if (willContestListFrame.getWillContestListJTable().getSelectedRowCount() != 1) {
			JOptionPane.showMessageDialog(willContestListFrame, "Must select one will contest to open");
		} else {
			int selectedContestRow = willContestListFrame.getWillContestListJTable().getSelectedRow();
			if (selectedContestRow > WillContestWarehouse.getCurrent().getAllWillContests().size() - 1) {
				JOptionPane.showMessageDialog(willContestListFrame, "Must select a row that displays a contest");
			} else {
				WillContest selectedContest = willContestListFrame.getTableDataModel().getWillContests().get(selectedContestRow); 
				getWillContestFrameController().setWillContestID(selectedContest.getId());
				WillContestRound openRound = null;
				if (selectedContest.getRounds().size() > 0) {
					openRound = selectedContest.getRounds().get(selectedContest.getRounds().size() - 1);
				}
				getWillContestFrameController().setOpenRound(openRound);
				getWillContestFrameController().setDisplayedRound(openRound);
				getWillContestFrameController().refreshFromDomain();
				getWillContestFrameController().updateDisplayedRoundJSpinnerValue();
				getWillContestFrameController().makeFrameVisable();
			}
		}
		
	}
	
	void createContestJButtonClicked() {
		
		getWillContestFrameController().createAndDisplayNewContest();
		getWillContestFrameController().makeFrameVisable();		
	}

	
	private WillContestFrameController getWillContestFrameController() {
		
		if (willContestFrameController == null) {
			WillContestFrameController aController = new WillContestFrameController(this);
			WillContestJFrame aFrame = new WillContestJFrame(aController);
			aFrame.setTitle("Realm - Will Contest");
			aController.setFrame(aFrame);
			willContestFrameController = aController;
		}
		
		return willContestFrameController;
	}


}
