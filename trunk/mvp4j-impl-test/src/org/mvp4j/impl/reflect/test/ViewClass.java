package org.mvp4j.impl.reflect.test;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.mvp4j.annotation.Action;
import org.mvp4j.annotation.MVP;
import org.mvp4j.annotation.Model;

import net.sf.classmock.ClassMock;

@MVP(modelClass =ModelClass.class, presenterClass =PresenterClass.class)
public class ViewClass {

/*	public ViewClass(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}*/
	private JButton jbutton;
	private JTextField jtextfield;
	private JComboBox jcombobox;
	private JTable jtable;
	
	@Action(name="addUser",EventType=ActionListener.class)
	public JButton getOkButton() {
		if(jbutton==null){
	 jbutton = new JButton("OK");
		}
		return jbutton;
	}
	@Model(property="name")
	public JTextField getNameTextField() {
		if(jtextfield==null){
	   jtextfield = new JTextField();
		}
		return jtextfield;
	}
	
	@Model(property="profil",initProperty="profils")
	public JComboBox getProfilComboBox() {
		if(jcombobox==null){
		jcombobox = new JComboBox();}
		return jcombobox;
	}
	@Model(initProperty="profils" ,property="")
	public JTable getTable() {
		if(jtable==null){
		jtable = new JTable();
		}
		return jtable;
	}

}
