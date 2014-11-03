package com.sdk.realm.character.ui;

import javax.swing.JFormattedTextField;

import com.sdk.realm.character.domain.CharacterWarehouse;
import com.sdk.realm.character.domain.DefensiveAttributes;
import com.sdk.realm.character.domain.GameCharacter;
import com.sdk.realm.ui.Controller;

public class CharacterDefensiveAttributesFrameController extends Controller {

	private CharacterDefensiveAttributesJFrame _defensiveAttributesFrame;
	private int _characterID;
	private GameCharacter _currentCharacter;
	private CharacterDefensiveAttributesListFrameController _defensiveAttributesListFrameController;
	
	public CharacterDefensiveAttributesFrameController(CharacterDefensiveAttributesListFrameController aController) {
		super();
		_defensiveAttributesListFrameController = aController;
	}

	public void setFrame(CharacterDefensiveAttributesJFrame aFrame) {
		_defensiveAttributesFrame = aFrame;
		aFrame.setLocation(300,200);
	}
	
	@Override
	public void makeFrameVisable() {
		refreshFromDomain();
		_defensiveAttributesFrame.pack();
		_defensiveAttributesFrame.setVisible(true);
	}

	private void refreshFromDomain() {
		GameCharacter  myCharacter = CharacterWarehouse.getCurrent().getCharacter(_characterID);
		if (myCharacter != null) {
			_currentCharacter = myCharacter;
			refreshDomainFields();
		}
	}
		
	void saveJButtonClicked() {
		
		DefensiveAttributes myDefensiveAttributes = _currentCharacter.getDefensiveAttributes();
		myDefensiveAttributes.setAdrenalineDefense(((Number) _defensiveAttributesFrame.getAdrenalDefenseTextField().getValue()).intValue());
		myDefensiveAttributes.setArmorChoice(((Number) _defensiveAttributesFrame.getArmorChoiceTextField().getValue()).intValue());
		myDefensiveAttributes.setArmorOnArmor(((Number) _defensiveAttributesFrame.getArmorOnArmorTextField().getValue()).intValue());
		myDefensiveAttributes.setMiscItemChoice(((Number) _defensiveAttributesFrame.getMiscItemChoiceTextField().getValue()).intValue());
		myDefensiveAttributes.setQuicknessBonus(((Number) _defensiveAttributesFrame.getQuicknessBonusTextField().getValue()).intValue());
		myDefensiveAttributes.setRacialModifier(((Number) _defensiveAttributesFrame.getRacialModifierTextField().getValue()).intValue());
		myDefensiveAttributes.setShieldChoice(((Number) _defensiveAttributesFrame.getShieldChoiceTextField().getValue()).intValue());
		myDefensiveAttributes.setSkillChoice1(((Number) _defensiveAttributesFrame.getSkillChoice1TextField().getValue()).intValue());
		myDefensiveAttributes.setSkillChoice2(((Number) _defensiveAttributesFrame.getSkillChoice2TextField().getValue()).intValue());
		myDefensiveAttributes.setSpecialAbility(((Number) _defensiveAttributesFrame.getSpecialAbilityTextField().getValue()).intValue());
		CharacterWarehouse.getCurrent().persistAll();
		_defensiveAttributesListFrameController.characterDomainWasModified();
		_defensiveAttributesFrame.setVisible(false);
		
	}
	
	void attributeTextFieldChanged() {
		
		int currentTotal = getValue(_defensiveAttributesFrame.getAdrenalDefenseTextField())
					+ getValue(_defensiveAttributesFrame.getArmorChoiceTextField())
					+ getValue(_defensiveAttributesFrame.getArmorOnArmorTextField())
					+ getValue(_defensiveAttributesFrame.getMiscItemChoiceTextField())
					+ getValue(_defensiveAttributesFrame.getQuicknessBonusTextField())
					+ getValue(_defensiveAttributesFrame.getRacialModifierTextField())
					+ getValue(_defensiveAttributesFrame.getShieldChoiceTextField())
					+ getValue(_defensiveAttributesFrame.getSkillChoice1TextField())
					+ getValue(_defensiveAttributesFrame.getSkillChoice2TextField())
					+ getValue(_defensiveAttributesFrame.getSpecialAbilityTextField());
		
		_defensiveAttributesFrame.getTotalTextField().setValue(currentTotal);
	}
	
	int getValue(JFormattedTextField aTextField) {
		
		int theReturn = 0;
		
		Integer integerValue = (Integer)aTextField.getValue();
		if (integerValue != null) {
			theReturn = Integer.valueOf(integerValue);
		}
		
		return theReturn;
	}
	
	void cancelJButtonClicked() {

		refreshFromDomain();
	}
	
	private void refreshDomainFields() {
		
		DefensiveAttributes myDefensiveAttributes = _currentCharacter.getDefensiveAttributes();
		_defensiveAttributesFrame.getCharacterNameTextField().setText(_currentCharacter.getName());
		_defensiveAttributesFrame.getAdrenalDefenseTextField().setValue(myDefensiveAttributes.getAdrenalineDefense());
		_defensiveAttributesFrame.getArmorChoiceTextField().setValue(myDefensiveAttributes.getArmorChoice());
		_defensiveAttributesFrame.getArmorOnArmorTextField().setValue(myDefensiveAttributes.getArmorOnArmor());
		_defensiveAttributesFrame.getMiscItemChoiceTextField().setValue(myDefensiveAttributes.getMiscItemChoice());
		_defensiveAttributesFrame.getQuicknessBonusTextField().setValue(myDefensiveAttributes.getQuicknessBonus());
		_defensiveAttributesFrame.getRacialModifierTextField().setValue(myDefensiveAttributes.getRacialModifier());
		_defensiveAttributesFrame.getShieldChoiceTextField().setValue(myDefensiveAttributes.getShieldChoice());
		_defensiveAttributesFrame.getSkillChoice1TextField().setValue(myDefensiveAttributes.getSkillChoice1());
		_defensiveAttributesFrame.getSkillChoice2TextField().setValue(myDefensiveAttributes.getSkillChoice2());
		_defensiveAttributesFrame.getSpecialAbilityTextField().setValue(myDefensiveAttributes.getSpecialAbility());
		_defensiveAttributesFrame.getTotalTextField().setValue(myDefensiveAttributes.totalDefensiveBonus());
	}
	
	public int getCharacterID() {
		return _characterID;
	}
	
	public void setCharacterID(int anID) {
		_characterID = anID;
	}
}
