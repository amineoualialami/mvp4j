package org.mvp4j.impl.reflect;

import java.lang.reflect.Method;

import org.mvp4j.adapter.ModelComponent;

public class ModelInfo {

	private String propertyName;
	private String iniPropertyName;
	private Method method;
	private ModelComponent componentModel;

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getIniPropertyName() {
		return iniPropertyName;
	}

	public void setIniPropertyName(String iniPropertyName) {
		this.iniPropertyName = iniPropertyName;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public ModelComponent getComponentModel() {
		return componentModel;
	}

	public void setComponentModel(ModelComponent componentModel) {
		this.componentModel = componentModel;
	}
	
	

}
