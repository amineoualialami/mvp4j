package com.atos.profilergwt.server;

import java.util.ArrayList;
import java.util.List;

import com.atos.profilergwt.client.UserServices;
import com.atos.profilergwt.shared.Profil;
import com.atos.profilergwt.shared.User;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserServicesImpl extends RemoteServiceServlet implements UserServices {
	
	
	private List<User> listUsers;
	private List<Profil> listProfils;

	@Override
	public void addUser(User user) {
		getUsers().add(user);
	}

	@Override
	public List<User> getUsers() {
		if(listUsers==null){
			listUsers = new ArrayList<User>();
			
		}
		return listUsers;
	}

	@Override
	public List<Profil> getProfils() {
		if(listProfils==null){
			listProfils = new ArrayList<Profil>();
			Profil profil1 = new Profil();
			profil1.setId(1);
			profil1.setName("profil 1");
			Profil profil2 = new Profil();
			profil2.setId(2);
			profil2.setName("profil 2");
			listProfils.add(profil1);
			listProfils.add(profil2);
		}
		return listProfils;
	}

	@Override
	public Profil getProfilByName(String name) {
		List<Profil> listProfils = getProfils();
		for (Profil profil : listProfils) {
			if(profil.getName().equals(name)){
				return profil;
			}
		}
		return null;
	}


}
