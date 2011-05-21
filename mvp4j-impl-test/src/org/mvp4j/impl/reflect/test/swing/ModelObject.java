package org.mvp4j.impl.reflect.test.swing;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.ArrayList;
import java.util.List;



public class ModelObject {


	private String name;
	private List<Object> profils;
	private Object profil;
	private String choice;
	private List<String> choices=new ArrayList<String>();
	private String choice1,choice2;
	private String initChoice1,initChoice2,labelValue,labelInitValue;
	
	public ModelObject(){
		
		
	}
	
	
	
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



	public String getChoice() {
		return choice;
	}



	public void setChoice(String choice) {
		this.choice = choice;
	}



	public List<String> getChoices() {
		return choices;
	}



	public void setChoices(List<String> choices) {
		this.choices = choices;
	}



	public String getChoice1() {
		return "choice1";
	}



	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}



	public String getChoice2() {
		return "choice2";
	}



	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}



	public String getInitChoice1() {
		return "initChoice1";
	}



	public void setInitChoice1(String initChoice1) {
		this.initChoice1 = initChoice1;
	}



	public String getInitChoice2() {
		return "initChoice2";
	}



	public void setInitChoice2(String initChoice2) {
		this.initChoice2 = initChoice2;
	}



	public String getLabelValue() {
		return "labelValue";
	}



	public void setLabelValue(String labelValue) {
		this.labelValue = labelValue;
	}



	public String getLabelInitValue() {
		return "labelInitValue";
	}



	public void setLabelInitValue(String labelInitValue) {
		this.labelInitValue = labelInitValue;
	}



	

	
	
	
	

}
