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

public class CharacterDefensiveAttributesListFrameController extends Controller {

	private CharacterDefensiveAttributesListJFrame _characterDefensiveAttributesListFrame;
	private CharacterListFrameController _characterListFrameController;
	private CharacterDefensiveAttributesFrameController _characterDefensiveAttributesFrameController;
	
	//private CharacterDefensiveAttributesFrameController _characterFrameController = null;
	
	public CharacterDefensiveAttributesListFrameController(CharacterListFrameController aCharacterListFrameController) {
		super();
		_characterListFrameController = aCharacterListFrameController;
	}
	
	void setFrame(CharacterDefensiveAttributesListJFrame aFrame) {
		
		_characterDefensiveAttributesListFrame = aFrame;
		aFrame.setLocation(140,140);
		_characterDefensiveAttributesListFrame.getCharacterDefensiveAttributesListJTable().putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		initializeTableColumnSizes(aFrame.getCharacterDefensiveAttributesListJTable());

	}
	
	private void initializeTableColumnSizes(JTable characterDefensiveAttributesListTable) {
		
		Enumeration<TableColumn> columnsEnumeration = characterDefensiveAttributesListTable.getColumnModel().getColumns();
		while (columnsEnumeration.hasMoreElements()) {
			TableColumn aColumn = columnsEnumeration.nextElement();
			if (aColumn.getModelIndex() == CharacterListTableDataModel.ID_INDEX) {
				aColumn.setPreferredWidth(25);
			} else {
				aColumn.setPreferredWidth(100);
			}
		}
	}

	@Override
	public void makeFrameVisable() {
		refreshTableFromDomain();
		_characterDefensiveAttributesListFrame.pack();
		_characterDefensiveAttributesListFrame.setVisible(true);
	}

	void refreshTableFromDomain() {
		
		List<GameCharacter> characters = new ArrayList<GameCharacter>();
		characters.addAll((CharacterWarehouse.getCurrent().getAllCharacters()));
		_characterDefensiveAttributesListFrame.getTableDataModel().setCharacters(characters);
		_characterDefensiveAttributesListFrame.getCharacterDefensiveAttributesListJTable().repaint();
	}
	
	void characterDomainWasModified() {
		refreshTableFromDomain();
		_characterListFrameController.characterDomainWasModified();
	}
	
	void viewAndEditCharacterDefensiveAttributesDetailsJButtonClicked() {
		
		if (_characterDefensiveAttributesListFrame.getCharacterDefensiveAttributesListJTable().getSelectedRowCount() != 1) {
			JOptionPane.showMessageDialog(_characterDefensiveAttributesListFrame, "Must select one character to view/edit");
		} else {
			int selectedCharacterRow = _characterDefensiveAttributesListFrame.getCharacterDefensiveAttributesListJTable().getSelectedRow();
			GameCharacter selectedCharacter = _characterDefensiveAttributesListFrame.getTableDataModel().getCharacters().get(selectedCharacterRow); 
			getCharacterDefensiveAttributesFrameController().setCharacterID(selectedCharacter.getId());
			getCharacterDefensiveAttributesFrameController().makeFrameVisable();
		}
	}
	
	private CharacterDefensiveAttributesFrameController getCharacterDefensiveAttributesFrameController() {
		
		if (_characterDefensiveAttributesFrameController == null) {
			CharacterDefensiveAttributesFrameController aController = new CharacterDefensiveAttributesFrameController(this);
			CharacterDefensiveAttributesJFrame aFrame = new CharacterDefensiveAttributesJFrame(aController);
			aFrame.setTitle("Realm - Character Defensive Attributes");
			aController.setFrame(aFrame);
			_characterDefensiveAttributesFrameController = aController;
		}
		
		return _characterDefensiveAttributesFrameController; 
	}
	

}
