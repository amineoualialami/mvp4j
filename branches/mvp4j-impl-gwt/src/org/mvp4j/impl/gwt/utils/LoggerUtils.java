package org.mvp4j.impl.gwt.utils;

import org.apache.log4j.Logger;

public class LoggerUtils {

	private static Logger logger;

	public static Logger getLogger() {
		logger = Logger.getLogger("mvp4j.logger");
		return logger;
	}

}
