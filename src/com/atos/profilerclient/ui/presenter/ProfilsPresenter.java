package com.atos.profilerclient.ui.presenter;

import org.mvp4j.impl.reflect.AppControllerReflect;
import org.mvp4j.impl.reflect.AppControllerReflectFactory;

import com.atos.profilerclient.ui.model.ProfilsModel;
import com.atos.profilerclient.ui.view.ProfilsView;

public class ProfilsPresenter {
	
	
	private ProfilsModel profilModel;
	private ProfilsView profilsview;
	
	public ProfilsPresenter(ProfilsModel profilModel, ProfilsView profilsview) {
		this.profilModel=profilModel;
		this.profilsview=profilsview;
	}
	
	
	public void actionTable(){
		profilModel.setName(profilModel.getProfil().getName());
		AppControllerReflect appController = AppControllerReflectFactory
		.getAppControllerInstance();
		appController.refreshView(profilsview);
	}

}
