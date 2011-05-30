package com.atos.profilergwt.client;

import org.mvp4j.AppController;
import org.mvp4j.impl.reflect.AppControllerReflectFactory;

import com.atos.profilergwt.client.UserView;
import com.atos.profilergwt.client.model.UserModel;
import com.atos.profilergwt.client.presenter.UserPresenter;
import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProfilerGWT implements EntryPoint {

	public void onModuleLoad() {

		Window.setMargin("300px");
		UserView view = new UserView();
		UserModel model = new UserModel();
		UserPresenter presenter = new UserPresenter(view,model);
        
		AppController appController = AppControllerReflectFactory.getAppControllerInstance();
		appController.bind(view, model, presenter );
		RootPanel.get().add(view.getFormulairePanel());
	}
}
