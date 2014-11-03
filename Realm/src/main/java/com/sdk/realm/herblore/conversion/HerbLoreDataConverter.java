package com.sdk.realm.herblore.conversion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.sdk.realm.herblore.persistance.HerbLibraryType;
import com.sdk.realm.herblore.persistance.HerbType;
import com.sdk.realm.herblore.persistance.ObjectFactory;


/*
 * I convert the herb lore files from Bill into XML files.  Bill's files
 * are comma separated.  This program will create an XML file representing
 * the same data.  The new file will have the same name as the old file except
 * for an xml extension.
 */
public class HerbLoreDataConverter {

	private static final Logger _log = Logger.getLogger(HerbLoreDataConverter.class);
	private static final int MINIMUM_NUMBER_OF_TOKENS = 5;
	private static final String ATTACK_LEVEL_PREFIX = "Lvl";
	
	private int _numberOfInputRecordsRead = 0;
	private int _numberOfInputLinesWithErrors = 0;
	private int _numberOfInputHerbsRead = 0;
	private int _numberOfOutputHerbsWritten = 0;
	private String _inputFileName = null;
	private String _outputFileName = null;
	
	private ObjectFactory _objectFactory = null;
	private HerbLibraryType _herbLibrary = null;
	private String _currentType = null;
	
	public HerbLoreDataConverter() {
		super();
		_objectFactory = new ObjectFactory();
		_herbLibrary = _objectFactory.createHerbLibraryType();
		_herbLibrary.setHerbCollection(_objectFactory.createHerbCollectionType());
	}

	/**
	 * The only argument is the name (including path) of the file
	 * to be converted.
	 */
	public static void main(String[] args) {
		
		if (args.length == 1) {
			HerbLoreDataConverter aConverter = new HerbLoreDataConverter();
			aConverter.convertFile(args[0]);
		} else {
			_log.error("invalid number of arguments - must have only the complete file name of the file to be converted");
		}

	}

	private void convertFile(String aFileName) {
		
		try {
			createJaxbObjectsFromInputFile(aFileName);
			writeOutputFileFromJaxbObjects();
			logStatistics();
		} catch (FileNotFoundException e) {
			_log.error(aFileName + " could not be found", e);
		} catch (JAXBException e1) {
			_log.error("the following JAXB exception was thrown writig the file", e1);
		}
	}
	
	private void logStatistics() {
		_log.info("input file name:" + _inputFileName);
		_log.info("number of input records read: " + _numberOfInputRecordsRead);
		_log.info("number of input herbs read: " + _numberOfInputHerbsRead);
		_log.info("number of input lines with errors: " + _numberOfInputLinesWithErrors);
		_log.info("number of output herbs written: " + _numberOfOutputHerbsWritten);
		_log.info("output file name:" + _outputFileName);
	}
	private void createJaxbObjectsFromInputFile(String aFileName) throws FileNotFoundException {
		
		_log.info("starting to create jaxb objects from input file: " + aFileName);
		_inputFileName = aFileName;
		Scanner aScanner = new Scanner(new File(aFileName));
		aScanner.useDelimiter("\r\n|[\r\n\u2028\u2029\u0085]");
		while (aScanner.hasNext()) {
			processFileLine(aScanner.next());
		}
		aScanner.close();

	}
	private void processFileLine(String aLine) {
		
		_numberOfInputRecordsRead++;
		
		String[] lineTokens = aLine.split(",");
		if (! (lineTokens.length < MINIMUM_NUMBER_OF_TOKENS)) {
			if (! isHeaderLine(lineTokens)) {
				_numberOfInputHerbsRead++;
				createHerbFromTokens(lineTokens);
			}
		} else {
			_log.error("this line contains some error: " + aLine);
			_numberOfInputLinesWithErrors++;
		}
	}
	
	private boolean isHeaderLine(String[] lineTokens) {
		
		// there is no header in this file
		return false;
	}
	
	private void createHerbFromTokens(String[] lineTokens) {
		
		HerbType aHerb = _objectFactory.createHerbType();
		aHerb.setClazz(sanitizeToken(lineTokens[0]));		
		aHerb.setName(sanitizeToken(lineTokens[1]));
		/*if (aHerb.getName().equals("Trudurs")) {
			char it = lineTokens[2].charAt(3);
			System.out.println("is whitespace: " + Character.isWhitespace(it));
			System.out.println("numeric value : " + Character.getNumericValue(it));
			System.out.println("type : " + Character.getType(it));
		}*/
		aHerb.setEffect(sanitizeToken(lineTokens[2]));
		Integer attackLevel = extractAttackLevel(lineTokens[3]);
		if (attackLevel != null) {
			aHerb.setAttackLevel(attackLevel);
		} 
		aHerb.setForm(sanitizeToken(lineTokens[4]));
		aHerb.setCostAndRarity(sanitizeToken(lineTokens[5]));
		
		_herbLibrary.getHerbCollection().getHerb().add(aHerb);
		_numberOfOutputHerbsWritten++;
	}
	
	// anAttackLevelString will be in the form "Lvl n" where n is the attack level
	// return null if the input string is not in this form.  This can happen if no
	// attack level was specified.
	private Integer extractAttackLevel(String anAttackLevelString) {
		
		Integer attackLevel = null;
		if (anAttackLevelString.contains(ATTACK_LEVEL_PREFIX)) {
			String levelAsString = anAttackLevelString.substring((anAttackLevelString.indexOf(ATTACK_LEVEL_PREFIX) + ATTACK_LEVEL_PREFIX.length()));
			attackLevel = new Integer(sanitizeToken(levelAsString.trim()).trim());
		}
		
		return attackLevel;		
	}
	
	private String sanitizeToken(String aToken) {
		// Character.getType = 15 is that goofy thang that looks like an equals sign
		char tab = '\t';
		char quote = '\"';
		String theReturn = null;

		StringBuffer tempSubString = new StringBuffer();
		for (int index = 0; index < aToken.length(); index++) {
			if (aToken.charAt(index) != tab && (aToken.charAt(index) != quote)) {
				if (Character.isDefined(aToken.charAt(index)) && (Character.getType(aToken.charAt(index)) != 15)) {
					tempSubString.append(aToken.charAt(index));
				}
			}
		}
		
		theReturn = tempSubString.toString();
		
		return theReturn;
	}

	private void writeOutputFileFromJaxbObjects() throws JAXBException, FileNotFoundException {
		
		_outputFileName = _inputFileName.replace("csv", "xml");
		_log.info("starting to write the output file from the jaxb objects to file: " + _outputFileName);
		JAXBContext aContext = JAXBContext.newInstance("com.sdk.realm.herblore.persistance");
		Marshaller aMarshaller = aContext.createMarshaller();
		aMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
		
		aMarshaller.marshal(_herbLibrary, new FileOutputStream(_outputFileName));
		
	}
}
