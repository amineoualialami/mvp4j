package com.profiler.presenter;

import java.util.List;

import org.mvp4j.impl.reflect.Reflectables;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.gwtent.reflection.client.Reflection;
import com.profiler.client.UserServices;
import com.profiler.client.UserServicesAsync;
import com.profiler.client.UserView;
import com.profiler.model.UserModel;
import com.profiler.shared.ProfilGWT;
import com.profiler.shared.UserGWT;
import com.sun.java.swing.plaf.windows.resources.windows;

public class UserPresenter implements Reflection {

	private UserView userView;
	private UserModel userModel;

	public UserPresenter(UserView userView, UserModel userModel) {
		this.userView = userView;
		this.userModel = userModel;
	}

	public void action1() {
		Log.info("action 1");
		// final User user = new User();
		//
		// AsyncCallback callback = new AsyncCallback() {
		// public void onSuccess(Object result) {
		// System.out.println("init");
		// initTableValues();
		// }
		//
		// public void onFailure(Throwable caught) {
		// }
		// };
		//
		// user.setName(userModel.getName());
		// user.setPhone(userModel.getPhone());
		// user.setMail(userModel.getMail());
		// user.setProfil(userModel.getProfil());
		//
		// getService().addUser(user, callback);
		//

		Log.info(userModel.getName()+" "+userModel.getPhone()+" "+userModel.getMail());
		UserGWT userGWT = new UserGWT();
		userGWT.setName(userModel.getName());
		userGWT.setPhone(userModel.getPhone());
		userGWT.setMail(userModel.getMail());
		getService().addUser(userGWT, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Log.info("Call addUser Failed : "+caught.getCause());
				
			}

			@Override
			public void onSuccess(Void result) {
				Log.info("Call to service RPC succeed");
			}
		});
		
		

	}

//	public void action2() {
//		System.out.println("action2");
//		List<ProfilGWT> list = userModel.getProfils2();
//		System.out.println("CHECKBOX : " + userModel.getProfils2().size());
//		for (ProfilGWT profilDTO : list) {
//			System.out.println("CHECKBOX :" + profilDTO.getName());
//		}
//	}

//	public void action3() {
//		System.out.println("action3");
//	}
//
//	public void initTableValues() {
//
//		AsyncCallback callback = new AsyncCallback() {
//			public void onSuccess(Object result) {
//				List<UserGWT> listUsers = (List<UserGWT>) result;
//				int i = 1;
//				for (UserGWT user : listUsers) {
//					userView.getFlexTable().setText(i, 0, user.getName());
//					userView.getFlexTable().setText(i, 1,
//							user.getProfil().toString());
//					userView.getFlexTable().setText(i, 2, user.getPhone() + "");
//					userView.getFlexTable().setText(i, 3, user.getMail());
//					i++;
//				}
//			}
//
//			public void onFailure(Throwable caught) {
//				// do some UI stuff to show failure
//			}
//		};
//		getService().getUsers(callback);
//
//	}

	public static UserServicesAsync getService() {
		UserServicesAsync service = (UserServicesAsync) GWT
				.create(UserServices.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) service;
		String moduleRelativeURL = GWT.getModuleBaseURL() + "user";
		endpoint.setServiceEntryPoint(moduleRelativeURL);
		Log.info("Service RPC retrieved :"+service.toString());
		Log.info("moduleRelativeURL : " +moduleRelativeURL);
		Log.info("Try to call Hello :");
		service.hello(new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				Log.info("Call hello Failed : "+caught.getCause());
				
			}

			@Override
			public void onSuccess(String result) {
				Log.info(result);
				
			}
		});
		
		return service;
	}

}
