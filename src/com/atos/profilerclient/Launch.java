package com.atos.profilerclient;

import javax.swing.JTable;

import org.mvp4j.AppController;
import org.mvp4j.adapter.MVPAdapter;
import org.mvp4j.impl.reflect.AppControllerReflect;
import org.mvp4j.impl.reflect.AppControllerReflectFactory;
import org.mvp4j.impl.swing.SwingAdapter;

import com.atos.profilerclient.ui.model.UserModel;
import com.atos.profilerclient.ui.presenter.CustomizedTableModel;
import com.atos.profilerclient.ui.presenter.UserPresenter;
import com.atos.profilerclient.ui.view.UserView;

public class Launch {

	public static void main(String[] args) {

		UserView view = new UserView();
		UserModel model = new UserModel();
		UserPresenter presenter = new UserPresenter(view, model);
		view.setVisible(true);
		
		
		MVPAdapter swingAdapater = new SwingAdapter();
		swingAdapater.setComponentModel(JTable.class, CustomizedTableModel.class);
		
		AppControllerReflect appController = AppControllerReflectFactory
				.getAppControllerInstance();
		appController.getCurrentAdapter().setComponentModel(JTable.class,CustomizedTableModel.class);
		appController.bind(view, model, presenter);
		

	}
}
