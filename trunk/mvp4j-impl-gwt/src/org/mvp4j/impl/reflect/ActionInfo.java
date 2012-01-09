package org.mvp4j.impl.reflect;

import com.gwtent.reflection.client.Method;




public class ActionInfo {
	private String action;
	private Class<?> eventType;
	private String eventAction;
	private Method method;
	private Method actionMethod;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Class<?> getEventType() {
		return eventType;
	}

	public void setEventType(Class<?> eventType) {
		this.eventType = eventType;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

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
