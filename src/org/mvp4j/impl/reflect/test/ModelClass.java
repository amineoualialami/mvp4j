package org.mvp4j.impl.reflect.test;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.sf.classmock.ClassMock;

public class ModelClass {


	private String name;
	private List<Object> profils;
	private Object profil;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Object> getProfils() {
	//	profils= new ArrayList<Object>();
		
		return profils;
	}

	public void setProfils(List<Object> profils) {
		this.profils = profils;
	}

	public Object getProfil() {
		return profil;
	}

	public void setProfil(Object profil) {
		this.profil = profil;
	}

	
	
	
	

}
