package com.atos.profilerGWT.server;

import java.util.ArrayList;
import java.util.List;

import com.atos.profilerGWT.client.UserListService;
import com.atos.profilerGWT.client.model.UserModel;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserListServiceImpl extends RemoteServiceServlet implements UserListService{

	@Override
	public void  initProfils() {
             
              
              
              System.out.println("server invoked");
              
            
		
	}

	
}
