package com.sdk.realm.character.ui;

import java.util.Iterator;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import com.sdk.realm.character.domain.CharacterWarehouse;
import com.sdk.realm.character.domain.GameCharacter;
import com.sdk.realm.player.domain.Player;
import com.sdk.realm.player.domain.PlayerWarehouse;
import com.sdk.realm.ui.Controller;

public class CharacterFrameController extends Controller {

	private CharacterJFrame _characterFrame = null;
	private int _characterID;
	private DefaultComboBoxModel _playerComboBoxModel = null;
	private GameCharacter _currentCharacter = null;
	private CharacterListFrameController _characterListFrameController;
	
	public CharacterFrameController(CharacterListFrameController aCharacterListframeController) {
		super();
		_playerComboBoxModel = new DefaultComboBoxModel();
		_characterListFrameController = aCharacterListframeController;
	}

	public void setFrame(CharacterJFrame aFrame) {
		_characterFrame = aFrame;
		aFrame.setLocation(280,180);
	}
	
	@Override
	public void makeFrameVisable() {
		refreshFromDomain();
		_characterFrame.pack();
		_characterFrame.setVisible(true);
	}

	private void refreshFromDomain() {
		GameCharacter  myCharacter = CharacterWarehouse.getCurrent().getCharacter(_characterID);
		if (myCharacter != null) {
			_currentCharacter = myCharacter;
			_playerComboBoxModel.setSelectedItem(null);
			refreshDomainFields();
		}
	}
	
	ComboBoxModel getPlayerComboBoxModel() {
		return _playerComboBoxModel;
	}
	
	private void refreshPlayerComboBox() {
		Object currentlySelectedItem = _playerComboBoxModel.getSelectedItem();
		_playerComboBoxModel.removeAllElements();
		Iterator<Player> playersIterator = PlayerWarehouse.getCurrent().getAllPlayers().iterator();
		while (playersIterator.hasNext()) {
			_playerComboBoxModel.addElement(playersIterator.next().getName());
		}
		if (currentlySelectedItem != null) {
			_playerComboBoxModel.setSelectedItem(currentlySelectedItem);
		} else {
			if (_currentCharacter != null && _currentCharacter.getPlayer() != null ) {
				_playerComboBoxModel.setSelectedItem(_currentCharacter.getPlayer().getName());
			}
		}

	}
	
	void saveJButtonClicked() {
		if (_currentCharacter != null && _currentCharacter.getId() == 0) {
			_currentCharacter.setId(CharacterWarehouse.getCurrent().getNextAvailableCharacterID());
		}
		_currentCharacter.setName(_characterFrame.getNameJTextField().getText());
		_currentCharacter.setName(_characterFrame.getNameJTextField().getText());
		_currentCharacter.setLevel(((Number) _characterFrame.getLevelFormattedTextField().getValue()).intValue());
		_currentCharacter.setArmorType(((Number) _characterFrame.getArmorTypeFormattedTextField().getValue()).intValue());
		_currentCharacter.setHasShield(_characterFrame.getHasShieldJCheckBox().isSelected());
		_currentCharacter.setHasAdrenalDefense(_characterFrame.getHasAdrenalDefenseJCheckBox().isSelected());
		_currentCharacter.setStalkSkill(((Number) _characterFrame.getStalkSkillFormattedTextField().getValue()).intValue());
		_currentCharacter.setObservationSkill(((Number) _characterFrame.getObservationSkillFormattedTextField().getValue()).intValue());
		_currentCharacter.setSenseAmbushSkill(((Number) _characterFrame.getSenseAmbushSkillFormattedTextField().getValue()).intValue());
		_currentCharacter.setAlertnessSkill(((Number) _characterFrame.getAlertnessSkillFormattedTextField().getValue()).intValue());
		_currentCharacter.setPerception(((Number) _characterFrame.getPerceptionFormattedTextField().getValue()).intValue());
		_currentCharacter.setInitiative(((Number) _characterFrame.getInitiativeFormattedTextField().getValue()).intValue());
		_currentCharacter.setInitiativeModifier(((Number) _characterFrame.getInitiativeModifierFormattedTextField().getValue()).intValue());
		_currentCharacter.setHitPoints(((Number) _characterFrame.getHitPointsFormattedTextField().getValue()).intValue());
		_currentCharacter.setHitPointsModifier(((Number) _characterFrame.getHitPointsModifierFormattedTextField().getValue()).intValue());
		_currentCharacter.setWill(((Number) _characterFrame.getWillFormattedTextField().getValue()).intValue());
		_currentCharacter.setWillModifier(((Number) _characterFrame.getWillModifierFormattedTextField().getValue()).intValue());
		Player myPlayer = PlayerWarehouse.getCurrent().getPlayerNamed((String) _characterFrame.getPlayerComboJBox().getSelectedItem());
		_currentCharacter.setPlayer(myPlayer);
		// this particular character instance is already known to the warehouse.  Just tell the warehouse to
		// persist everything.
		CharacterWarehouse.getCurrent().persistAll();
		_characterListFrameController.characterDomainWasModified();
		_characterFrame.setVisible(false);
		
	}
	
	void cancelJButtonClicked() {

		refreshFromDomain();
	}
	
	private void refreshDomainFields() {
		refreshPlayerComboBox();
		_characterFrame.getNameJTextField().setText(_currentCharacter.getName());
		_characterFrame.getObservationSkillFormattedTextField().setValue(_currentCharacter.getObservationSkill());
		_characterFrame.getLevelFormattedTextField().setValue(_currentCharacter.getLevel());
		_characterFrame.getArmorTypeFormattedTextField().setValue(_currentCharacter.getArmorType());
		_characterFrame.getHasShieldJCheckBox().setSelected(_currentCharacter.isHasShield());
		_characterFrame.getHasAdrenalDefenseJCheckBox().setSelected(_currentCharacter.isHasAdrenalDefense());
		_characterFrame.getStalkSkillFormattedTextField().setValue(_currentCharacter.getStalkSkill());
		_characterFrame.getObservationSkillFormattedTextField().setValue(_currentCharacter.getObservationSkill());
		_characterFrame.getSenseAmbushSkillFormattedTextField().setValue(_currentCharacter.getSenseAmbushSkill());
		_characterFrame.getAlertnessSkillFormattedTextField().setValue(_currentCharacter.getAlertnessSkill());
		_characterFrame.getPerceptionFormattedTextField().setValue(_currentCharacter.getPerception());
		_characterFrame.getInitiativeFormattedTextField().setValue(_currentCharacter.getInitiative());
		_characterFrame.getInitiativeModifierFormattedTextField().setValue(_currentCharacter.getInitiativeModifier());
		_characterFrame.getHitPointsFormattedTextField().setValue(_currentCharacter.getHitPoints());
		_characterFrame.getHitPointsModifierFormattedTextField().setValue(_currentCharacter.getHitPointsModifier());
		_characterFrame.getWillFormattedTextField().setValue(_currentCharacter.getWill());
		_characterFrame.getWillModifierFormattedTextField().setValue(_currentCharacter.getWillModifier());

	}
	
	public int getCharacterID() {
		return _characterID;
	}
	
	public void setCharacterID(int anID) {
		_characterID = anID;
	}
}
