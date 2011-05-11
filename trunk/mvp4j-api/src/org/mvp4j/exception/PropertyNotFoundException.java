package org.mvp4j.exception;

/**
 * <p>
 * A runtime exception that describes that a Java Bean property could not be
 * found.
 */

public class PropertyNotFoundException extends RuntimeException {

	/**
	 * Constructs a new exception instance with the specified detail message.
	 * 
	 * @param propertyName
	 *            the name of the property that could not be found
	 * @param bean
	 *            the Model Java Bean used to bind the property
	 */

	public PropertyNotFoundException(String propertyName, Object bean) {
		super("Property '" + propertyName + "' not found in bean " + bean);
	}

}
