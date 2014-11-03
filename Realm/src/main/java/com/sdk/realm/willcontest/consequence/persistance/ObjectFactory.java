//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.07 at 09:50:47 PM CDT 
//


package com.sdk.realm.willcontest.consequence.persistance;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sdk.realm.willcontest.consequence.persistance package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WillContestConsequenceLibrary_QNAME = new QName("http://com.sdk.realm/RealmWillContestConsequencesDefinitionV0.0.0.1", "WillContestConsequenceLibrary");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sdk.realm.willcontest.consequence.persistance
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WillContestConsequenceLibraryType }
     * 
     */
    public WillContestConsequenceLibraryType createWillContestConsequenceLibraryType() {
        return new WillContestConsequenceLibraryType();
    }

    /**
     * Create an instance of {@link WillContestConsequenceType }
     * 
     */
    public WillContestConsequenceType createWillContestConsequenceType() {
        return new WillContestConsequenceType();
    }

    /**
     * Create an instance of {@link WillContestConsequenceCollectionType }
     * 
     */
    public WillContestConsequenceCollectionType createWillContestConsequenceCollectionType() {
        return new WillContestConsequenceCollectionType();
    }

    /**
     * Create an instance of {@link DiceRollRangeType }
     * 
     */
    public DiceRollRangeType createDiceRollRangeType() {
        return new DiceRollRangeType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WillContestConsequenceLibraryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.sdk.realm/RealmWillContestConsequencesDefinitionV0.0.0.1", name = "WillContestConsequenceLibrary")
    public JAXBElement<WillContestConsequenceLibraryType> createWillContestConsequenceLibrary(WillContestConsequenceLibraryType value) {
        return new JAXBElement<WillContestConsequenceLibraryType>(_WillContestConsequenceLibrary_QNAME, WillContestConsequenceLibraryType.class, null, value);
    }

}
