package org.mvp4j.impl.reflect;


import org.apache.log4j.Logger;
import org.mvp4j.adapter.ActionBinding;
import org.mvp4j.annotation.Action;
import org.mvp4j.impl.gwt.utils.LoggerUtils;

import com.gwtent.reflection.client.Method;

public class ActionBindingImpl implements ActionBinding {

	private ActionInfo actionInfo;
	private Object presenter;
	private Object view;
	private Logger logger = LoggerUtils.getLogger();

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return object;
	}

	@Override
	public void callAction(Object eventObject) {
		try {
			
			Method method = actionInfo.getActionMethod();
			if(method.getParameters().length==0){
			method.invoke(presenter);
			}                               
			else if(method.getParameters().length==1){
				if(method.getParameters()[0].getType().equals(eventObject.getClass())){
				method.invoke(presenter,eventObject);
				}
				else
					logger.error("The event object "+method.getParameters()[0].getTypeName()+" is not supported "+
							" try this event object:  "+eventObject.getClass().toString());
			}
			else{
				logger.error("The action must have one parameter ");
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public String getEventAction() {
		// TODO Auto-generated method stub
		return actionInfo.getEventAction();
	}

}
