package org.mvp4j.impl.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.mvp4j.Converter;
import org.mvp4j.adapter.MVPAdapter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.exception.PropertyNotFoundException;
import org.mvp4j.exception.PropertyNotInitializedException;
import org.mvp4j.impl.swing.utils.LoggerUtils;

public class ModelBindingImpl implements ModelBinding {

	private ModelInfo modelInfo;
	private Object model;
	private Object view;
	private Converter converter;
	private Logger logger = LoggerUtils.getLogger();

	public ModelBindingImpl(Object view, Object model, ModelInfo modelInfo) {

		this.model = model;
		this.view = view;
		this.modelInfo = modelInfo;

	}

	@Override
	public Object getComponent() {
		Object object = null;
		try {
			object = modelInfo.getMethod().invoke(view);
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
		return object;
	}

	@Override
	public String getPropertyName() {
		return modelInfo.getPropertyName();
	}

	@Override
	public String getInitPropertyName() {
		return modelInfo.getIniPropertyName();
	}

	@Override
	public void setPropertyValue(Object value) {
		try {
			Class modelClass = model.getClass();
			Field field = modelClass.getDeclaredField(getPropertyName());
			field.setAccessible(true);
			field.set(model, getConverter().convertComponentToModel(field.getType(), value));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			logger.fatal("Field "+getPropertyName()+" not found ");
			throw new PropertyNotFoundException(getPropertyName(), model.getClass());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Object getPropertyValue() {
		try {
			Class modelClass = model.getClass();
			Field field = modelClass.getDeclaredField(getPropertyName());
			field.setAccessible(true);
			Object object = field.get(model);
			
			return object;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			logger.fatal("Field "+getPropertyName()+" not found ");
			throw new PropertyNotFoundException(getPropertyName(), model.getClass());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object getInitPropertyValue() {
		   Object fakeObject = new Object();
           Object object=fakeObject;
		try {
			Class modelClass = model.getClass();
			Method[] methods=modelClass.getDeclaredMethods();
			for (Method method : methods) {
				if(method.getName().equalsIgnoreCase("get"+getInitPropertyName())){
				
					object=method.invoke(model);
				}
			}
			if (object==fakeObject){
				throw new PropertyNotFoundException(getInitPropertyName(), model);
			}
			if(object==null ){
				throw new PropertyNotInitializedException(getInitPropertyName());
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	private Converter getConverter() {
		if(modelInfo.getComponentModel().getConverter()==null){
			AppControllerReflect appController = AppControllerReflectFactory
			.getAppControllerInstance();
			converter = appController.getCurrentAdapter().getConverter();	
		}
		else{
			converter=modelInfo.getComponentModel().getConverter();
		}
		return converter;
	}

	

	
	
	
	
	
    
}
