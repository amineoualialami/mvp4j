package org.mvp4j.impl.reflect;

import java.util.List;
import java.util.Map;

import org.mvp4j.Converter;
import org.mvp4j.adapter.MVPBinding;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.impl.gwt.DefaultConverter;

import com.gwtent.reflection.client.ClassType;
import com.gwtent.reflection.client.Constructor;
import com.gwtent.reflection.client.TypeOracle;

public class MVPBindingImpl implements MVPBinding {

	private Object model;
	private Object presenter;
	private Object view;

	public static final Converter DEFAULT_CONVERTER = new DefaultConverter();
	private Converter globalConverter = DEFAULT_CONVERTER;

	@Override
	public Converter getGlobalConverter() {
		return globalConverter;
	}

	@Override
	public void setGlobalConverter(Converter converter) {
		this.globalConverter = converter;
	}

	@Override
	public void setComponentModel(Object component,
			Class<? extends ModelComponent> customizedModelComponent) {
		AppControllerReflect appController = AppControllerReflectFactory
				.getAppControllerInstance();
		Map<String, ModelViewInfo> modelViewInfoMap = appController
				.getModelViewInfoMap();
		ModelViewInfo modelViewInfo = modelViewInfoMap.get(getView().getClass()
				.toString());
		List<ModelInfo> listModelInfo = modelViewInfo.getModelsInfo();
		for (ModelInfo modelInfo : listModelInfo) {
			
				if (modelInfo.getMethod().invoke(getView()) == component) {
					
					ClassType<? extends ModelComponent> componentModelClass = TypeOracle.Instance.getClassType(customizedModelComponent);
//					Constructor<? extends ModelComponent> constructor = componentModelClass
//							.getConstructor(ModelBinding.class);
					Constructor<? extends ModelComponent> constructor = componentModelClass.findConstructor(ModelBinding.class.toString());
//					ModelComponent componentModel = (ModelComponent) constructor
//							.newInstance(new ModelBindingImpl(getView(), getModel(),
//									modelInfo));
					ModelComponent componentModel = (ModelComponent) constructor.newInstance();
					modelInfo.setComponentModel(componentModel);
					appController.refreshView(getView());
				}
			
		}

	}

	@Override
	public ModelComponent getComponentModel(Object component) {
		AppControllerReflect appController = AppControllerReflectFactory
				.getAppControllerInstance();
		Map<String, ModelViewInfo> modelViewInfoMap = appController
				.getModelViewInfoMap();
		ModelViewInfo modelViewInfo = modelViewInfoMap.get(getView().getClass()
				.toString());
		List<ModelInfo> listModelInfo = modelViewInfo.getModelsInfo();
		for (ModelInfo modelInfo : listModelInfo) {
			
				if (modelInfo.getMethod().invoke(getView()) == component) {
					return modelInfo.getComponentModel();
				}
			
		}
		return null;
	}

	@Override
	public Object getPresenter() {
		return presenter;
	}

	@Override
	public Object getModel() {
		return model;
	}

	@Override
	public Object getView() {
		return view;
	}

	@Override
	public void setPresenter(Object presenter) {
		this.presenter = presenter;

	}

	@Override
	public void setModel(Object model) {
		this.model = model;
	}

	@Override
	public void setView(Object view) {
		this.view = view;
	}

}
