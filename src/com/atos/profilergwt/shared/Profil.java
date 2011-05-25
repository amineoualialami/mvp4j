package com.atos.profilergwt.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Profil implements Serializable, IsSerializable {

	private long id;

	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
