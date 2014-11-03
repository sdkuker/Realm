package com.sdk.realm.combat.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import com.sdk.realm.combat.domain.CharacterCombatRoundStatistics;
import com.sdk.realm.combat.domain.CombatEncounter;
import com.sdk.realm.combat.domain.CombatEncounterWarehouse;
import com.sdk.realm.combat.domain.Round;
import com.sdk.realm.criticalhit.ui.CriticalHitFrameController;
import com.sdk.realm.criticalhit.ui.CriticalHitJFrame;
import com.sdk.realm.ui.Controller;

public class CombatFrameController extends Controller {

	private CombatEncounter _combatEncounter;
	private Round _openRound;
	private Round _displayedRound;
	private List<CharacterCombatRoundStatistics>  _displayedRoundSortedStatistics = new ArrayList<CharacterCombatRoundStatistics>();
	private CombatJFrame _combatFrame;
	private CombatTableStatisticsComparator _myStatisticsComparator = new CombatTableStatisticsComparator();
	private CombatListFrameController _combatListFrameController;
	private CriticalHitFrameController _criticalHitFrameController;
	
	public CombatFrameController(CombatJFrame aFrame) {
		super();
		setFrame(aFrame);
	}
		
	public CombatFrameController(CombatListFrameController aListController) {
		super();
		_combatListFrameController = aListController;
	}
	
	/*
	 * Persist the current state of the encounter to the file system.
	 */
	void persistEncounter() {
		CombatEncounterWarehouse.getCurrent().updateCombatEncounter(_combatEncounter);
	}
	void setCombatEncounter(CombatEncounter anEncounter) {
		_combatEncounter = anEncounter;
		_displayedRound = null;
		_displayedRoundSortedStatistics = new ArrayList<CharacterCombatRoundStatistics>();
		_combatFrame.getDisplayedRoundJSpinner().setValue(Integer.valueOf(0));
		_openRound = null;
		
	}
	
	void setFrame(CombatJFrame aFrame) {
		_combatFrame = aFrame;
		aFrame.setLocation(160,160);
		_combatFrame.getCombatTableModel().setMyFrameController(this);
		_combatFrame.getCombatTable().putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		initializeTableColumnSizes(_combatFrame.getCombatTable());
		initalizeToolText(_combatFrame.getCombatTable());
	}

	private void initalizeToolText(JTable combatTable) {
		
		Enumeration<TableColumn> columnsEnumeration = combatTable.getColumnModel().getColumns();
		while (columnsEnumeration.hasMoreElements()) {
			TableColumn aColumn = columnsEnumeration.nextElement();
			if (aColumn.getModelIndex() == CombatTableDataModel.INITIATIVE_INDEX) {
				DefaultTableCellRenderer myRenderer = new DefaultTableCellRenderer();
				myRenderer.setToolTipText("Base initiative plus initiative modifier plus 100 sided open ended roll");
				aColumn.setCellRenderer(myRenderer);
			} 
			if (aColumn.getModelIndex() == CombatTableDataModel.ALERTNESS_INDEX) {
				DefaultTableCellRenderer myRenderer = new DefaultTableCellRenderer();
				myRenderer.setToolTipText("Base alertness plus 100 sided open ended roll");
				aColumn.setCellRenderer(myRenderer);
			} 
			if (aColumn.getModelIndex() == CombatTableDataModel.OBSERVATION_INDEX) {
				DefaultTableCellRenderer myRenderer = new DefaultTableCellRenderer();
				myRenderer.setToolTipText("Base observation plus 100 sided open ended roll");
				aColumn.setCellRenderer(myRenderer);
			} 
			if (aColumn.getModelIndex() == CombatTableDataModel.HITS_STARTING_INDEX) {
				DefaultTableCellRenderer myRenderer = new DefaultTableCellRenderer();
				myRenderer.setToolTipText("Number of hit points the character started this round with");
				aColumn.setCellRenderer(myRenderer);
			} 
			if (aColumn.getModelIndex() == CombatTableDataModel.HITS_TAKEN_THIS_ROUND) {
				DefaultTableCellRenderer myRenderer = new DefaultTableCellRenderer();
				myRenderer.setToolTipText("Number of hit points the character has taken this round");
				aColumn.setCellRenderer(myRenderer);
			} 
			if (aColumn.getModelIndex() == CombatTableDataModel.BLEEDING_INDEX) {
				DefaultTableCellRenderer myRenderer = new DefaultTableCellRenderer();
				myRenderer.setToolTipText("Number of hit points the character will lose this round due to bleeding");
				aColumn.setCellRenderer(myRenderer);
			} 
			if (aColumn.getModelIndex() == CombatTableDataModel.REGENERATION_INDEX) {
				DefaultTableCellRenderer myRenderer = new DefaultTableCellRenderer();
				myRenderer.setToolTipText("Number of hit points the character will gain this round due to regeneration");
				aColumn.setCellRenderer(myRenderer);
			} 
			if (aColumn.getModelIndex() == CombatTableDataModel.HITS_REMAINING_INDEX) {
				DefaultTableCellRenderer myRenderer = new DefaultTableCellRenderer();
				myRenderer.setToolTipText("Number of hit points the character has remaining after this round is over");
				aColumn.setCellRenderer(myRenderer);
			} 

		}
	}
	
