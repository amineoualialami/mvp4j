package com.profiler.client;

import org.mvp4j.impl.reflect.AppControllerReflect;
import org.mvp4j.impl.reflect.AppControllerReflectFactory;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.profiler.model.UserModel;
import com.profiler.presenter.UserPresenter;
import com.profiler.client.UserView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProfilerWebGWT implements EntryPoint {

	
	public void onModuleLoad() {
		Log.info("Start");
		Window.setMargin("300px");
		UserModel model = new UserModel();
		//model.init();
		UserView view = new UserView(model);
		UserPresenter presenter = new UserPresenter(view,model);
        
		
		AppControllerReflect appController = AppControllerReflectFactory.getAppControllerInstance();
		appController.bind(view, model, presenter );
		
		RootPanel.get().add(view.getFormulairePanel());
	}
}
