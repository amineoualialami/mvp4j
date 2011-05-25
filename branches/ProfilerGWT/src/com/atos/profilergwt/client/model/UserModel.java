package com.atos.profilergwt.client.model;

import java.io.Serializable;





public class UserModel implements Serializable {



	private String name;

	private String mail;

	private int phone;

	private String profil;



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



	public String getProfil() {
		return profil;
	}



	public void setProfil(String profil) {
		this.profil = profil;
	}

	

	
	
	
	
	

}
