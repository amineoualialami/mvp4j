package org.mvp4j.impl.gen;

public class AppControllerGenFactory {
	
	private static AppControllerGen appControllerGen;
	
	public static AppControllerGen getAppControllerGen(){
		if(appControllerGen==null){
			return new AppControllerGen();
		}
		return appControllerGen;
	}
	

}
