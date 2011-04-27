package org.mvp4j.adapter;

import org.mvp4j.Converter;

public interface MVPAdapter {
	
	/**
	 * The adapter can define it's converter to customize the data conversion.
	 * 
	 * @return Get the current converter used to convert data in component to data in the model
	 */
	public Converter getConvertor();
	
	
	
	
	/**
	 * For each Component supported, this method must return an instance of ActionComponenet
	 * to define the binding rules between a component and it's action in the associated presenter
	 * if the component class is not supported than throw an {@link IllegalArgumentException}
	 * @param componentKlass the component class
	 * @return EventActionComponent instance
	 */
	public Class<? extends ActionComponent> getComponentAction(Class<?> componentKlass);
	
	
	
	
	
	
	/**
	 * For each Component supported, this method must return an instance of ModelComponent
	 * to define the binding rules between a component and it's property name in the associated model. 
	 * if the component class is not supported than throw an {@link IllegalArgumentException}
	 * @param componentKlass the component class
	 * @return ModelComponent instance
	 */
	public Class<? extends ModelComponent> getComponentModel(Class<?> componentKlass);
	
	
	/**
	 * For each Component supported, this method must set an instance of customized ModelComponent
	 * to define the binding rules between a component and it's property name in the associated model. 
	 * if the component class is not supported than throw an {@link IllegalArgumentException}
	 * @param componentKlass the component class
	 * @param customizedModelComponent the model component class
	 */
	
	
	public void setComponentModel(Class<?> componentKlass ,Class<? extends ModelComponent> customizedModelComponent );

}
