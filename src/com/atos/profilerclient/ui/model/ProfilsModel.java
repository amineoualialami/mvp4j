package com.atos.profilerclient.ui.model;

import java.util.List;

import com.atos.profilerclient.dao.UserSessionDAOImpl;
import com.atos.profilerclient.dto.ProfilDTO;

public class ProfilsModel {
	
	private List<ProfilDTO> profils;
	
	
	public List<ProfilDTO> getProfils() {

		UserSessionDAOImpl userSession = new UserSessionDAOImpl();
		profils = userSession.loadAllProfils();
		return  profils;
	}


	public void setProfils(List<ProfilDTO> profils) {
		this.profils = profils;
	}
	
	
	
	

}
