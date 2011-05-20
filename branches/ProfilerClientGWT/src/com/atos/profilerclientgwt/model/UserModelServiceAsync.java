package com.atos.profilerclientgwt.model;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserModelServiceAsync {

	void getAllUsers(AsyncCallback<List<UserDTO>> callback);

	void test(AsyncCallback<Void> callback);

}
