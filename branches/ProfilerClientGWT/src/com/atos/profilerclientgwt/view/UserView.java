package com.atos.profilerclientgwt.view;

import java.util.List;

import com.atos.profilerclientgwt.model.UserDTO;
import com.atos.profilerclientgwt.model.UserModel;
import com.atos.profilerclientgwt.model.UserModelService;
import com.atos.profilerclientgwt.model.UserModelServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UserView extends VerticalPanel {

	
	
	private FlexTable usersFlexTable;
	private UserModel model = new UserModel();
	
	public UserView() {
		add(getUsersFlexTable());
		UserModelServiceAsync service = getService();
		AsyncCallback callBack = new AsyncCallback() {

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("Failure");
				
			}

			@Override
			public void onSuccess(Object result) {
				Window.alert("success");
				System.out.println("success");
				List<UserDTO> users = (List<UserDTO>) result;
				for (UserDTO userDTO : users) {
					System.out.println("userName : "+userDTO.getName()+"--------------------");
				}
				
			}	
		};
		service.getAllUsers(callBack);
	}
	
	
	public FlexTable getUsersFlexTable() {
		if(usersFlexTable==null){
			usersFlexTable= new FlexTable();
			//init the table
			//List<UserDTO> users = new ArrayList<UserDTO>();
			//users = model.getUsers();
			usersFlexTable.setText(0, 0, "id User");
			usersFlexTable.setText(0, 1, "name");
			usersFlexTable.setText(0, 2, "Date");
			usersFlexTable.setText(0, 3, "Phone");
			
			
		}
		return usersFlexTable;
	}

	public void setUsersFlexTable(FlexTable usersFlexTable) {
		this.usersFlexTable = usersFlexTable;
	}
	
	
	public static UserModelServiceAsync getService(){  
        // Create the client proxy. Note that although you are creating the  
        // service interface proper, you cast the result to the asynchronous  
        // version of  
        // the interface. The cast is always safe because the generated proxy  
        // implements the asynchronous interface automatically.  
		UserModelServiceAsync service = (UserModelServiceAsync) GWT.create(UserModelService.class);  
        // Specify the URL at which our service implementation is running.  
        // Note that the target URL must reside on the same domain and port from  
        // which the host page was served.  
        //  
        ServiceDefTarget endpoint = (ServiceDefTarget) service;  
        String moduleRelativeURL = GWT.getModuleBaseURL() + "user";  
        endpoint.setServiceEntryPoint(moduleRelativeURL);  
        return service;  
    }  
	
}
