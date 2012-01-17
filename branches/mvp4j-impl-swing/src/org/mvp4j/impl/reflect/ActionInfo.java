package org.mvp4j.impl.reflect;

import java.lang.reflect.Method;

/**
 * Simple bean that contains detailed information about an action
 * 
 * @author MVP4J team
 *
 */
public class ActionInfo {
	private String action;
	private Class<?> eventType;
	private String eventAction;
	private Method method;
	private Method actionMethod;
    
	/**
	 * 
	 * @return action name
	 */
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
    /**
     * 
     * @return the event listener type
     */
	public Class<?> getEventType() {
		return eventType;
	}

	public void setEventType(Class<?> eventType) {
		this.eventType = eventType;
	}

	/**
	 * 
	 * @return the method annotated
	 */
	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}
    
	/**
	 * 
	 * @return the Action to invoke in result of an event handling 
	 */
	public Method getActionMethod() {
		return actionMethod;
	}

	public void setActionMethod(Method actionMethod) {
		this.actionMethod = actionMethod;
	}

	public String getEventAction() {
		return eventAction;
	}

	public void setEventAction(String eventAction) {
		this.eventAction = eventAction;
	}
	
	

}
