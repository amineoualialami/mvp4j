package com.atos.profilergwt.client;

import java.util.List;

import com.atos.profilergwt.client.model.UserModel;
import com.atos.profilergwt.shared.Profil;
import com.atos.profilergwt.shared.User;
import com.google.gwt.user.client.rpc.RemoteService;

public interface UserServices extends RemoteService {
	
	void addUser(User user);
	public List<User> getUsers();
	public List<Profil> getProfils();
	public Profil getProfilByName(String name);

}
