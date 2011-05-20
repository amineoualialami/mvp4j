package com.atos.profilerclientgwt.model;

import java.io.Serializable;
import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;


//import com.atos.profilerclient.dao.UserSessionDAOImpl;
//import com.atos.profilerclient.dto.ProfilDTO;
//import com.atos.profilerclient.dto.UserDTO;

public class UserModel implements Serializable,IsSerializable {
	

	private Long idUser;

	private String name;

	private String mail;

	private Integer phone;

	private Date date;
	
//	private ProfilDTO profil;
//
//	//combo List
//	private List<ProfilDTO> profils;
//	
//	// pour les checkbox
//	private List<ProfilDTO> profils2;
//    private UserDTO user;
//	
//	private List<UserDTO> users;
//	
//	private ProfilDTO profil1;
//	private ProfilDTO profil2;
	
	
  
	public UserModel() {

	}

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


}
