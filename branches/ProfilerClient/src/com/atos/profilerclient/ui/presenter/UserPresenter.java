package com.atos.profilerclient.ui.presenter;


import org.kahvi.paketti.dtobuilder.DtoBuilder;
import org.kahvi.paketti.dtobuilder.DtoConfigurationException;
import org.kahvi.paketti.dtobuilder.DtoDismantler;
import org.mvp4j.impl.reflect.AppControllerReflect;
import org.mvp4j.impl.reflect.AppControllerReflectFactory;

import com.atos.profilerclient.dao.UserSessionDAO;
import com.atos.profilerclient.dao.UserSessionDAOImpl;
import com.atos.profilerclient.dto.ProfilDTO;
import com.atos.profilerclient.dto.UserDTO;
import com.atos.profilerclient.ui.model.UserModel;
import com.atos.profilerclient.ui.view.UserView;

public class UserPresenter {

	UserView view;
	UserModel model;
	DtoDismantler<UserModel, UserDTO> userDTODismantler;
	DtoBuilder<UserModel> userDTOBuilder;
	UserSessionDAO userSession;

	public UserPresenter(UserView view, UserModel model) {
		this.view = view;
		this.model = model;
	}
	
	public void toto(){
		System.out.println("toto");
	}
	public void tata(){
		System.out.println("tata");
	}
	public void edit(){
		model.setName(model.getUser().getName());
		model.setPhone(model.getUser().getPhone());
		model.setMail(model.getUser().getMail());
		model.setProfil(model.getUser().getProfil());
		AppControllerReflect appController = AppControllerReflectFactory
				.getAppControllerInstance();

		appController.refreshView(view);
		
	}

	public void addUser() {
		System.out.println("Add Action");

		try {
			model.setIdUser(100L);
			// model.setProfil(new ProfilDTO());
			// model.setMail("fpkfre");
			// model.setName("ded");
			// model.setPhone(645);
			UserDTO userDTO1 = getUserDTODismantler().dismantle(model);
//			System.out.println(userDTO1);
//			System.out.println(model.getUser().getIdUser());
//			System.out.println("match = "+getUserSession().findUser(model.getUser().getIdUser()).getName());
//			if (getUserSession().findUser(model.getUser().getIdUser()) == null) {
				System.out.println(model.getProfil().getName());
			    getUserSession().addUser(userDTO1);
//			} else {
//				getUserSession().updateUser(userDTO1);
//			}
			AppControllerReflect appController = AppControllerReflectFactory
					.getAppControllerInstance();

			appController.refreshView(view);
		} catch (DtoConfigurationException e) {
			e.printStackTrace();
			AppControllerReflect appController = AppControllerReflectFactory
					.getAppControllerInstance();

			appController.refreshView(view);
		}

	}

	public void clear() {
		System.out.println("Clear Action");
		model.setName("");
		model.setPhone(null);
		model.setMail("");
//		model.getProfils2().add(model.getProfil2());
//		model.getProfils2().add(model.getProfil1());
		AppControllerReflect appController = AppControllerReflectFactory
				.getAppControllerInstance();

		appController.refreshView(view);
		// pour les checkbox
		// List<ProfilDTO> list = model.getProfils2();
		// System.out.println(model.getProfils2().size());
		// for (ProfilDTO profilDTO : list) {
		// System.out.println(profilDTO.getName());
		// }
		// view.clear();
	}

	public void removeUser() {
		getUserSession().deleteUser(model.getUser().getIdUser());
		AppControllerReflect appController = AppControllerReflectFactory
				.getAppControllerInstance();

		appController.refreshView(view);
		System.out.println("Remove Action");
	}

	public void editUser() {
		System.out.println("Edit Action");
		model.setName(model.getUser().getName());
		model.setPhone(model.getUser().getPhone());
		model.setMail(model.getUser().getMail());
		model.setProfil(model.getUser().getProfil());
		AppControllerReflect appController = AppControllerReflectFactory
				.getAppControllerInstance();

		
		appController.refreshView(view);
	}

	public void actionMenu1() {
		System.out.println("Action menu 1");
	}

	public void actionMenu2() {
		System.out.println("Action menu 2");
	}

	public void actionProfil1() {
		System.out.println("profil1");
		System.out.println("size  " + getUserSession().loadAllProfils().size());
		ProfilDTO profil = getUserSession().loadAllProfils().get(0);

		System.out.println(profil.getName());
		model.setProfil(profil);
	}

	public void actionProfil2() {
		System.out.println("profil2");
		ProfilDTO profil = getUserSession().loadAllProfils().get(1);
		model.setProfil(profil);
	}

	public UserSessionDAO getUserSession() {
		return new UserSessionDAOImpl();
	}

	public void setUserSession(UserSessionDAO userSession) {
		this.userSession = userSession;
	}

	public DtoDismantler<UserModel, UserDTO> getUserDTODismantler() {
		if (userDTODismantler == null) {
			userDTODismantler = new DtoDismantler<UserModel, UserDTO>(
					UserModel.class, UserDTO.class);
		}
		return userDTODismantler;
	}
}
