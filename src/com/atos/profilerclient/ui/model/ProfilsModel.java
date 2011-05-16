package com.atos.profilerclient.ui.model;

import java.util.List;

import com.atos.profilerclient.dao.UserSessionDAOImpl;
import com.atos.profilerclient.dto.ProfilDTO;

public class ProfilsModel {
	
	
	private String name;
	private List<ProfilDTO> profils;
	private ProfilDTO profil;
	
	
	public List<ProfilDTO> getProfils() {

		UserSessionDAOImpl userSession = new UserSessionDAOImpl();
		profils = userSession.loadAllProfils();
		return  profils;
	}


	public void setProfils(List<ProfilDTO> profils) {
		this.profils = profils;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ProfilDTO getProfil() {
		return profil;
	}


	public void setProfil(ProfilDTO profil) {
		this.profil = profil;
	}
	
	
	
	
	
	
	
	
	

}
