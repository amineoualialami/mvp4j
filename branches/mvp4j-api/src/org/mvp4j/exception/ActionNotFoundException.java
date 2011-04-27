package org.mvp4j.exception;

/**
 * <p>
 * A runtime exception that describes that an Action could not be found.
 */

public class ActionNotFoundException extends RuntimeException {

	/**
	 * Constructs a new exception instance with the specified detail message.
	 * 
	 * @param actionName
	 *            the name of the action that could not be found
	 * @param bean
	 *            the instance of the Presenter used to bind the action
	 */

	public ActionNotFoundException(String actionName, Object bean) {
		super("Action '" + actionName + "' not found in presenter " + bean);
	}

}
