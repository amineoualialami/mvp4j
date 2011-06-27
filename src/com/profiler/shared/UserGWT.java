package com.profiler.shared;

import java.io.Serializable;
import java.util.Date;


public class UserGWT implements Serializable{
	
	
	private Long idUser;

	private String name;

	private Date date;

	private String mail;

	private Integer phone;

	private ProfilGWT profil;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

	public ProfilGWT getProfil() {
		return profil;
	}

	public void setProfil(ProfilGWT profil) {
		this.profil = profil;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
