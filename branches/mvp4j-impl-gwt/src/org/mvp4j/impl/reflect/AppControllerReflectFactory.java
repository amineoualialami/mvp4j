package org.mvp4j.impl.reflect;



public class AppControllerReflectFactory {
	private static AppControllerReflect appControllerReflect;

	public static AppControllerReflect getAppControllerReflect() {
		if (appControllerReflect == null) {
			return new AppControllerReflect();
		}
		return appControllerReflect;
	}

}
