package org.mvp4j.impl.reflect;


import org.mvp4j.adapter.ActionBinding;
import org.mvp4j.annotation.Action;

import com.google.gwt.core.client.GWT;
import com.gwtent.reflection.client.Method;

public class ActionBindingImpl implements ActionBinding {

	private ActionInfo actionInfo;
	private Object presenter;
	private Object view;

	public ActionBindingImpl(Object view, Object presenter,
			ActionInfo actionInfo) {
		this.actionInfo = actionInfo;
		this.presenter = presenter;
		this.view = view;
	}

	@Override
	public String getActionName() {

		return actionInfo.getActionMethod().getName();
	}

	@Override
	public Class<?> getEventType() {

		if (actionInfo.getEventType() == Action.class) {
			return null;
		}

		return actionInfo.getEventType();
	}

	@Override
	public Object getComponent() {
		Object object = null;
		try {
			object = actionInfo.getMethod().invoke(view);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 
		return object;
	}

	@Override
	public void callAction(Object eventObject) {
			
			Method method = actionInfo.getActionMethod();
			if(method.getParameters().length==0){
			method.invoke(presenter);
			}                               
			else if(method.getParameters().length==1){
				if(method.getParameters()[0].getType().equals(eventObject.getClass())){
				method.invoke(presenter,eventObject);
				}
				else
//					logger.severe("The event object "+method.getParameters()[0].getTypeName()+" is not supported "+
//							" try this event object:  "+eventObject.getClass().toString());
				
				GWT.log("The event object "+method.getParameters()[0].getTypeName()+" is not supported "+
						" try this event object:  "+eventObject.getClass().toString());
			}
			else{
//				logger.severe("The action must have one parameter ");
				GWT.log("The action must have one parameter ");
			}
			
	}

	@Override
	public String getEventAction() {
		return actionInfo.getEventAction();
	}

}
