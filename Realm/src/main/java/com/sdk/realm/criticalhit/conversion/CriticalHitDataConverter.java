package com.sdk.realm.criticalhit.conversion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.sdk.realm.criticalhit.persistance.CriticalHitType;
import com.sdk.realm.criticalhit.persistance.CriticalHitsLibraryType;
import com.sdk.realm.criticalhit.persistance.DiceRollRangeType;
import com.sdk.realm.criticalhit.persistance.ObjectFactory;

/*
 * I convert the critical hit files from Bill into XML files.  Bill's files
 * are comma separated.  This program will create an XML file representing
 * the same data.  The new file will have the same name as the old file except
 * for an xml extension.
 */
public class CriticalHitDataConverter {

	private static final Logger _log = Logger.getLogger(CriticalHitDataConverter.class);
	private static final String ACID = "Acid";
	private static int MINIMUM_NUMBER_OF_TOKENS = 4;
	
	private int _numberOfInputRecordsRead = 0;
	private int _numberOfInputLinesWithErrors = 0;
	private int _numberOfInputCriticalHitsRead = 0;
	private int _numberOfOutputCriticalHitsWritten = 0;
	private String _inputFileName = null;
	private String _outputFileName = null;
	
	private ObjectFactory _objectFactory = null;
	private CriticalHitsLibraryType _criticalHitLibrary = null;
	private String _currentType = null;
	
	public CriticalHitDataConverter() {
		super();
		_objectFactory = new ObjectFactory();
		_criticalHitLibrary = _objectFactory.createCriticalHitsLibraryType();
		_criticalHitLibrary.setCriticalHitCollection(_objectFactory.createCriticalHitCollectionType());
	}

