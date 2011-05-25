package com.atos.profilergwt.server;

import java.util.ArrayList;
import java.util.List;

import com.atos.profilergwt.client.UserListService;
import com.atos.profilergwt.client.model.UserModel;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserListServiceImpl extends RemoteServiceServlet implements UserListService{

	@Override
	public void  initProfils() {
             
              
              
              System.out.println("server invoked");
              
            
		
	}

	
}
