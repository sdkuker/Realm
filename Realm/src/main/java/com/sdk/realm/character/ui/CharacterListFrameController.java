package com.sdk.realm.character.ui;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.sdk.realm.character.domain.CharacterWarehouse;
import com.sdk.realm.character.domain.GameCharacter;
import com.sdk.realm.ui.Controller;

public class CharacterListFrameController extends Controller {

	private CharacterListJFrame _characterListFrame = null;
	
	private CharacterFrameController _characterFrameController = null;
	private CharacterDefensiveAttributesListFrameController _characterDefensiveAttributesListFrameController;
	
	public CharacterListFrameController(CharacterListJFrame aFrame) {
		super();
		_characterListFrame = aFrame;
		aFrame.setLocation(120,120);
		_characterListFrame.getCharacterListJTable().putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		initializeTableColumnSizes(aFrame.getCharacterListJTable());
	}
	
	private void initializeTableColumnSizes(JTable characterListTable) {
		
		Enumeration<TableColumn> columnsEnumeration = characterListTable.getColumnModel().getColumns();
		while (columnsEnumeration.hasMoreElements()) {
			TableColumn aColumn = columnsEnumeration.nextElement();
			if (aColumn.getModelIndex() == CharacterListTableDataModel.ID_INDEX) {
				aColumn.setPreferredWidth(50);
			} else {
				aColumn.setPreferredWidth(100);
			}
		}
	}

	@Override
	public void makeFrameVisable() {
		refreshTableFromDomain();
		_characterListFrame.pack();
		_characterListFrame.setVisible(true);
	}

	void refreshTableFromDomain() {
		
		List<GameCharacter> characters = new ArrayList<GameCharacter>();
		characters.addAll((CharacterWarehouse.getCurrent().getAllCharacters()));
		_characterListFrame.getTableDataModel().setCharacters(characters);
		_characterListFrame.getCharacterListJTable().repaint();
	}

	void addCharacterJButtonClicked() {
		
		GameCharacter newCharacter = CharacterWarehouse.getCurrent().createAndAddNewCharacter();
		getCharacterFrameController().setCharacterID(newCharacter.getId());
		getCharacterFrameController().makeFrameVisable();
		
	}
	
	void characterDomainWasModified() {
		refreshTableFromDomain();
	}
	
	void viewAndEditCharacterDetailsJButtonClicked() {
		
		if (_characterListFrame.getCharacterListJTable().getSelectedRowCount() != 1) {
			JOptionPane.showMessageDialog(_characterListFrame, "Must select one character to view/edit");
		} else {
			int selectedCharacterRow = _characterListFrame.getCharacterListJTable().getSelectedRow();
			GameCharacter selectedCharacter = _characterListFrame.getTableDataModel().getCharacters().get(selectedCharacterRow); 
			getCharacterFrameController().setCharacterID(selectedCharacter.getId());
			getCharacterFrameController().makeFrameVisable();
		}
	}
	
	void viewAndEditCharacterDefensiveBonusAttributesJButtonClicked() {
		
		getCharacterDefensiveAttributesListFrameController().refreshTableFromDomain();
		getCharacterDefensiveAttributesListFrameController().makeFrameVisable();
	}

	
	void deleteCharacterJButtonClicked() {
		
		if (_characterListFrame.getCharacterListJTable().getSelectedRowCount() < 1) {
			JOptionPane.showMessageDialog(_characterListFrame, "Must select at least one character to delete");
		} else {
			int[] selectedCharacterRows = _characterListFrame.getCharacterListJTable().getSelectedRows();
			for (int index = 0; index < selectedCharacterRows.length; index++) {
				GameCharacter selectedCharacter = _characterListFrame.getTableDataModel().getCharacters().get(selectedCharacterRows[index]);
				CharacterWarehouse.getCurrent().deleteCharacter(selectedCharacter);
			}
			CharacterWarehouse.getCurrent().persistAll();
			refreshTableFromDomain();
		}
	}

	void deleteAllCharactersJButtonClicked() {
		
		CharacterWarehouse.getCurrent().deleteAllCharacters();
		CharacterWarehouse.getCurrent().persistAll();
		refreshTableFromDomain();
	}
	
	private CharacterFrameController getCharacterFrameController() {
		
		if (_characterFrameController == null) {
			CharacterFrameController aController = new CharacterFrameController(this);
			CharacterJFrame aFrame = new CharacterJFrame(aController);
			aFrame.setTitle("Realm - Character");
			aController.setFrame(aFrame);
			_characterFrameController = aController;
		}
		
		return _characterFrameController;
	}
	
	private CharacterDefensiveAttributesListFrameController getCharacterDefensiveAttributesListFrameController() {
		
		if (_characterDefensiveAttributesListFrameController == null) {
			CharacterDefensiveAttributesListFrameController aController = new CharacterDefensiveAttributesListFrameController(this);
			CharacterDefensiveAttributesListJFrame aFrame = new CharacterDefensiveAttributesListJFrame();
			aFrame.setController(aController);
			aFrame.setTitle("Realm - Character Defensive Attributes List");
			aController.setFrame(aFrame);
			_characterDefensiveAttributesListFrameController = aController;
		}
		
		return _characterDefensiveAttributesListFrameController;
	}

}
