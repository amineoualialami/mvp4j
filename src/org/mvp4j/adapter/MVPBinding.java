package org.mvp4j.adapter;

import org.mvp4j.Converter;

public interface MVPBinding {

	/**
	 * The adapter can define it's global converter to customize the data
	 * conversion.
	 * 
	 * @return Get the current converter used to convert data in component to
	 *         data in the model
	 */
	public Converter getGlobalConverter();

	/**
	 * Modify the current global converter used to convert data in component in
	 * order to update the model
	 */
	public void setGlobalConverter(Converter converter);

	/**
	 * For each Component supported, this method must set an instance of
	 * customized ModelComponent to define the binding rules between a component
	 * and it's property name in the associated model. if the component class is
	 * not supported than throw an {@link IllegalArgumentException}
	 * 
	 * @param componentKlass
	 *            the component class
	 * @param customizedModelComponent
	 *            the model component class
	 */

	public void setComponentModel(Object component,
			Class<? extends ModelComponent> customizedModelComponent);

	/**
	 * retrieve the ModelComponent through graphic component.
	 *  
	 * @param component
	 *          the graphic component
	 * @return the ModelComponent
	 */
	public ModelComponent getComponentModel(Object component);

	/**
	 * 
	 * @return the Presenter Object
	 */
	public Object getPresenter();

	/**
	 * 
	 * @return the Model Object
	 */
	public Object getModel();

	/**
	 * 
	 * @return the View Object
	 */
	public Object getView();

	/**
	 * 
	 * @param presenter
	 */
	public void setPresenter(Object presenter);

	/**
	 * 
	 * @param model
	 */
	public void setModel(Object model);

	/**
	 * 
	 * @param view
	 */
	public void setView(Object view);

}
