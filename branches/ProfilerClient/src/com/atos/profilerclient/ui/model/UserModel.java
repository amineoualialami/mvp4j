package com.atos.profilerclient.ui.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.kahvi.paketti.dtobuilder.annotations.DtoClass;
import org.kahvi.paketti.dtobuilder.annotations.DtoProperty;

import com.atos.profilerclient.dao.UserSessionDAOImpl;
import com.atos.profilerclient.dto.ProfilDTO;
import com.atos.profilerclient.dto.UserDTO;

public class UserModel implements Serializable {

	private Long idUser;

	private String name;

	private String mail;

	private Integer phone;

	private ProfilDTO profil;

	//combo List
	private List<ProfilDTO> profils;
	
	// pour les checkbox
	private List<ProfilDTO> profils2;
    private UserDTO user;
	
	private List<UserDTO> users;
	
	private ProfilDTO profil1;
	private ProfilDTO profil2;
	
	
  
	public UserModel() {

	}

	@DtoProperty(sourceClass=UserDTO.class)
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@DtoProperty(sourceClass=UserDTO.class)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DtoProperty(sourceClass=UserDTO.class)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@DtoProperty(sourceClass=UserDTO.class)
	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	@DtoProperty(sourceClass=UserDTO.class)
	public ProfilDTO getProfil() {
		return profil;
	}

	public void setProfil(ProfilDTO profil) {
		this.profil = profil;
	}

	public List<ProfilDTO> getProfils() {

		UserSessionDAOImpl userSession = new UserSessionDAOImpl();
		return userSession.loadAllProfils();
	}

	public void setProfils(List<ProfilDTO> profils) {
		this.profils = profils;
	}

	public List<UserDTO> getUsers() {
		UserSessionDAOImpl userSession = new UserSessionDAOImpl();
		users = userSession.getAllUsers(); 
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	public ProfilDTO getProfil1() {
		if(profil1==null){
			UserSessionDAOImpl userSession = new UserSessionDAOImpl();
			 profil1 = userSession.loadAllProfils().get(0);
		}
		return profil1;
	}

	public void setProfil1(ProfilDTO profil1) {
		this.profil1 = profil1;
	}

	public ProfilDTO getProfil2() {
		if(profil2==null){
			UserSessionDAOImpl userSession = new UserSessionDAOImpl();
			 profil2 = userSession.loadAllProfils().get(1);
		}
		return profil2;
	}

	public void setProfil2(ProfilDTO profil2) {
		this.profil2 = profil2;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public List<ProfilDTO> getProfils2() {
		if(profils2==null){
			profils2 = new ArrayList<ProfilDTO>();
		}
		return profils2;
	}

	public void setProfils2(List<ProfilDTO> profils2) {
		this.profils2 = profils2;
	}

	

	
	
	
	
	

}
