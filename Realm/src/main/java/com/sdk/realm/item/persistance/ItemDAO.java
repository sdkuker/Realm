package com.sdk.realm.item.persistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.sdk.realm.item.domain.Item;

public class ItemDAO {

	private static final Logger _log = Logger.getLogger(ItemDAO.class);
	
	private String fileLocation = "data//AllItems.xml";
	private List<Item> allItems = new ArrayList<Item>();

	public ItemDAO() {
		super();
	}

	/*
	 * read all the items from the data files, then return that list.
	 * the data file must be in the location specified by the 
	 * fileLocation field.
	 */
	public List<Item> getAllItems() {
		
		loadDataFromFile();
		return allItems;
	}
	
	private void loadDataFromFile() {
		
		File itemFile = new File(fileLocation);
		_log.debug("Loading item data from: " + itemFile.getAbsolutePath());
		loadFile(itemFile);
		_log.debug("Total of: " + allItems.size() + " items loaded.");
	}
	
	/*
	 * unmarshall the file, covert to domain objects and load into the internal collection
	 */
	private void loadFile(File aFile) {
		
		try {
			JAXBContext jc = JAXBContext.newInstance("com.sdk.realm.item.persistance");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			JAXBElement<ItemLibraryType>  aJAXBElement = (JAXBElement <ItemLibraryType>) unmarshaller.unmarshal(aFile);
			ItemLibraryType anItemLibraryType = (ItemLibraryType) aJAXBElement.getValue();
			convertToDomainObjectsAndStore(anItemLibraryType);
		} catch (Exception e) {
			_log.error("unable to unmarshall file named: "  + aFile.getName(), e);
		}
	}

	private void convertToDomainObjectsAndStore(ItemLibraryType anItemLibraryType) {
		
		for (ItemType anItemType: anItemLibraryType.getItemCollection().getItem()) {
			allItems.add(createItem(anItemType));
		}
	}
	
	private Item createItem(ItemType anItemType) {
		
		Item theReturn = new Item();
		
		theReturn.setId(new Integer(anItemType.getID()).intValue());
		theReturn.setName(anItemType.getName());
		theReturn.setWill(anItemType.getWill());
		theReturn.setWillModifier(anItemType.getWillModifier());
		
		return theReturn;
	}

	/*
	 * replace all the items I know about with the ones defined in listOfItems.  do this
	 * in my in-memory collection as well as on the file system.
	 */
	public boolean setAllItemsTo(List<Item> listOfItems) {
		
		ObjectFactory anObjectFactory = new ObjectFactory();
		ItemLibraryType anItemLibraryType = convertToJAXBObjects(listOfItems, anObjectFactory);
		JAXBElement<ItemLibraryType> jaxbElement = anObjectFactory.createItemLibrary(anItemLibraryType);
		boolean persistanceSucceeded = true;
		try {
			FileOutputStream anOutputStream = new FileOutputStream(fileLocation);
			_log.debug("Saving items to file system: " + listOfItems.size() + " items are being saved to file: " + fileLocation);
			JAXBContext jc = JAXBContext.newInstance("com.sdk.realm.item.persistance");
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
			marshaller.marshal(jaxbElement, anOutputStream);
			_log.debug("Saving items to the files system succeeded");
		} catch (JAXBException e) {
			_log.error("Unable to save the item data - JAXB Exception: ", e);
			persistanceSucceeded = false;
		} catch (FileNotFoundException e1) {
			_log.error("Unable to save the item data - File Not Found Exception: ", e1);
			persistanceSucceeded = false;
		}
		allItems = listOfItems;
		
		return persistanceSucceeded;
	}
	
	private ItemLibraryType convertToJAXBObjects(List<Item> aListOfItems, ObjectFactory anObjectFactory) {
		
		ItemLibraryType anItemLibraryType = anObjectFactory.createItemLibraryType();
		ItemCollectionType anItemCollectionType = anObjectFactory.createItemCollectionType();
		anItemLibraryType.setItemCollection(anItemCollectionType);
		
		for (Item anItem : aListOfItems) {
			ItemType  anItemType = anObjectFactory.createItemType();
			anItemType.setID(new Integer(anItem.getId()).toString());
			anItemType.setName(anItem.getName());
			anItemType.setWill(anItem.getWill());
			anItemType.setWillModifier(anItem.getWillModifier());
			anItemCollectionType.getItem().add(anItemType);
		}
		
		return anItemLibraryType;
	}

}
