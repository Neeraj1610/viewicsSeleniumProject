package com.myproject.tutorial.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Log4j class.
 * 
 * @author nadhikari
 *
 */
public class Log4jLogger {

	//Initialize log4j logs
	private static Logger Log=Logger.getLogger(Log4jLogger.class.getName());


	public static void configureLogger(String log4jConfigFile)
	{
		DOMConfigurator.configure(log4jConfigFile);
	}


	public static void info(String message)
	{
		Log.info(message);

	}

	public static void warn(String message) {

		Log.warn(message);
	}


	public static void error(String message) {

		Log.error(message);
	}

	public static void debug(String message) {

		Log.debug(message);
	}
}
