package com.atos.profilergwt.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.atos.profilergwt.client.UserServices;
import com.atos.profilergwt.client.UserServicesAsync;
import com.atos.profilergwt.shared.Profil;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.gwtent.reflection.client.Reflection;





public class UserModel implements Serializable ,Reflection{



	private String name;

	private String mail;

	private int phone;

	private Profil profil;
	
	private Profil profil1;
	
	private Profil profil2;
	
	private List<Profil> profils;
	
	private List<Profil> profils2;
	
	
	public void init(){
		AsyncCallback callback = new AsyncCallback() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Object result) {
				List<Profil> listProfils = (List<Profil>) result;
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



	public Profil getProfil() {
		return profil;
	}



	public void setProfil(Profil profil) {
		this.profil = profil;
	}



	public List<Profil> getProfils() {
		profils = new ArrayList<Profil>();
		Profil profil1 = new Profil();
		profil1.setId(1);
		profil1.setName("profil 1");
		Profil profil2 = new Profil();
		profil2.setId(2);
		profil2.setName("profil 2");
		profils.add(profil1);
		profils.add(profil2);
		
		return profils;
	}



	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}



	public Profil getProfil1() {
		return profil1;
	}



	public void setProfil1(Profil profil1) {
		this.profil1 = profil1;
	}



	public Profil getProfil2() {
		return profil2;
	}



	public void setProfil2(Profil profil2) {
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



	public List<Profil> getProfils2() {
		return profils2;
	}



	public void setProfils2(List<Profil> profils2) {
		this.profils2 = profils2;
	}
	
	


	

	
	
	
	
	

}
