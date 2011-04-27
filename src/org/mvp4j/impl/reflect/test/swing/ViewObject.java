package org.mvp4j.impl.reflect.test.swing;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.mvp4j.annotation.Action;
import org.mvp4j.annotation.MVP;
import org.mvp4j.annotation.Model;


import net.sf.classmock.ClassMock;

@MVP(modelClass =ModelObject.class, presenterClass =PresenterObject.class)
public class ViewObject {

/*	public ViewClass(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}*/
	private JButton jbutton;
	private JTextField jtextfield;
	private JComboBox jcombobox;
	private JTable jtable;
	private JCheckBox jcheckbox1;
	private JCheckBox jcheckbox2;
	private JRadioButton jradiobutton1;
	private JRadioButton jradiobutton2;
	private JLabel jlabel;
	private JList jlist;
	private JMenuItem jmenuitem;
	private JSpinner jspinner;
	
	@Action(name="buttonAction",EventType=ActionListener.class)
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
	
	@Model(property="choices",initProperty="choice1")
	public JCheckBox getJcheckbox1() {
		if(jcheckbox1==null){
			jcheckbox1=new JCheckBox("choice1");
		}
		return jcheckbox1;
	}
	public void setJcheckbox1(JCheckBox jcheckbox1) {
		this.jcheckbox1 = jcheckbox1;
	}
	
	@Model(property="choices",initProperty="choice2")
	public JCheckBox getJcheckbox2() {
		if(jcheckbox2==null){
			jcheckbox2=new JCheckBox("choice2");
		}
		return jcheckbox2;
	}
	public void setJcheckbox2(JCheckBox jcheckbox2) {
		this.jcheckbox2 = jcheckbox2;
	}
	
	
	@Model(property="choice",initProperty="initChoice1")
	public JRadioButton getJradiobutton1() {
		if(jradiobutton1==null){
			jradiobutton1=new JRadioButton("initChoice1");
		}
		return jradiobutton1;
	}
	public void setJradiobutton1(JRadioButton jradiobutton1) {
		this.jradiobutton1 = jradiobutton1;
	}
	
	@Model(property="choice" ,initProperty="initChoice2")
	public JRadioButton getJradiobutton2() {
		if(jradiobutton2==null){
			jradiobutton2=new JRadioButton("initChoice2");
		}
		return jradiobutton2;
	}
	public void setJradiobutton2(JRadioButton jradiobutton2) {
		this.jradiobutton2 = jradiobutton2;
	}
	
	@Model(property="labelValue",initProperty="labelInitValue")
	public JLabel getJlabel() {
		if(jlabel==null){
			jlabel=new JLabel();
		}
		return jlabel;
	}
	public void setJlabel(JLabel jlabel) {
		this.jlabel = jlabel;
	}
	
	@Model(property="profil",initProperty="profils")
	public JList getJlist() {
		if(jlist==null){
			jlist=new JList();
		}
		return jlist;
	}
	public void setJlist(JList jlist) {
		this.jlist = jlist;
	}
	@Action(name="menuAction")
	public JMenuItem getJmenuitem() {
		if(jmenuitem==null){
			jmenuitem=new JMenuItem();
		}
		return jmenuitem;
	}
	public void setJmenuitem(JMenuItem jmenuitem) {
		this.jmenuitem = jmenuitem;
	}
	@Model(property="profil",initProperty="profils")
	public JSpinner getJspinner() {
		if(jspinner==null){
			jspinner=new JSpinner();
		}
		return jspinner;
	}
	public void setJspinner(JSpinner jspinner) {
		this.jspinner = jspinner;
	}

	
}
