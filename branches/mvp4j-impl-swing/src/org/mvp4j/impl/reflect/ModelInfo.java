package org.mvp4j.impl.reflect;

import java.lang.reflect.Method;

import org.mvp4j.adapter.ModelComponent;

/**
 * Simple bean that contains detailed information about
 * where the data goes been stored and been initialized
 * 
 * @author MVP4J team
 *
 */
public class ModelInfo {

	private String propertyName;
	private String iniPropertyName;
	private Method method;
	private ModelComponent componentModel;

	/**
	 * 
	 * @return the property where the view input value goes be stored  
	 */
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
    
	/**
	 * 
	 * @return the property that will initialize a view component
	 */
	public String getIniPropertyName() {
		return iniPropertyName;
	}

	public void setIniPropertyName(String iniPropertyName) {
		this.iniPropertyName = iniPropertyName;
	}

	/**
	 * 
	 * @return the method annotated
	 */
	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	/**
	 * 
	 * @return a modelComponent established for the view component
	 */
	public ModelComponent getComponentModel() {
		return componentModel;
	}

	public void setComponentModel(ModelComponent componentModel) {
		this.componentModel = componentModel;
	}
	
	

}
