package com.sdk.realm.combat.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sdk.realm.combat.domain.CharacterCombatRoundStatistics;
import com.sdk.realm.combat.domain.Round;

public class CombatTableDataModel extends AbstractTableModel {

	private static final long serialVersionUID = -8659825308215576186L;
	private static final String[] _columnNames = {"Id", "Name", "Initiative", "Alertness", "Observation", "Rnds Stunned", "Neg Modifier", "Hits Starting", "Hits Taken This Round", "Bleeding",  "Regeneration", "Hits Remaining"};
	private static final int MAXIMUM_NUMBER_OF_ROWS = 15;
	static final int ID_INDEX = 0;
	private static final int NAME_INDEX = 1;
	static final int INITIATIVE_INDEX = 2;
	static final int ALERTNESS_INDEX = 3;
	static final int OBSERVATION_INDEX = 4;
	private static final int ROUNDS_STILL_STUNNED = 5;
	private static final int NEGATIVE_MODIFIER_INDEX = 6;
	static final int HITS_STARTING_INDEX = 7;
	static final int HITS_TAKEN_THIS_ROUND = 8;
	static final int BLEEDING_INDEX = 9;
	static final int REGENERATION_INDEX = 10;
	static final int HITS_REMAINING_INDEX = 11;
	
	private CombatFrameController _myFrameController;

	public CombatTableDataModel() {
	}

	public String getColumnName(int anIndex) {
		return _columnNames[anIndex];
	}
	
	void setMyFrameController(CombatFrameController aController) {
		_myFrameController = aController;
	}
	
	Round getRound() {
		return _myFrameController.getDisplayedRound();
	}
	
	public int getColumnCount() {
		
		return _columnNames.length;
	}

	public int getRowCount() {
		int numberofStatistics = 0;
		if (_myFrameController != null) {
			numberofStatistics = _myFrameController.getDisplayedRoundSortedStatistics().size();
		}
		return Math.max(MAXIMUM_NUMBER_OF_ROWS, numberofStatistics);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Object theReturn = null;
		List<CharacterCombatRoundStatistics> characterStatistics = _myFrameController.getDisplayedRoundSortedStatistics();
		
		if (characterStatistics.size() > rowIndex) {
			CharacterCombatRoundStatistics aStatistic = characterStatistics.get(rowIndex);
			switch(columnIndex) {
			case ID_INDEX:
				theReturn = aStatistic.getCharacter().getId();
				break;
			case NAME_INDEX:
				theReturn = aStatistic.getCharacterName();
				break;
			case INITIATIVE_INDEX:
				theReturn = new Integer(aStatistic.getInitiative());
				break;
			case ALERTNESS_INDEX:
				theReturn = new Integer(aStatistic.getAlertness());
				break;
			case OBSERVATION_INDEX:
				theReturn = new Integer(aStatistic.getObservation());
				break;
			case HITS_STARTING_INDEX:
				theReturn = new Integer(aStatistic.getHitsAtStartOfRound());
				break;
			case HITS_TAKEN_THIS_ROUND:
				theReturn = new Integer(aStatistic.getHitsTakenDuringRound());
				break;
			case HITS_REMAINING_INDEX:
				theReturn = new Integer(aStatistic.getHitsAtEndOfRound());
				break;
			case BLEEDING_INDEX:
				theReturn = aStatistic.getBleeding();
				break;
			case ROUNDS_STILL_STUNNED:
				theReturn = aStatistic.getRoundsStillStunned();
				break;
			case NEGATIVE_MODIFIER_INDEX:
				theReturn = aStatistic.getNegativeModifier();
				break;
			case REGENERATION_INDEX:
				theReturn = aStatistic.getRegeneration();
				break;

			default:
				theReturn = "No Data for column index: " + columnIndex;
			}
		}
		
		return theReturn;
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		List<CharacterCombatRoundStatistics> characterStatistics = _myFrameController.getDisplayedRoundSortedStatistics();

		CharacterCombatRoundStatistics aStatistic = characterStatistics.get(rowIndex);
		if (columnIndex == HITS_TAKEN_THIS_ROUND ) {
			String stringValue = (String) aValue;
			int intValue = new Integer(stringValue).intValue();
			aStatistic.setHitsTakenDuringRound(intValue);
			fireTableCellUpdated(rowIndex, HITS_REMAINING_INDEX);
		} 
		if (columnIndex == BLEEDING_INDEX ) {
			String stringValue = (String) aValue;
			int intValue = new Integer(stringValue).intValue();
			aStatistic.setBleeding(intValue);
			fireTableCellUpdated(rowIndex, HITS_REMAINING_INDEX);
		} 
		if (columnIndex == ROUNDS_STILL_STUNNED ) {
			String stringValue = (String) aValue;
			int intValue = new Integer(stringValue).intValue();
			aStatistic.setRoundsStillStunned(intValue);
		} 
		if (columnIndex == NEGATIVE_MODIFIER_INDEX ) {
			String stringValue = (String) aValue;
			int intValue = new Integer(stringValue).intValue();
			aStatistic.setNegativeModifier(intValue);
		} 
		if (columnIndex == REGENERATION_INDEX ) {
			String stringValue = (String) aValue;
			int intValue = new Integer(stringValue).intValue();
			aStatistic.setRegeneration(intValue);
			fireTableCellUpdated(rowIndex, HITS_REMAINING_INDEX);
		} 

		persistChanges();
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	private void persistChanges() {
		_myFrameController.persistEncounter();
	}
	
	public boolean isCellEditable(int row, int column) {
		
		boolean theReturn = false;
		
		if (_myFrameController.isDisplayingOpenStatistic()) {
			if (HITS_TAKEN_THIS_ROUND == column || BLEEDING_INDEX == column || ROUNDS_STILL_STUNNED == column || NEGATIVE_MODIFIER_INDEX == column ||
					REGENERATION_INDEX == column) {
				theReturn = true;
			}
		}
		return theReturn;
	}
}