	/**
	 * The only argument is the name (including path) of the file
	 * to be converted.
	 */
	public static void main(String[] args) {
		
		if (args.length == 2) {
			CriticalHitDataConverter aConverter = new CriticalHitDataConverter();
			aConverter._currentType = args[0];
			aConverter.convertFile(args[1]);
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
		_log.info("number of input critical hits read: " + _numberOfInputCriticalHitsRead);
		_log.info("number of input flines with errors: " + _numberOfInputLinesWithErrors);
		_log.info("number of output critical hit written: " + _numberOfOutputCriticalHitsWritten);
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
				_numberOfInputCriticalHitsRead++;
				if (_currentType.equals(ACID)) {
					createAcidCriticalHitFromTokens(lineTokens);
				} else {
					createNonAcidCriticalHitFromTokens(lineTokens);
				}
			}
		} else {
			_log.error("this line contains some error: " + aLine);
			_numberOfInputLinesWithErrors++;
		}
	}
	
	private boolean isHeaderLine(String[] lineTokens) {
		
		boolean isHeader = false;
		boolean isAlternateHeader = false;
		if (! (lineTokens.length < MINIMUM_NUMBER_OF_TOKENS)) {
			isHeader = 	"critical description".equalsIgnoreCase(lineTokens[0]) &&
						"Severity".equalsIgnoreCase(lineTokens[1]) &&
						"min".equalsIgnoreCase(lineTokens[2]);
			
			isAlternateHeader = 	"Severity".equalsIgnoreCase(lineTokens[0]) &&
									"critical description".equalsIgnoreCase(lineTokens[1]) &&
									"min".equalsIgnoreCase(lineTokens[2]);

		}
		return isHeader || isAlternateHeader;
	}
	
	private boolean isHeaderLineOriginal(String[] lineTokens) {
		
		boolean isHeader = false;
		if (! (lineTokens.length < MINIMUM_NUMBER_OF_TOKENS)) {
			isHeader = 	"Type".equalsIgnoreCase(lineTokens[0]) &&
						"Severity".equalsIgnoreCase(lineTokens[1]) &&
						"min".equalsIgnoreCase(lineTokens[2]);
		}
		return isHeader;
	}

	
	private void createNonAcidCriticalHitFromTokens(String[] lineTokens) {
		
		// sometimes the description has commas in it so it is multiple tokens
		// the max is always the last token, min is 2nd to the last, severity is 3rd to
		// the last and all the others are the description.
		String maximum = lineTokens[lineTokens.length - 1];
		/*if (maximum.equals("66")) {
			System.out.println("here");
		}*/
		String minimum = lineTokens[lineTokens.length - 2];
		String severity = lineTokens[lineTokens.length - 3];
		StringBuffer description = new StringBuffer();
		for (int index = 0; index < lineTokens.length -3; index++ ){
			description.append(lineTokens[index]);
		}
		CriticalHitType aCriticalHit = _objectFactory.createCriticalHitType();
		aCriticalHit.setType(_currentType);
		aCriticalHit.setSeverity(sanitizeToken(severity));
		
		DiceRollRangeType aDiceRollRange = _objectFactory.createDiceRollRangeType();
		aDiceRollRange.setMinimum((new Integer(sanitizeToken(minimum))).intValue());
		aDiceRollRange.setMaximum((new Integer(sanitizeToken(maximum))).intValue());
		aCriticalHit.setRollValues(aDiceRollRange);
		
		aCriticalHit.setDescription(sanitizeToken(description.toString()));
		
		_criticalHitLibrary.getCriticalHitCollection().getCriticalHit().add(aCriticalHit);
		_numberOfOutputCriticalHitsWritten++;
	}
	
	private void createAcidCriticalHitFromTokens(String[] lineTokens) {
		
		// sometimes the description has commas in it so it is multiple tokens
		// the max is always the last token, min is 2nd to the last, severity is first
		// and all the others are the description.
		String maximum = lineTokens[lineTokens.length - 1];
		String minimum = lineTokens[lineTokens.length - 2];
		String severity = lineTokens[0];
		StringBuffer description = new StringBuffer();
		for (int index = 1; index < lineTokens.length - 2; index++ ){
			description.append(lineTokens[index]);
		}
		CriticalHitType aCriticalHit = _objectFactory.createCriticalHitType();
		aCriticalHit.setType(_currentType);
		aCriticalHit.setSeverity(sanitizeToken(severity));
		
		DiceRollRangeType aDiceRollRange = _objectFactory.createDiceRollRangeType();
		aDiceRollRange.setMinimum((new Integer(sanitizeToken(minimum))).intValue());
		aDiceRollRange.setMaximum((new Integer(sanitizeToken(maximum))).intValue());
		aCriticalHit.setRollValues(aDiceRollRange);
		
		aCriticalHit.setDescription(sanitizeToken(description.toString()));
		
		_criticalHitLibrary.getCriticalHitCollection().getCriticalHit().add(aCriticalHit);
		_numberOfOutputCriticalHitsWritten++;
	}
	

	private String sanitizeToken(String aToken) {
		// remove any tabs that are in the token
		char tab = '\t';
		String theReturn = aToken;
		if (aToken.indexOf(tab) > 0) {
			StringBuffer tempSubString = new StringBuffer();
			for (int index = 0; index < aToken.length(); index++) {
				if (aToken.charAt(index) != tab) {
					tempSubString.append(aToken.charAt(index));
				}
			}
			theReturn = tempSubString.toString();
		}
		
		return theReturn;
	}
	private void originalFormatCreateCriticalHitFromTokens(String[] lineTokens) {
		
		CriticalHitType aCriticalHit = _objectFactory.createCriticalHitType();
		aCriticalHit.setType(lineTokens[0]);
		aCriticalHit.setSeverity(lineTokens[1]);
		
		DiceRollRangeType aDiceRollRange = _objectFactory.createDiceRollRangeType();
		aDiceRollRange.setMinimum((new Integer(lineTokens[2])).intValue());
		aDiceRollRange.setMaximum((new Integer(lineTokens[3])).intValue());
		aCriticalHit.setRollValues(aDiceRollRange);
		
		// concatonate everything else into one string - it's the description
		StringBuffer aBuffer = new StringBuffer();
		for (int index = 4; index < lineTokens.length; index++) {
			aBuffer.append(lineTokens[index]);
		}
		aCriticalHit.setDescription(aBuffer.toString());
		
		_criticalHitLibrary.getCriticalHitCollection().getCriticalHit().add(aCriticalHit);
		_numberOfOutputCriticalHitsWritten++;
	}
	private void writeOutputFileFromJaxbObjects() throws JAXBException, FileNotFoundException {
		
		_outputFileName = _inputFileName.replace("txt", "xml");
		_outputFileName = _inputFileName.replace("csv", "xml");
		_log.info("starting to write the output file from the jaxb objects to file: " + _outputFileName);
		JAXBContext aContext = JAXBContext.newInstance("com.sdk.realm.criticalhit.persistance");
		Marshaller aMarshaller = aContext.createMarshaller();
		aMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
		
		aMarshaller.marshal(_criticalHitLibrary, new FileOutputStream(_outputFileName));
		
	}
}
