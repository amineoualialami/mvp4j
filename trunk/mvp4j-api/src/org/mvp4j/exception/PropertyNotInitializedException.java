package org.mvp4j.exception;

/**
 * <p>
 * A runtime exception that describes that a Java Bean initProperty is not
 * initialized.
 */

public class PropertyNotInitializedException extends RuntimeException {

	/**
	 * Constructs a new exception instance with the specified detail message.
	 * 
	 * @param initPropertyName
	 *            The name of the initProperty that is not initialized
	 */

	public PropertyNotInitializedException(String initPropertyName) {
		super("Property '" + initPropertyName + "' is not initialized ");
	}
}
