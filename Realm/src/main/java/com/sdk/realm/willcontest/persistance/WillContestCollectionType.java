//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.05 at 09:33:40 PM CDT 
//


package com.sdk.realm.willcontest.persistance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WillContestCollectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WillContestCollectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WillContest" type="{http://com.sdk.realm/RealmWillContestConsequencesDefinitionV0.0.0.1}WillContestType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WillContestCollectionType", propOrder = {
    "willContest"
})
public class WillContestCollectionType {

    @XmlElement(name = "WillContest")
    protected List<WillContestType> willContest;

    /**
     * Gets the value of the willContest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the willContest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWillContest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WillContestType }
     * 
     * 
     */
    public List<WillContestType> getWillContest() {
        if (willContest == null) {
            willContest = new ArrayList<WillContestType>();
        }
        return this.willContest;
    }

}
