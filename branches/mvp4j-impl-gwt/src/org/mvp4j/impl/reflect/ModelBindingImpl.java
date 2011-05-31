package org.mvp4j.impl.reflect;



import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.exception.PropertyNotFoundException;
import org.mvp4j.exception.PropertyNotInitializedException;

import com.google.gwt.core.client.GWT;
import com.gwtent.reflection.client.ClassType;
import com.gwtent.reflection.client.Field;
import com.gwtent.reflection.client.Method;
import com.gwtent.reflection.client.Type;
import com.gwtent.reflection.client.TypeOracle;


public class ModelBindingImpl implements ModelBinding {

	private ModelInfo modelInfo;
	private Object model;
	private Object view;
	private Converter converter;

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
		
			ClassType modelClassType = TypeOracle.Instance.getClassType(model.getClass());
			Field field = modelClassType.getField(getPropertyName());
//			Type type =  field.getType();
			field.setFieldValue(model, getConverter().convertComponentToModel(field.getType(),value));
	}

	@Override
	public Object getPropertyValue() {
			ClassType modelClass = TypeOracle.Instance.getClassType(model.getClass());
			Field field = modelClass.getField(getPropertyName());
			Object object = field.getFieldValue(model);
			if(object!=null){
			return getConverter().convertModelToComponent(object);
			}
		
		return null;
	}

	@Override
	public Object getInitPropertyValue() {
		   Object fakeObject = new Object();
           Object object=fakeObject;
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
		return object;
	}

	private Converter getConverter() {
		if(modelInfo.getComponentModel().getConverter()==null){
			AppControllerReflect appController = AppControllerReflectFactory.getAppControllerInstance();
			converter = appController.getMvpBinding().getGlobalConverter();
		}
		else{
			converter=modelInfo.getComponentModel().getConverter();
		}
		return converter;
	}

	

	
	private Method findMethod(Field field, Class<?> klass) {

		    ClassType viewClassType = TypeOracle.Instance.getClassType(klass);
			Method method = viewClassType.getMethod("get"
					+ (field.getName().charAt(0) + "").toUpperCase()
					+ field.getName().substring(1),null);

		return method;
	}
	
	
	
    
}
