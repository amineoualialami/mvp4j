package com.profiler.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.profiler.shared.ProfilGWT;
import com.profiler.shared.UserGWT;

public interface UserServicesAsync {

	void addUser(UserGWT userGWT, AsyncCallback<Void> callback);

	void getUsers(AsyncCallback<List<UserGWT>> callback);

	void getProfils(AsyncCallback<List<ProfilGWT>> callback);

	void getProfilByName(String name, AsyncCallback<ProfilGWT> callback);

	void hello(AsyncCallback<String> callback);


}
