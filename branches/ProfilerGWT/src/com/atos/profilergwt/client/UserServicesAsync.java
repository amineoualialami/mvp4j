package com.atos.profilergwt.client;

import java.util.List;

import com.atos.profilergwt.client.model.UserModel;
import com.atos.profilergwt.shared.Profil;
import com.atos.profilergwt.shared.User;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServicesAsync {

	void addUser(User user, AsyncCallback<Void> callback);

	void getUsers(AsyncCallback<List<User>> callback);

	void getProfils(AsyncCallback<List<Profil>> callback);

	void getProfilByName(String name, AsyncCallback<Profil> callback);

}
