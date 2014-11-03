package com.sdk.realm.combat.ui;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.sdk.realm.combat.domain.CombatEncounter;
import com.sdk.realm.combat.domain.CombatEncounterWarehouse;
import com.sdk.realm.combat.persistance.CombatEncounterPersistenceResult;
import com.sdk.realm.ui.Controller;

public class CombatListFrameController extends Controller {

	private CombatListJFrame _combatListFrame;
	private CombatFrameController _combatFrameController;
	
	public CombatListFrameController(CombatListJFrame aFrame) {
		super();
		_combatListFrame = aFrame;
		aFrame.setLocation(140,140);
		_combatListFrame.getCombatListJTable().putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		initializeTableColumnSizes(aFrame.getCombatListJTable());

	}

	@Override
	public void makeFrameVisable() {
		refreshTableFromDomain();
		_combatListFrame.pack();
		_combatListFrame.setVisible(true);
	}

	void refreshTableFromDomain() {
		
		List<CombatEncounter> combatEncounters = new ArrayList<CombatEncounter>();
		combatEncounters.addAll(CombatEncounterWarehouse.getCurrent().getAllCombatEncounters());
		_combatListFrame.getTableDataModel().setCombatEncounters(combatEncounters);
		_combatListFrame.getCombatListJTable().repaint();
	}
	
	/*
	 * respond to a 'combat event changed' event.  Send the events to the domain and persist
	 * every change automatically.
	 */
	void combatEncounterChanged(CombatEncounter anEncounter) {

		CombatEncounterPersistenceResult persistenceResult = CombatEncounterWarehouse.getCurrent().updateCombatEncounter(anEncounter);	
		if (persistenceResult.wasSuccessfull()) {
			refreshTableFromDomain();
		} else {
			StringBuffer aBuffer = new StringBuffer();
			if (persistenceResult.getValidationErrors().contains(CombatEncounterPersistenceResult.VALIDATION_ERROR.fileNameAlreadyUsed)) {
				aBuffer.append("The file name has already been used for another encounter.  Choose one that has not already been used. ");
			}
			
			if (persistenceResult.getValidationErrors().contains(CombatEncounterPersistenceResult.VALIDATION_ERROR.noFileNameSpecified)) {
				aBuffer.append("The encounter will not be saved until a file name has been specified.  Specify one and try again.");
			}

			JOptionPane.showMessageDialog(_combatListFrame, aBuffer.toString());
		}
	}

	
	private void initializeTableColumnSizes(JTable combatListTable) {
		
		Enumeration<TableColumn> columnsEnumeration = combatListTable.getColumnModel().getColumns();
		while (columnsEnumeration.hasMoreElements()) {
			TableColumn aColumn = columnsEnumeration.nextElement();
			if (aColumn.getModelIndex() == CombatListTableDataModel.DESCRIPTION_INDEX) {
				aColumn.setPreferredWidth(250);
			} else {
				aColumn.setPreferredWidth(100);
			}
		}
	}

	void deleteCombatJButtonClicked() {
		
		if (_combatListFrame.getCombatListJTable().getSelectedRowCount() < 1) {
			JOptionPane.showMessageDialog(_combatListFrame, "Must select at least one combat to delete");
		} else {
			int[] selectedCombatRows = _combatListFrame.getCombatListJTable().getSelectedRows();
			for (int index = 0; index < selectedCombatRows.length; index++) {
				CombatEncounter selectedCombat = _combatListFrame.getTableDataModel().getCombatEncounters().get(selectedCombatRows[index]);
				CombatEncounterWarehouse.getCurrent().delete(selectedCombat);
			}
			refreshTableFromDomain();
		}
	}
	
	void addCombatJButtonClicked() {
		CombatEncounterWarehouse.getCurrent().createAndAddNewCombatEncounter();
		refreshTableFromDomain();
	}

	void openCombatJButtonClicked() {
		
		if (_combatListFrame.getCombatListJTable().getSelectedRowCount() != 1) {
			JOptionPane.showMessageDialog(_combatListFrame, "Must select one combat to open");
		} else {
			int selectedCombatRow = _combatListFrame.getCombatListJTable().getSelectedRow();
			CombatEncounter selectedCombat = _combatListFrame.getTableDataModel().getCombatEncounters().get(selectedCombatRow); 
			getCombatFrameController().setCombatEncounter(selectedCombat);
			getCombatFrameController().makeFrameVisable();
		}
		
	}
	
	private CombatFrameController getCombatFrameController() {
		
		if (_combatFrameController == null) {
			CombatFrameController aController = new CombatFrameController(this);
			CombatJFrame aFrame = new CombatJFrame(aController);
			aFrame.setTitle("Realm - Combat");
			aController.setFrame(aFrame);
			_combatFrameController = aController;
		}
		
		return _combatFrameController;
	}


}
