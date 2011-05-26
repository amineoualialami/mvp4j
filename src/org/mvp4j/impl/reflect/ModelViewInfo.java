package org.mvp4j.impl.reflect;

import java.util.List;

public class ModelViewInfo {
	private Class<?> viewClass;
	private Class<?> modelClass;
	private List<ModelInfo> modelsInfo;

	public Class<?> getViewClass() {
		return viewClass;
	}

	public void setViewClass(Class<?> viewClass) {
		this.viewClass = viewClass;
	}

	public Class<?> getModelClass() {
		return modelClass;
	}

	public void setModelClass(Class<?> modelClass) {
		this.modelClass = modelClass;
	}

	public List<ModelInfo> getModelsInfo() {
		return modelsInfo;
	}

	public void setModelsInfo(List<ModelInfo> modelsInfo) {
		this.modelsInfo = modelsInfo;
	}

}
