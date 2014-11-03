package com.sdk.realm.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/*
 * Provide access to property values
 */
public class PropertyWarehouse {

	private static PropertyWarehouse CURRENT = null;
	private static final String PROPERTY_FILE_NAME2 = "/realm.properties";
	private static final Logger _log = Logger.getLogger(PropertyWarehouse.class);
	private Properties _myProperties = null;
	
	public static PropertyWarehouse getCurrent() {
		if (CURRENT == null ) {
			initializeCurrent();
		}
		return CURRENT;
	}
	
	private static synchronized void initializeCurrent(){
		
		if (CURRENT == null ) {
			PropertyWarehouse temp = new PropertyWarehouse();
			try {Properties tempProperties = new Properties();
			//tempProperties.load(new FileInputStream(PROPERTY_FILE_NAME));
			// the following to get it with the Maven folder structure
			tempProperties.load(temp.getClass().getResourceAsStream(PROPERTY_FILE_NAME2));
			temp._myProperties = tempProperties;
			_log.info("properties were properly initialized with: " + tempProperties.size() + " properties.");
			} catch (IOException e) {
				_log.error("unable to initialize properties", e);
			}
			CURRENT = temp;
		}
	}
	
	public String getProperty(String aPropertyKey) {
		if (_myProperties != null) {
			return _myProperties.getProperty(aPropertyKey, null);
		} else {
			return null;
		}
	}
}
