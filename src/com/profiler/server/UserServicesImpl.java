package com.profiler.server;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.profiler.client.UserServices;
import com.profiler.entity.Profil;
import com.profiler.entity.User;
import com.profiler.services.UserSessionRemote;
import com.profiler.shared.ProfilGWT;
import com.profiler.shared.UserGWT;

public class UserServicesImpl extends RemoteServiceServlet implements UserServices {

	private UserSessionRemote userSession;
	
	
	@Override
	public void addUser(UserGWT userGWT) {
		Log.info("AddUser Called ");
		User user = new User();
//		Profil profil = new Profil();
//		profil.setId(userGWT.getProfil().getId());
//		profil.setName(userGWT.getProfil().getName());
		user.setName(userGWT.getName());
		user.setPhone(userGWT.getPhone());
//		user.setProfil(profil);
		user.setMail(userGWT.getMail());
//		user.setDate(userGWT.getDate());
		Log.info("user : "+user.getName()+" "+user.getPhone()+" "+user.getMail());
		getUserSession().addUser(user);
	}

	@Override
	public List<UserGWT> getUsers() {
		List<User> listUsers = getUserSession().getAllUsers();
		List<UserGWT> listUsersGWT = new ArrayList<UserGWT>();
		for (User user : listUsers) {
			UserGWT userGWT = new UserGWT();
			ProfilGWT profilGWT = new ProfilGWT();
			userGWT.setIdUser(user.getIdUser());
			userGWT.setName(user.getName());
			userGWT.setMail(user.getMail());
			userGWT.setDate(user.getDate());
			userGWT.setPhone(user.getPhone());
			profilGWT.setId(user.getProfil().getId());
			profilGWT.setName(user.getProfil().getName());
			userGWT.setProfil(profilGWT);
			listUsersGWT.add(userGWT);
		}
		return listUsersGWT;
	}

	@Override
	public List<ProfilGWT> getProfils() {
		List<Profil> listProfils= getUserSession().loadAllProfil();
		List<ProfilGWT> listProfilsGWT = new ArrayList<ProfilGWT>();
		for (Profil profil : listProfils) {
			ProfilGWT profilGWT = new ProfilGWT();
			profilGWT.setId(profil.getId());
			profilGWT.setName(profil.getName());
			listProfilsGWT.add(profilGWT);
		}
		return listProfilsGWT;
	}

	@Override
	public ProfilGWT getProfilByName(String name) {
		Profil profil = getUserSession().getProfilByName(name);
		ProfilGWT profilGWT = new ProfilGWT();
		profilGWT.setId(profil.getId());
		profilGWT.setName(profil.getName());
		return profilGWT;
	}

	@Override
	public String hello() {
		return getUserSession().hello();
	}

	public UserSessionRemote getUserSession() {
		if(userSession==null){
			userSession =  (UserSessionRemote) ServiceLocator.getRemoteInterface("ProfilerEA/UserSession/remote");
		}
		return userSession;
	}
	
	
	
	

	
	
	


}
