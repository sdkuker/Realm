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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MovementManeuverLibraryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MovementManeuverLibraryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MovementManeuverCollection" type="{http://com.sdk.realm/RealmMovementManeuverDefinitionV0.0.0.1}MovementManeuverCollectionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MovementManeuverLibraryType", propOrder = {
    "movementManeuverCollection"
})
@XmlRootElement(name = "MovementManeuverLibrary")
public class MovementManeuverLibrary {

    @XmlElement(name = "MovementManeuverCollection", required = true)
    protected MovementManeuverCollectionType movementManeuverCollection;

    /**
     * Gets the value of the movementManeuverCollection property.
     * 
     * @return
     *     possible object is
     *     {@link MovementManeuverCollectionType }
     *     
     */
    public MovementManeuverCollectionType getMovementManeuverCollection() {
        return movementManeuverCollection;
    }

    /**
     * Sets the value of the movementManeuverCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link MovementManeuverCollectionType }
     *     
     */
    public void setMovementManeuverCollection(MovementManeuverCollectionType value) {
        this.movementManeuverCollection = value;
    }

}
