package com.atos.profilergwt.client.model;

import java.io.Serializable;

import com.atos.profilergwt.shared.Profil;





public class UserModel implements Serializable {



	private String name;

	private String mail;

	private int phone;

	private Profil profil;



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




	

	
	
	
	
	

}
