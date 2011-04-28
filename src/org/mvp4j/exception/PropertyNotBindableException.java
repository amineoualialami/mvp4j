package org.mvp4j.exception;

/**
 * <p>
 * A runtime exception that describes that a Java Bean property could not be
 * bound properly with the view component.
 */

public class PropertyNotBindableException extends RuntimeException {

	/**
	 * Constructs a new exception instance with the specified detail message.
	 * 
	 * @param propertyName
	 *            The name of the property that could not be bound properly
	 * @param propertyType
	 *            The type of the property Java Bean used to bind the component
	 * @param componentType
	 *            The type of the component
	 */

	public PropertyNotBindableException(String propertyName,
			Object propertyType, Object componentType) {
		super("Property '" + propertyName + "' of type '" + propertyType
				+ "' cannot be bound properly with component" + componentType);
	}

}