	private void initializeTableColumnSizes(JTable combatTable) {
		
		Enumeration<TableColumn> columnsEnumeration = combatTable.getColumnModel().getColumns();
		while (columnsEnumeration.hasMoreElements()) {
			TableColumn aColumn = columnsEnumeration.nextElement();
			if (aColumn.getModelIndex() == CombatTableDataModel.ID_INDEX) {
				aColumn.setPreferredWidth(50);
			} else {
				aColumn.setPreferredWidth(100);
			}
		}
	}


	@Override
	public void makeFrameVisable() {
		refreshTableFromDomain();
		_combatFrame.pack();
		_combatFrame.setVisible(true);
	}
	
	Round getDisplayedRound() {
		return _displayedRound;
	}
	
	private void setDisplayedRound(Round newDisplayedRound) {

		_displayedRound = newDisplayedRound;
		
		_displayedRoundSortedStatistics.clear();
		_displayedRoundSortedStatistics.addAll(_displayedRound.getCharacterCombatRoundStatistics());
		Collections.sort(_displayedRoundSortedStatistics, _myStatisticsComparator);
	}
	
	private void refreshTableFromDomain() {
		
		_openRound = _combatEncounter.getOpenRound();
		// the table data model will use the round in _displayedRound
		if (_displayedRound == null) {
			setDisplayedRound(_openRound);
		}
		
		_combatFrame.getOpenRoundJLabel().setText(new Integer(_openRound.getRoundNumber()).toString());
		// assume that rounds are numbered sequentially and the open round has the highest number.
		SpinnerNumberModel spinnerModel = (SpinnerNumberModel)_combatFrame.getDisplayedRoundJSpinner().getModel();
		spinnerModel.setMaximum(_openRound.getRoundNumber());
		spinnerModel.setMinimum(1);
		spinnerModel.setStepSize(1);
		spinnerModel.setValue(getDisplayedRound().getRoundNumber());
		_combatFrame.getCombatTableModel().fireTableDataChanged();
	}

	void nextRoundJButtonClicked() {
		
		Round newRound = _combatEncounter.createNextRound();
		_openRound = newRound;
		setDisplayedRound(newRound);
		_combatFrame.getDisplayedRoundJSpinner().setValue(getDisplayedRound().getRoundNumber());
		refreshTableFromDomain();
	}
	
	void displayedRoundJSpinnerStateChanged() {
		int selectedRound = ((Integer)_combatFrame.getDisplayedRoundJSpinner().getValue()).intValue();
		if (selectedRound > 0) {
			setDisplayedRound(_combatEncounter.getRound(selectedRound));
		}
		refreshTableFromDomain();
	}
	
	List<CharacterCombatRoundStatistics>  getDisplayedRoundSortedStatistics() {
		return _displayedRoundSortedStatistics;
	}
	
	boolean isDisplayingOpenStatistic() {
		return getDisplayedRound().equals(_openRound);
	}
	
	void openCriticalHitsFrame() {
		if (_criticalHitFrameController == null) {
			CriticalHitFrameController aController = new CriticalHitFrameController(_combatEncounter);
			CriticalHitJFrame aFrame = new CriticalHitJFrame(aController);
			aFrame.setTitle("Realm - Critical Hits For Combat: " + _combatEncounter.getDescription());
			aController.setFrame(aFrame);
			_criticalHitFrameController = aController;			
		}
		_criticalHitFrameController.makeFrameVisable();
	}
}
