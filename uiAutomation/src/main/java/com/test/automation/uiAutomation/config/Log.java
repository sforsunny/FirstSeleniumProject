package com.test.automation.uiAutomation.config;

import org.apache.log4j.Logger;

public class Log {
	
	public static Logger log = Logger.getLogger(Log.class.getName());

	public static void startTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName
				+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
	}

	// This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName) {
		log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" +sTestCaseName
				+ "             XXXXXXXXXXXXXXXXXXXXXX");
	}

	// Need to create these methods, so that they can be called
	public static void info(String message) {
		log.info(message);
	}

	public static void warn(String message) {
		log.warn(message);
	}

	public static void error(String message) {
		log.error(message);
	}

	public static void fatal(String message) {
		log.fatal(message);
	}

	public static void debug(String message) {
		log.debug(message);
	}

}
