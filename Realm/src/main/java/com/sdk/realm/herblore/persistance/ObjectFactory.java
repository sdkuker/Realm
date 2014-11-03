//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.07.16 at 04:34:17 PM CDT 
//


package com.sdk.realm.herblore.persistance;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sdk.realm.herblore.persistance package. 
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

    private final static QName _HerbLibrary_QNAME = new QName("http://com.sdk.realm/RealmHerbLoreDefinitionV0.0.0.1", "HerbLibrary");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sdk.realm.herblore.persistance
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HerbType }
     * 
     */
    public HerbType createHerbType() {
        return new HerbType();
    }

    /**
     * Create an instance of {@link HerbLibraryType }
     * 
     */
    public HerbLibraryType createHerbLibraryType() {
        return new HerbLibraryType();
    }

    /**
     * Create an instance of {@link HerbCollectionType }
     * 
     */
    public HerbCollectionType createHerbCollectionType() {
        return new HerbCollectionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HerbLibraryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.sdk.realm/RealmHerbLoreDefinitionV0.0.0.1", name = "HerbLibrary")
    public JAXBElement<HerbLibraryType> createHerbLibrary(HerbLibraryType value) {
        return new JAXBElement<HerbLibraryType>(_HerbLibrary_QNAME, HerbLibraryType.class, null, value);
    }

}