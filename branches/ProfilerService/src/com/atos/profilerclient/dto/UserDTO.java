package com.atos.profilerclient.dto;

import java.io.Serializable;
import java.util.Date;

import org.kahvi.paketti.dtobuilder.annotations.DtoClass;
import org.kahvi.paketti.dtobuilder.annotations.DtoProperty;

import com.atos.profiler.model.Profil;
import com.atos.profiler.model.User;


public class UserDTO implements Serializable {
	
	private Long idUser;
	private String name;
	private Date date;
	private String mail;
	private Integer phone;
	private ProfilDTO profil;
	
	public UserDTO() {
	}

	@DtoProperty(sourceClass=User.class)
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@DtoProperty(sourceClass=User.class)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DtoProperty(sourceClass=User.class)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@DtoProperty(sourceClass=User.class)
	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	@DtoProperty(sourceClass=User.class)
	public ProfilDTO getProfil() {
		return profil;
	}

	public void setProfil(ProfilDTO profil) {
		this.profil = profil;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return this.getName();
	}
	
	
	

}
