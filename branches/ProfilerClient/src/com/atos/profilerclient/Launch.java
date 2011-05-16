package com.atos.profilerclient;

import javax.swing.JTable;

import org.mvp4j.AppController;
import org.mvp4j.adapter.MVPAdapter;
import org.mvp4j.adapter.MVPBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.impl.reflect.AppControllerReflect;
import org.mvp4j.impl.reflect.AppControllerReflectFactory;
import org.mvp4j.impl.swing.SwingAdapter;

import com.atos.profilerclient.ui.model.CustomizedTableModel;
import com.atos.profilerclient.ui.model.MyConverter;
import com.atos.profilerclient.ui.model.MyConverter2;
import com.atos.profilerclient.ui.model.UserModel;
import com.atos.profilerclient.ui.presenter.UserPresenter;
import com.atos.profilerclient.ui.view.ProfilsView;
import com.atos.profilerclient.ui.view.UserView;

public class Launch {

	public static void main(String[] args) {

		UserView view = new UserView();
		UserModel model = new UserModel();
		UserPresenter presenter = new UserPresenter(view, model);
		
		
		
		
		AppControllerReflect appController = AppControllerReflectFactory
				.getAppControllerInstance();
		
		MVPBinding mvpBinding = appController.bind(view, model, presenter);
		
		mvpBinding.getComponentModel(view.getDateTextField()).setConverter(new MyConverter());
//		mvpBinding.getComponentModel(view.getNameTextField()).setConverter(new MyConverter());
//		mvpBinding.setComponentModel(view.getTable(), CustomizedTableModel.class);
		
		
//		ModelComponent modelComponent = appController.getCurrentAdapter().getComponentModel(view, view.getNameTextField());
//		modelComponent.setConverter(new MyConverter());
//		ModelComponent modelComponent2 = appController.getCurrentAdapter().getComponentModel(view, view.getTelTextField());
//		modelComponent2.setConverter(new MyConverter2());
		
		
		
//		appController.getCurrentAdapter().setComponentModel(view,model, view.getTable(), CustomizedTableModel.class);	
		
		view.setVisible(true);
		
		
		
	
		

	}
}
