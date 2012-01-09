package org.mvp4j.adapter;

/**
 * <p>
 * This interface is used to retrieve binding informations between the current component and the a model property,
 * and simplify updating model on change event of the component value 
 * Use an instance of this interface when writing the {@link ModelComponenet} to support a specific component,
 * during implementing an adapter class {@link MVPAdapter} to a specific library.
 * <p>
 * The user can use the instance to add the change event to the current view component
 *  and call the setPropertyValue to update the current property in the model.
 *
 */
public interface ModelBinding {	

	/** 
	 * The current component.
	 * 
	 * @return The current component.
	 */	
	public Object getComponent();
	

	/** 
	 * The current property name.
	 * @return The current property name.
	 */
	public String getPropertyName();
	

	/** 
	 * The current property name.
	 * @return The current initialization property name.
	 */
	public String getInitPropertyName();
	
	/**
	 * <p>
	 * Use this method to set the current model property value, in the change event body handler,
	 * so when the component value change, the model property value must be updated.
 	 * <p>
	 * 
	 * throw {@link PropertyNotFoundException} if the property is not found in the model
	 * 
	 * <p>

	 */	
	public void setPropertyValue(Object value);
	
	/**
	 * <p>
	 * 
	 * throw {@link PropertyNotFoundException} if the property is not found in the model
	 * 
	 * <p>
	 * @return the current property value in the model
	 */
	public Object getPropertyValue();
	
	/**
	 * <p>
	 * 
	 * throw {@link PropertyNotFoundException} if the property is not found in the model
	 * throw {@link PropertyNotInitializedException} if the property is not initialized correctly
	 * <p>
	 * <p>
	 * Use this method to load data that the current component need to display in the view rendering, for example a comboBox.
	 * @return the current initialization property value in the model
	 */
	public Object getInitPropertyValue();
	
}
