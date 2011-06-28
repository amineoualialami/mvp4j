package com.profiler.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.mvp4j.impl.reflect.Reflectables;

import com.allen_sauer.gwt.log.client.Log;
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
	
	private List<UserGWT> users;
	
	
	public void init(){
		
		users = new ArrayList<UserGWT>();
		getService().getUsers(new AsyncCallback<List<UserGWT>>() {

			@Override
			public void onFailure(Throwable caught) {
				Log.info("Retrieve users failed");
				
			}

			@Override
			public void onSuccess(List<UserGWT> result) {
				setUsers(result);
				Log.info("Retrieve users success");
				
			}
		});
		
		profils = new ArrayList<ProfilGWT>();
		getService().getProfils(new AsyncCallback<List<ProfilGWT>>() {

			@Override
			public void onFailure(Throwable caught) {
				Log.info("Retrieve profils failed");
				
			}

			@Override
			public void onSuccess(List<ProfilGWT> result) {
				setProfils(result);
				Log.info("Retrieve profils success");
			}
			
		});

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
	
	



	public List<ProfilGWT> getProfils2() {
		return profils2;
	}



	public void setProfils2(List<ProfilGWT> profils2) {
		this.profils2 = profils2;
	}



	public List<UserGWT> getUsers() {
		return users;
	}



	public void setUsers(List<UserGWT> users) {
		this.users = users;
	}




	public static UserServicesAsync getService() {
		UserServicesAsync service = (UserServicesAsync) GWT
				.create(UserServices.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) service;
		String moduleRelativeURL = GWT.getModuleBaseURL() + "user";
		endpoint.setServiceEntryPoint(moduleRelativeURL);
		return service;
	}
	
	
	


	

	
	
	
	
	

}
