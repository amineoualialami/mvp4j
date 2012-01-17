package org.mvp4j.impl.reflect;
/**
 * 
 * A class that creates AppControllerReflect's object whose scope is singleton.
 * 
 * @author MVP4J team
 *
 */
public class AppControllerReflectFactory {

	private static AppControllerReflect appControllerReflect;

	public static AppControllerReflect getAppControllerInstance() {
		if (appControllerReflect == null) {
			appControllerReflect = new AppControllerReflect();
		}
		return appControllerReflect;
	}
}
