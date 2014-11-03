package com.sdk.realm.character.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sdk.realm.character.domain.GameCharacter;

public class CharacterListTableDataModel extends AbstractTableModel {

	private static final long serialVersionUID = -8659825308215576186L;
	// note:  changed the column name for 'perception' to 'misc' in release 0.3
	private static final String[] _columnNames = {"Id", "Player", "Character", "Level", "Misc", "Initiative", "Initiative Modifier", "Will", "Will Modifier", "Observation", "Stalk", "Alert", "Sense Ambush", "Armor Type", "Has Adrenal Defense", "Defense Minus Adrenal", "Total Defense", "Has Shield",  "Hit Points", "Hit Point Modifier"};
	private static final int MAXIMUM_NUMBER_OF_ROWS = 16;
	static final int ID_INDEX = 0;
	private static final int PLAYER_NAME_INDEX = 1;
	private static final int CHARACTER_NAME_INDEX = 2;
	private static final int LEVEL_INDEX = 3;
	private static final int PERCEPTION_INDEX = 4;
	private static final int INITIATIVE_INDEX = 5;
	private static final int INITIATIVE_MODIFIER_INDEX = 6;
	private static final int WILL_INDEX = 7;
	private static final int WILL_MODIFIER_INDEX = 8;
	private static final int OBSERVATION_INDEX = 9;
	private static final int STALK_INDEX = 10;
	private static final int ALERT_INDEX = 11;
	private static final int SENSE_AMBUSH_INDEX = 12;
	private static final int ARMOR_TYPE_INDEX = 13;
	private static final int HAS_ADRENAL_DEFENSE_INDEX = 14;
	private static final int DEFENSIVE_BONUS_MINUS_ADRENAL_DEFENSE_INDEX = 15;
	private static final int DEFENSIVE_BONUS_INDEX = 16;
	private static final int HAS_SHIELD_INDEX = 17;
	private static final int HIT_POINT_INDEX = 18;
	private static final int HIT_POINT_MODIFIER_INDEX = 19;
	
	private List<GameCharacter> _characters = new ArrayList<GameCharacter> ();
	private CharacterListFrameController _myFrameController;

	public CharacterListTableDataModel() {
	}

	public String getColumnName(int anIndex) {
		return _columnNames[anIndex];
	}
	
	void setMyFrameController(CharacterListFrameController aController) {
		_myFrameController = aController;
	}
	public int getColumnCount() {
		
		return _columnNames.length;
	}

	public int getRowCount() {
		
		return Math.max(MAXIMUM_NUMBER_OF_ROWS, _characters.size());
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Object theReturn= null;
		
		if (_characters.size() > rowIndex) {
			GameCharacter aCharacter = _characters.get(rowIndex);
			switch(columnIndex) {
			case ID_INDEX:
				theReturn = aCharacter.getId();
				break;
			case PLAYER_NAME_INDEX:
				theReturn = aCharacter.getPlayer().getName();
				break;
			case CHARACTER_NAME_INDEX:
				theReturn = aCharacter.getName();
				break;
			case LEVEL_INDEX:
				theReturn = aCharacter.getLevel();
				break;
			case PERCEPTION_INDEX:
				theReturn = aCharacter.getPerception();
				break;
			case INITIATIVE_INDEX:
				theReturn = aCharacter.getInitiative();
				break;
			case INITIATIVE_MODIFIER_INDEX:
				theReturn = aCharacter.getInitiativeModifier();
				break;
			case WILL_INDEX:
				theReturn = aCharacter.getWill();
				break;
			case WILL_MODIFIER_INDEX:
				theReturn = aCharacter.getWillModifier();
				break;
			case OBSERVATION_INDEX:
				theReturn = aCharacter.getObservationSkill();
				break;
			case STALK_INDEX:
				theReturn = aCharacter.getStalkSkill();
				break;
			case ALERT_INDEX:
				theReturn = aCharacter.getAlertnessSkill();
				break;
			case SENSE_AMBUSH_INDEX:
				theReturn = aCharacter.getSenseAmbushSkill();
				break;
			case ARMOR_TYPE_INDEX:
				theReturn = aCharacter.getArmorType();
				break;
			case DEFENSIVE_BONUS_MINUS_ADRENAL_DEFENSE_INDEX:
				theReturn = aCharacter.getDefensiveBonusMinusAdrenalDefense();
				break;
			case DEFENSIVE_BONUS_INDEX:
				theReturn = aCharacter.getDefensiveBonus();
				break;
			case HAS_SHIELD_INDEX:
				if (aCharacter.isHasShield()) {
					theReturn = "yes";
				} else {
					theReturn = "no";
				}
				break;
			case HAS_ADRENAL_DEFENSE_INDEX:
				if (aCharacter.isHasAdrenalDefense()) {
					theReturn = "yes";
				} else {
					theReturn = "no";
				}
				break;
			case HIT_POINT_INDEX:
				theReturn = aCharacter.getHitPoints();
				break;
			case HIT_POINT_MODIFIER_INDEX:
				theReturn = aCharacter.getHitPointsModifier();
				break;
			default:
				theReturn = "No Data for column index: " + columnIndex;
			}
		}
		
		return theReturn;
	}

	void setCharacters(List<GameCharacter> listOfCharacters) {
	
		_characters = listOfCharacters;
		fireTableDataChanged();
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		// you are not allowing them to update data here so just
		// skip this section.
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	List<GameCharacter> getCharacters() {
		return _characters;
	}
}
