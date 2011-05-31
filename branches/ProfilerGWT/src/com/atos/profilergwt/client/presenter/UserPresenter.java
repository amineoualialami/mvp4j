package com.atos.profilergwt.client.presenter;

import java.util.List;

import com.atos.profilergwt.client.UserServices;
import com.atos.profilergwt.client.UserServicesAsync;
import com.atos.profilergwt.client.UserView;
import com.atos.profilergwt.client.model.UserModel;
import com.atos.profilergwt.shared.Profil;
import com.atos.profilergwt.shared.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.gwtent.reflection.client.Reflection;

public class UserPresenter implements Reflection{
	
	private UserView userView;
	private UserModel userModel;
	
	
	public UserPresenter(UserView userView, UserModel userModel) {
		this.userView= userView;
		this.userModel=userModel;
	}
	
	public void action1(){
		System.out.println("action1");
		final User user = new User();

		AsyncCallback callback = new AsyncCallback() {
			public void onSuccess(Object result) {
				initTableValues();
			}

			public void onFailure(Throwable caught) {
			}
		};

		AsyncCallback callback2 = new AsyncCallback() {
			public void onSuccess(Object result) {
				user.setProfil((Profil) result);
			}

			public void onFailure(Throwable caught) {
			}
		};

//		user.setName(userView.getNameTextBox().getText());
//		user.setPhone(Integer.parseInt(userView.getPhoneTextBox().getText()));
//		user.setMail(userView.getMailTextBox().getText());
		
		user.setName(userModel.getName());
		user.setPhone(userModel.getPhone());
		user.setMail(userModel.getMail());
		

		getService().getProfilByName(
				userView.getProfilsListBox().getItemText(
						userView.getProfilsListBox().getSelectedIndex()),
				callback2);

		getService().addUser(user, callback);
		
		
		
	}
	
	public void action2(){
		System.out.println("action2");
	}
	
	public void action3(){
		System.out.println("action3");
	}
	
	
	public void initTableValues() {

		AsyncCallback callback = new AsyncCallback() {
			public void onSuccess(Object result) {
				List<User> listUsers = (List<User>) result;
				int i = 1;
				for (User user : listUsers) {
					userView.getFlexTable().setText(i, 0, user.getName());
					// getTableRows().setText(i, 1,
					// user.getProfil().toString());
					userView.getFlexTable().setText(i, 2, user.getPhone() + "");
					userView.getFlexTable().setText(i, 3, user.getMail());
					i++;
				}
			}

			public void onFailure(Throwable caught) {
				// do some UI stuff to show failure
			}
		};
		getService().getUsers(callback);

	}
	
	
	public static UserServicesAsync getService() {
		// Create the client proxy. Note that although you are creating the
		// service interface proper, you cast the result to the asynchronous
		// version of
		// the interface. The cast is always safe because the generated proxy
		// implements the asynchronous interface automatically.
		UserServicesAsync service = (UserServicesAsync) GWT
				.create(UserServices.class);
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
