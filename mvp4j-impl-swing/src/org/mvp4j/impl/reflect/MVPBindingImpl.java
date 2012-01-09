package org.mvp4j.impl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.mvp4j.Converter;
import org.mvp4j.adapter.MVPBinding;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.impl.swing.DefaultConverter;

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
			try {
				if (modelInfo.getMethod().invoke(getView()) == component) {
					Class<? extends ModelComponent> componentModelClass = customizedModelComponent;
					Constructor<? extends ModelComponent> constructor = componentModelClass
							.getConstructor();
					ModelComponent componentModel = (ModelComponent) constructor.newInstance();
					componentModel.init(new ModelBindingImpl(getView(), getModel(),
							modelInfo,this));
					modelInfo.setComponentModel(componentModel);
					appController.refreshView(getView());
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			try {
				if (modelInfo.getMethod().invoke(getView()) == component) {
					return modelInfo.getComponentModel();
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
