package org.mvp4j.impl.reflect;


import org.apache.log4j.Logger;
import org.mvp4j.Converter;
import org.mvp4j.adapter.MVPAdapter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.exception.PropertyNotFoundException;
import org.mvp4j.exception.PropertyNotInitializedException;
import org.mvp4j.impl.gwt.utils.LoggerUtils;

import com.gwtent.reflection.client.ClassType;
import com.gwtent.reflection.client.Field;
import com.gwtent.reflection.client.Method;
import com.gwtent.reflection.client.TypeOracle;

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
			ClassType modelClass = TypeOracle.Instance.getClassType(model.getClass());
			Field field = modelClass.getField(getPropertyName());
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
			ClassType modelClass = TypeOracle.Instance.getClassType(model.getClass());
			Field field = modelClass.getField(getPropertyName());
			Object object = field.getFieldValue(model);
			if(object!=null){
			return getConverter().convertModelToComponent(object);
			}
		
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
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
			ClassType modelClass = TypeOracle.Instance.getClassType(model.getClass());
			Method[] methods=modelClass.getMethods();
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
		} 
		return object;
	}

	private Converter getConverter() {
		if(modelInfo.getComponentModel().getConverter()==null){
			AppControllerReflect appController = AppControllerReflectFactory
			.getAppControllerInstance();
			converter = appController.getMvpBinding().getGlobalConverter();
		}
		else{
			converter=modelInfo.getComponentModel().getConverter();
		}
		return converter;
	}

	

	
	
	
	
	
    
}
