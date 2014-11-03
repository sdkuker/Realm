//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.03.25 at 01:26:22 PM CDT 
//


package com.sdk.realm.criticalhit.persistance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *         		This is a definition of the severity of the hit. The
 *         		severity increases as the letters progress in the
 *         		alphabet.
 *         	
 * 
 * <p>Java class for CriticalHitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CriticalHitType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *               &lt;enumeration value="Cold"/>
 *               &lt;enumeration value="Puncture"/>
 *               &lt;enumeration value="Slash"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Severity">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="B"/>
 *               &lt;enumeration value="C"/>
 *               &lt;enumeration value="D"/>
 *               &lt;enumeration value="E"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RollValues" type="{http://com.sdk.realm/RealmCriticalHitsDefinitionV0.0.0.1}DiceRollRangeType"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CriticalHitType", propOrder = {
    "type",
    "severity",
    "rollValues",
    "description"
})
public class CriticalHitType {

    @XmlElement(name = "Type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlElement(name = "Severity", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String severity;
    @XmlElement(name = "RollValues", required = true)
    protected DiceRollRangeType rollValues;
    @XmlElement(name = "Description", required = true)
    protected String description;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the severity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * Sets the value of the severity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeverity(String value) {
        this.severity = value;
    }

    /**
     * Gets the value of the rollValues property.
     * 
     * @return
     *     possible object is
     *     {@link DiceRollRangeType }
     *     
     */
    public DiceRollRangeType getRollValues() {
        return rollValues;
    }

    /**
     * Sets the value of the rollValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiceRollRangeType }
     *     
     */
    public void setRollValues(DiceRollRangeType value) {
        this.rollValues = value;
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

}
