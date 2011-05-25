package com.atos.profilergwt.client;

import org.mvp4j.annotation.MVP;

import com.atos.profilergwt.client.UserView;
import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.ui.RootPanel;

import com.gwtent.reflection.client.ClassType;
import com.gwtent.reflection.client.TypeOracle;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProfilerGWT implements EntryPoint {

	public void onModuleLoad() {

		Window.setMargin("300px");
		UserView view = new UserView();
		ClassType classType = TypeOracle.Instance.getClassType(UserView.class);
		classType.invoke(view, "test", null);
		System.out.println(classType.isAnnotationPresent(MVP.class));

		RootPanel.get().add(view.getFormulairePanel());
	}
}
