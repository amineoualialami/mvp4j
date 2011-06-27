package com.profiler.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.profiler.shared.ProfilGWT;
import com.profiler.shared.UserGWT;

public interface UserServices extends RemoteService {
	
	void addUser(UserGWT userGWT);
	public List<UserGWT> getUsers();
	public List<ProfilGWT> getProfils();
	public ProfilGWT getProfilByName(String name);
	public String hello();

}
