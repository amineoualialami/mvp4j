package com.atos.profilerclientgwt.model;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;

public interface UserModelService extends RemoteService {
	
	public List<UserDTO> getAllUsers();
	public void test();

}
