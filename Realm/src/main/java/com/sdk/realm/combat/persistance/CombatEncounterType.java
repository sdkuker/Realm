//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.31 at 09:58:31 PM CDT 
//


package com.sdk.realm.combat.persistance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         		This is a player in the game. Note that this is not a
 *         		characcter that the player is running, it is the human
 *         		player.
 *         	
 * 
 * <p>Java class for CombatEncounterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CombatEncounterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastModified" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Rounds" type="{http://com.sdk.realm/CombatEncounter.V0.0.0.1}RoundCollectionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CombatEncounterType", propOrder = {
    "id",
    "description",
    "lastModified",
    "rounds"
})
public class CombatEncounterType {

    @XmlElement(name = "ID", namespace = "http://com.sdk.realm/CombatEncounter.V0.0.0.1", required = true)
    protected String id;
    @XmlElement(name = "Description", namespace = "http://com.sdk.realm/CombatEncounter.V0.0.0.1")
    protected String description;
    @XmlElement(name = "LastModified", namespace = "http://com.sdk.realm/CombatEncounter.V0.0.0.1")
    protected long lastModified;
    @XmlElement(name = "Rounds", namespace = "http://com.sdk.realm/CombatEncounter.V0.0.0.1", required = true)
    protected RoundCollectionType rounds;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the lastModified property.
     * 
     */
    public long getLastModified() {
        return lastModified;
    }

    /**
     * Sets the value of the lastModified property.
     * 
     */
    public void setLastModified(long value) {
        this.lastModified = value;
    }

    /**
     * Gets the value of the rounds property.
     * 
     * @return
     *     possible object is
     *     {@link RoundCollectionType }
     *     
     */
    public RoundCollectionType getRounds() {
        return rounds;
    }

    /**
     * Sets the value of the rounds property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoundCollectionType }
     *     
     */
    public void setRounds(RoundCollectionType value) {
        this.rounds = value;
    }

}
