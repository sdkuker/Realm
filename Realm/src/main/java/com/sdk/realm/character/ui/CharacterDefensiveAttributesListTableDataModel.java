package com.sdk.realm.character.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sdk.realm.character.domain.DefensiveAttributes;
import com.sdk.realm.character.domain.GameCharacter;

public class CharacterDefensiveAttributesListTableDataModel extends AbstractTableModel {

	private static final long serialVersionUID = 3659298985701410562L;
	private static final String[] _columnNames = {"Id", "Name", "Quickness Bonus", "Racial Modifier", "Armor Choice", "Armor on Armor", "Shield Choice", "Skill Choice 1", "Skill Choice 2", "Special Ability", "Misc Item Choice", "Total Minus Adrenal", "Adrenal Defense", "Total"};
	private static final int MAXIMUM_NUMBER_OF_ROWS = 16;
	static final int ID_INDEX = 0;
	private static final int CHARACTER_NAME_INDEX = 1;
	private static final int QUICKNESS_BONUS_INDEX = 2;
	private static final int RACIAL_MODIFIER_INDEX = 3;
	private static final int ARMOR_CHOICE_INDEX = 4;
	private static final int ARMOR_ON_ARMOR_INDEX = 5;
	private static final int SHIELD_CHOICE_INDEX = 6;
	private static final int SKILL_CHOICE_1_INDEX = 7;
	private static final int SKILL_CHOICE_2_INDEX = 8;
	private static final int SPECIAL_ABILITY_INDEX = 9;
	private static final int MISC_ITEM_CHOICE_INDEX = 10;
	private static final int TOTAL_DEFENSE_MINUS_ADRENAL_DEFENSE_INDEX = 11;
	private static final int ADRENAL_DEFENSE_INDEX = 12;
	private static final int TOTAL_DEFENSE_INDEX = 13;
	
	private List<GameCharacter> _characters = new ArrayList<GameCharacter> ();
	private CharacterDefensiveAttributesListFrameController _myFrameController;

	public CharacterDefensiveAttributesListTableDataModel() {
	}

	public String getColumnName(int anIndex) {
		return _columnNames[anIndex];
	}
	
	void setMyFrameController(CharacterDefensiveAttributesListFrameController aController) {
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
			DefensiveAttributes aDefensiveAttributes = aCharacter.getDefensiveAttributes();
			
			switch(columnIndex) {
			case ID_INDEX:
				theReturn = aCharacter.getId();
				break;
			case CHARACTER_NAME_INDEX:
				theReturn = aCharacter.getName();
				break;
			case QUICKNESS_BONUS_INDEX:
				theReturn = aDefensiveAttributes.getQuicknessBonus();
				break;
			case RACIAL_MODIFIER_INDEX:
				theReturn = aDefensiveAttributes.getRacialModifier();
				break;
			case ARMOR_CHOICE_INDEX:
				theReturn = aDefensiveAttributes.getArmorChoice();
				break;
			case ARMOR_ON_ARMOR_INDEX:
				theReturn = aDefensiveAttributes.getArmorOnArmor();
				break;
			case SHIELD_CHOICE_INDEX:
				theReturn = aDefensiveAttributes.getShieldChoice();
				break;
			case SKILL_CHOICE_1_INDEX:
				theReturn = aDefensiveAttributes.getSkillChoice1();
				break;
			case SKILL_CHOICE_2_INDEX:
				theReturn = aDefensiveAttributes.getSkillChoice2();
				break;
			case SPECIAL_ABILITY_INDEX:
				theReturn = aDefensiveAttributes.getSpecialAbility();
				break;
			case MISC_ITEM_CHOICE_INDEX:
				theReturn = aDefensiveAttributes.getMiscItemChoice();
				break;
			case TOTAL_DEFENSE_MINUS_ADRENAL_DEFENSE_INDEX:
				theReturn = aDefensiveAttributes.totalDefensiveBonusMinusAdrenalDefense();
				break;
			case ADRENAL_DEFENSE_INDEX:
				theReturn = aDefensiveAttributes.getAdrenalineDefense();
				break;
			case TOTAL_DEFENSE_INDEX:
				theReturn = aDefensiveAttributes.totalDefensiveBonus();
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
