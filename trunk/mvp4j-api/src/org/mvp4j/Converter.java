package org.mvp4j;

import org.mvp4j.adapter.MVPAdapter;

/**
 * <p>
 * The converter class to convert an object value to an instance of specified type.
 * <p>
 * Use this to set a specific converter by calling {@link AppController#setConverter(Converter)}
 * <p>
 * The {@link AppController} will use the converter to convert component value before updating the associated
 * model property value.
 * <p>
 * When developing an adapter class {@link MVPAdapter}, create a customized converter depending 
 * on the adapter and return it in the method {@link MVPAdapter#getConvertor()}
 * 
 *
 */
public interface Converter {
	/**
	 * Convert an object value to an instance of specified type. 
	 * 
	 * If is not possible to convert throw a new {@link IllegalArgumentException}
	 * 
	 * @param type the target type of the instance converted from the value object
	 * @param value the object value to convert
	 * @return the result of conversion
	 */
	public Object convertToType(Class<?> type, Object value);

}
