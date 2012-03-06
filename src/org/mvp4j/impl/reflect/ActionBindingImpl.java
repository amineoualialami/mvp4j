package org.mvp4j.impl.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.apache.log4j.Logger;
import org.mvp4j.adapter.ActionBinding;
import org.mvp4j.adapter.EventAction;
import org.mvp4j.annotation.Action;
import org.mvp4j.impl.swing.utils.LoggerUtils;

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
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	@Override
	public void callAction(Object eventObject) {
		try {
			
			Method method = actionInfo.getActionMethod();
			if(method.getParameterTypes().length==0){
			method.invoke(presenter);
			}                               
			else if(method.getParameterTypes().length==1){
				if(method.getParameterTypes()[0].equals(eventObject.getClass())){
				method.invoke(presenter,eventObject);
				}
				else
					logger.error("The event object "+method.getParameterTypes()[0].toString()+" is not supported "+
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
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public EventAction getEventAction() {
		// TODO Auto-generated method stub
		return actionInfo.getEventAction();
	}

}
