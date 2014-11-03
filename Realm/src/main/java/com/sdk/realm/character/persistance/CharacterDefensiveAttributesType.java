//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.12.27 at 06:29:55 PM CST 
//


package com.sdk.realm.character.persistance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CharacterDefensiveAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CharacterDefensiveAttributesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QuicknessBonus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RacialModifier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ArmorChoice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ArmorOnArmor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ShieldChoice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SkillChoice1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SkillChoice2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SpecialAbility" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MiscItemChoice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AdrenalineDefense" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CharacterDefensiveAttributesType", propOrder = {
    "quicknessBonus",
    "racialModifier",
    "armorChoice",
    "armorOnArmor",
    "shieldChoice",
    "skillChoice1",
    "skillChoice2",
    "specialAbility",
    "miscItemChoice",
    "adrenalineDefense"
})
public class CharacterDefensiveAttributesType {

    @XmlElement(name = "QuicknessBonus")
    protected int quicknessBonus;
    @XmlElement(name = "RacialModifier")
    protected int racialModifier;
    @XmlElement(name = "ArmorChoice")
    protected int armorChoice;
    @XmlElement(name = "ArmorOnArmor")
    protected int armorOnArmor;
    @XmlElement(name = "ShieldChoice")
    protected int shieldChoice;
    @XmlElement(name = "SkillChoice1")
    protected int skillChoice1;
    @XmlElement(name = "SkillChoice2")
    protected int skillChoice2;
    @XmlElement(name = "SpecialAbility")
    protected int specialAbility;
    @XmlElement(name = "MiscItemChoice")
    protected int miscItemChoice;
    @XmlElement(name = "AdrenalineDefense")
    protected int adrenalineDefense;

    /**
     * Gets the value of the quicknessBonus property.
     * 
     */
    public int getQuicknessBonus() {
        return quicknessBonus;
    }

    /**
     * Sets the value of the quicknessBonus property.
     * 
     */
    public void setQuicknessBonus(int value) {
        this.quicknessBonus = value;
    }

    /**
     * Gets the value of the racialModifier property.
     * 
     */
    public int getRacialModifier() {
        return racialModifier;
    }

    /**
     * Sets the value of the racialModifier property.
     * 
     */
    public void setRacialModifier(int value) {
        this.racialModifier = value;
    }

    /**
     * Gets the value of the armorChoice property.
     * 
     */
    public int getArmorChoice() {
        return armorChoice;
    }

    /**
     * Sets the value of the armorChoice property.
     * 
     */
    public void setArmorChoice(int value) {
        this.armorChoice = value;
    }

    /**
     * Gets the value of the armorOnArmor property.
     * 
     */
    public int getArmorOnArmor() {
        return armorOnArmor;
    }

    /**
     * Sets the value of the armorOnArmor property.
     * 
     */
    public void setArmorOnArmor(int value) {
        this.armorOnArmor = value;
    }

    /**
     * Gets the value of the shieldChoice property.
     * 
     */
    public int getShieldChoice() {
        return shieldChoice;
    }

    /**
     * Sets the value of the shieldChoice property.
     * 
     */
    public void setShieldChoice(int value) {
        this.shieldChoice = value;
    }

    /**
     * Gets the value of the skillChoice1 property.
     * 
     */
    public int getSkillChoice1() {
        return skillChoice1;
    }

    /**
     * Sets the value of the skillChoice1 property.
     * 
     */
    public void setSkillChoice1(int value) {
        this.skillChoice1 = value;
    }

    /**
     * Gets the value of the skillChoice2 property.
     * 
     */
    public int getSkillChoice2() {
        return skillChoice2;
    }

    /**
     * Sets the value of the skillChoice2 property.
     * 
     */
    public void setSkillChoice2(int value) {
        this.skillChoice2 = value;
    }

    /**
     * Gets the value of the specialAbility property.
     * 
     */
    public int getSpecialAbility() {
        return specialAbility;
    }

    /**
     * Sets the value of the specialAbility property.
     * 
     */
    public void setSpecialAbility(int value) {
        this.specialAbility = value;
    }

    /**
     * Gets the value of the miscItemChoice property.
     * 
     */
    public int getMiscItemChoice() {
        return miscItemChoice;
    }

    /**
     * Sets the value of the miscItemChoice property.
     * 
     */
    public void setMiscItemChoice(int value) {
        this.miscItemChoice = value;
    }

    /**
     * Gets the value of the adrenalineDefense property.
     * 
     */
    public int getAdrenalineDefense() {
        return adrenalineDefense;
    }

    /**
     * Sets the value of the adrenalineDefense property.
     * 
     */
    public void setAdrenalineDefense(int value) {
        this.adrenalineDefense = value;
    }

}