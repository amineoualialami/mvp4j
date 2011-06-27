package com.profiler.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.mvp4j.impl.reflect.Reflectables;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.gwtent.reflection.client.Reflection;
import com.profiler.client.UserServices;
import com.profiler.client.UserServicesAsync;
import com.profiler.shared.ProfilGWT;
import com.profiler.shared.UserGWT;





public class UserModel implements Serializable ,Reflection{



	private String name;

	private String mail;

	private int phone;

	private ProfilGWT profil;
	
	private ProfilGWT profil1;
	
	private ProfilGWT profil2;
	
	private List<ProfilGWT> profils;
	
	private List<ProfilGWT> profils2;
	
	private ArrayList users;
	
	
	public void init(){
//		getService().getUsers(new AsyncCallback<List<User>>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onSuccess(List<User> result) {
//				List<User> listUsers= result;
//				setUsers(listUsers);
//			}
//			
//		});
		AsyncCallback callback = new AsyncCallback() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Object result) {
				List<ProfilGWT> listProfils = (List<ProfilGWT>) result;
				//setProfils(listProfils);
				profil1 = listProfils.get(0);
				profil2 = listProfils.get(1);
				setProfil1(profil1);
				setProfil2(profil2);
			}
		};
		getService().getProfils(callback);
		
		
		
		
	}



	public String getName() {
	
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public int getPhone() {
		return phone;
	}



	public void setPhone(int phone) {
		this.phone = phone;
	}



	public ProfilGWT getProfil() {
		return profil;
	}



	public void setProfil(ProfilGWT profil) {
		this.profil = profil;
	}



	public List<ProfilGWT> getProfils() {
		profils = new ArrayList<ProfilGWT>();
		ProfilGWT profil1 = new ProfilGWT();
		profil1.setId(1);
		profil1.setName("profil 1");
		ProfilGWT profil2 = new ProfilGWT();
		profil2.setId(2);
		profil2.setName("profil 2");
		profils.add(profil1);
		profils.add(profil2);
		
		return profils;
	}



	public void setProfils(List<ProfilGWT> profils) {
		this.profils = profils;
	}



	public ProfilGWT getProfil1() {
		return profil1;
	}



	public void setProfil1(ProfilGWT profil1) {
		this.profil1 = profil1;
	}



	public ProfilGWT getProfil2() {
		return profil2;
	}



	public void setProfil2(ProfilGWT profil2) {
		this.profil2 = profil2;
	}
	
	

	public static UserServicesAsync getService() {
		UserServicesAsync service = (UserServicesAsync) GWT
				.create(UserServices.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) service;
		String moduleRelativeURL = GWT.getModuleBaseURL() + "user";
		endpoint.setServiceEntryPoint(moduleRelativeURL);
		return service;
	}



	public List<ProfilGWT> getProfils2() {
		return profils2;
	}



	public void setProfils2(List<ProfilGWT> profils2) {
		this.profils2 = profils2;
	}



	public ArrayList getUsers() {
		users = new ArrayList();
		UserGWT user1 = new UserGWT();
		user1.setName("user 1");
		UserGWT user2 = new UserGWT();
		user2.setName("user 2");
		users.add(user1);
		users.add(user2);
		return users;
	}



	public void setUsers(ArrayList users) {
		this.users = users;
	}



	
	
	
	


	

	
	
	
	
	

}
