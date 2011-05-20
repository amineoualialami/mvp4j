package com.atos.profilerclientgwt.client;


//import com.atos.profilerclient.dto.UserDTO;
//import com.atos.profilerclientgwt.model.UserModel;
import com.atos.profilerclientgwt.view.UserView;
import com.google.gwt.core.client.EntryPoint;
//import com.google.gwt.user.client.ui.FlexTable;
//import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProfilerClientGWT implements EntryPoint {
	
	
	

	@Override
	public void onModuleLoad() {
        
		UserView userView = new UserView(); 
		RootPanel.get("profiler").add(userView);
		
		
	}

	
	
	
}
