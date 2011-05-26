package org.mvp4j.impl.reflect;

import java.util.List;

public class ActionViewPresenterInfo {
	private Class<?> viewClass;
	private Class<?> presenterClass;
	private List<ActionInfo> actionsInfo;

	public Class<?> getViewClass() {
		return viewClass;
	}

	public void setViewClass(Class<?> viewClass) {
		this.viewClass = viewClass;
	}

	public Class<?> getPresenterClass() {
		return presenterClass;
	}

	public void setPresenterClass(Class<?> presenterClass) {
		this.presenterClass = presenterClass;
	}

	public List<ActionInfo> getActionsInfo() {
		return actionsInfo;
	}

	public void setActionsInfo(List<ActionInfo> actionsInfo) {
		this.actionsInfo = actionsInfo;
	}

}
