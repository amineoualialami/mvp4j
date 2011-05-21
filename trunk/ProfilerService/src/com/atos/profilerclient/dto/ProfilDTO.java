package com.atos.profilerclient.dto;



import org.kahvi.paketti.dtobuilder.annotations.DtoClass;

import com.atos.profiler.model.Profil;
import com.atos.profiler.model.User;



@DtoClass(sourceClasses={Profil.class})
public class ProfilDTO {

	private Long id;
	
	
	private String name;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return this.getName();
	}
	
	
	
	
	
	
}
