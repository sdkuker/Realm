//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.05 at 09:33:40 PM CDT 
//


package com.sdk.realm.willcontest.persistance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WillContestLibraryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WillContestLibraryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WillContestCollection" type="{http://com.sdk.realm/RealmWillContestConsequencesDefinitionV0.0.0.1}WillContestCollectionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WillContestLibraryType", propOrder = {
    "willContestCollection"
})
public class WillContestLibraryType {

    @XmlElement(name = "WillContestCollection", required = true)
    protected WillContestCollectionType willContestCollection;

    /**
     * Gets the value of the willContestCollection property.
     * 
     * @return
     *     possible object is
     *     {@link WillContestCollectionType }
     *     
     */
    public WillContestCollectionType getWillContestCollection() {
        return willContestCollection;
    }

    /**
     * Sets the value of the willContestCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link WillContestCollectionType }
     *     
     */
    public void setWillContestCollection(WillContestCollectionType value) {
        this.willContestCollection = value;
    }

}
