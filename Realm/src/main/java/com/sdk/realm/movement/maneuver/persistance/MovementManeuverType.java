//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.14 at 11:17:57 PM CDT 
//


package com.sdk.realm.movement.maneuver.persistance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         		This is a definition of the severity of the maneuver.
 *         	
 * 
 * <p>Java class for MovementManeuverType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MovementManeuverType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RollValues" type="{http://com.sdk.realm/RealmMovementManeuverDefinitionV0.0.0.1}DiceRollRangeType"/>
 *         &lt;element name="TrivialManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RoutineManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EasyManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LightManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MediumManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HardManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VeryHardManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ExtremelyHardManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SheerFollyManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AbsurdManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InsaneManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PhenomenalManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VirtuallyImpossibleManeuverResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MovementManeuverType", propOrder = {
    "rollValues",
    "trivialManeuverResult",
    "routineManeuverResult",
    "easyManeuverResult",
    "lightManeuverResult",
    "mediumManeuverResult",
    "hardManeuverResult",
    "veryHardManeuverResult",
    "extremelyHardManeuverResult",
    "sheerFollyManeuverResult",
    "absurdManeuverResult",
    "insaneManeuverResult",
    "phenomenalManeuverResult",
    "virtuallyImpossibleManeuverResult"
})
public class MovementManeuverType {

    @XmlElement(name = "RollValues", required = true)
    protected DiceRollRangeType rollValues;
    @XmlElement(name = "TrivialManeuverResult", required = true)
    protected String trivialManeuverResult;
    @XmlElement(name = "RoutineManeuverResult", required = true)
    protected String routineManeuverResult;
    @XmlElement(name = "EasyManeuverResult", required = true)
    protected String easyManeuverResult;
    @XmlElement(name = "LightManeuverResult", required = true)
    protected String lightManeuverResult;
    @XmlElement(name = "MediumManeuverResult", required = true)
    protected String mediumManeuverResult;
    @XmlElement(name = "HardManeuverResult", required = true)
    protected String hardManeuverResult;
    @XmlElement(name = "VeryHardManeuverResult", required = true)
    protected String veryHardManeuverResult;
    @XmlElement(name = "ExtremelyHardManeuverResult", required = true)
    protected String extremelyHardManeuverResult;
    @XmlElement(name = "SheerFollyManeuverResult", required = true)
    protected String sheerFollyManeuverResult;
    @XmlElement(name = "AbsurdManeuverResult", required = true)
    protected String absurdManeuverResult;
    @XmlElement(name = "InsaneManeuverResult", required = true)
    protected String insaneManeuverResult;
    @XmlElement(name = "PhenomenalManeuverResult", required = true)
    protected String phenomenalManeuverResult;
    @XmlElement(name = "VirtuallyImpossibleManeuverResult", required = true)
    protected String virtuallyImpossibleManeuverResult;

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
     * Gets the value of the trivialManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrivialManeuverResult() {
        return trivialManeuverResult;
    }

    /**
     * Sets the value of the trivialManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrivialManeuverResult(String value) {
        this.trivialManeuverResult = value;
    }

    /**
     * Gets the value of the routineManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoutineManeuverResult() {
        return routineManeuverResult;
    }

    /**
     * Sets the value of the routineManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoutineManeuverResult(String value) {
        this.routineManeuverResult = value;
    }

    /**
     * Gets the value of the easyManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEasyManeuverResult() {
        return easyManeuverResult;
    }

    /**
     * Sets the value of the easyManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEasyManeuverResult(String value) {
        this.easyManeuverResult = value;
    }

    /**
     * Gets the value of the lightManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLightManeuverResult() {
        return lightManeuverResult;
    }

    /**
     * Sets the value of the lightManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLightManeuverResult(String value) {
        this.lightManeuverResult = value;
    }

    /**
     * Gets the value of the mediumManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMediumManeuverResult() {
        return mediumManeuverResult;
    }

    /**
     * Sets the value of the mediumManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMediumManeuverResult(String value) {
        this.mediumManeuverResult = value;
    }

    /**
     * Gets the value of the hardManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHardManeuverResult() {
        return hardManeuverResult;
    }

    /**
     * Sets the value of the hardManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHardManeuverResult(String value) {
        this.hardManeuverResult = value;
    }

    /**
     * Gets the value of the veryHardManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVeryHardManeuverResult() {
        return veryHardManeuverResult;
    }

    /**
     * Sets the value of the veryHardManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVeryHardManeuverResult(String value) {
        this.veryHardManeuverResult = value;
    }

    /**
     * Gets the value of the extremelyHardManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtremelyHardManeuverResult() {
        return extremelyHardManeuverResult;
    }

    /**
     * Sets the value of the extremelyHardManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtremelyHardManeuverResult(String value) {
        this.extremelyHardManeuverResult = value;
    }

    /**
     * Gets the value of the sheerFollyManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSheerFollyManeuverResult() {
        return sheerFollyManeuverResult;
    }

    /**
     * Sets the value of the sheerFollyManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSheerFollyManeuverResult(String value) {
        this.sheerFollyManeuverResult = value;
    }

    /**
     * Gets the value of the absurdManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbsurdManeuverResult() {
        return absurdManeuverResult;
    }

    /**
     * Sets the value of the absurdManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbsurdManeuverResult(String value) {
        this.absurdManeuverResult = value;
    }

    /**
     * Gets the value of the insaneManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsaneManeuverResult() {
        return insaneManeuverResult;
    }

    /**
     * Sets the value of the insaneManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsaneManeuverResult(String value) {
        this.insaneManeuverResult = value;
    }

    /**
     * Gets the value of the phenomenalManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhenomenalManeuverResult() {
        return phenomenalManeuverResult;
    }

    /**
     * Sets the value of the phenomenalManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhenomenalManeuverResult(String value) {
        this.phenomenalManeuverResult = value;
    }

    /**
     * Gets the value of the virtuallyImpossibleManeuverResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVirtuallyImpossibleManeuverResult() {
        return virtuallyImpossibleManeuverResult;
    }

    /**
     * Sets the value of the virtuallyImpossibleManeuverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVirtuallyImpossibleManeuverResult(String value) {
        this.virtuallyImpossibleManeuverResult = value;
    }

}
