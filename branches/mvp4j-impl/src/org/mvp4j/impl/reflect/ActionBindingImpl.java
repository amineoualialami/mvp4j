package org.mvp4j.impl.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.mvp4j.adapter.ActionBinding;
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
	public void callAction() {
		try {
			
			Method method = actionInfo.getActionMethod();
			method.invoke(presenter);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			logger.error("The Method '"+actionInfo.getActionMethod().getName()+" must provide any argument");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
