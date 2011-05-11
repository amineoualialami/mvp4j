package org.mvp4j.impl.reflect.test.swing;




import java.awt.event.FocusListener;

import java.util.ArrayList;
import java.util.List;




import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;

import javax.swing.JTextField;




import org.junit.Test;

import org.mvp4j.impl.reflect.AppControllerReflect;




import junit.framework.Assert;
import junit.framework.TestCase;

public class AppControllerReflectTest extends TestCase {
	
	public AppControllerReflect appController = new AppControllerReflect();
    
	public ViewObject view;
	public ModelObject model;
	public PresenterObject presenter;
	
	@Test
	public void testRefreshView(){
	  view=new ViewObject();
	  model=new ModelObject();
	  view=new ViewObject();
		
		class Profil{
			private String nom;
			private Integer id;
			public Profil(String nom,Integer id){
				this.nom=nom;
				this.id=id;
			}
			public String getNom() {
				return nom;
			}
			public void setNom(String nom) {
				this.nom = nom;
			}
			public Integer getId() {
				return id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			
		}
	  Profil profil=new Profil("nom",1);
	  List<Object> profils=new ArrayList<Object>();
	  profils.add(profil); 
	  Profil profil2=new Profil("nom2",2);
	  profils.add(profil2);
	  model.setProfils(profils);
	  model.setName("NewName");
	  model.setChoice("initChoice2");
	 
	  appController.bindModel(view,model);
	  model.setProfil(model.getProfils().get(1));
	  
	  appController.refreshView(view);
	  //The test established on the textfield's refresh
	 Assert.assertEquals(view.getNameTextField().getText(),model.getName());
	 //The test established on the jradiobutton's refresh 
	 Assert.assertTrue(view.getJradiobutton2().isSelected());
	 //The test established on the jcombobox's refresh
	 Assert.assertEquals(view.getProfilComboBox().getSelectedItem(),profil2);
	//The test established on the jspinner's refresh
	}
	

  @Test
	public void testBindModel(){
		
		
		model=new ModelObject();
		view=new ViewObject();
		
		class Profil{
			private String nom;
			private Integer id;
			public Profil(String nom,Integer id){
				this.nom=nom;
				this.id=id;
			}
			public String getNom() {
				return nom;
			}
			public void setNom(String nom) {
				this.nom = nom;
			}
			public Integer getId() {
				return id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			@Override
			public String toString() {
				
				return this.getNom();
			}
			
		}
		Profil profil=new Profil("nom",1);
		List<Object> profils=new ArrayList<Object>();
		profils.add(profil); 
		model.setProfils(profils);
		JTextField jtextfield=(JTextField) view.getNameTextField();

		appController.bindModel(view,model);
		
		//The test on JTextField Component
		
		
		
		JTextField jtextfield2=new JTextField();
		JFrame frame=new JFrame();
		frame.add(jtextfield);
		frame.add(jtextfield2);
		frame.setVisible(true);
		jtextfield.setText("Nom");
		jtextfield.requestFocus();
		jtextfield2.requestFocus();
		
		
		Assert.assertTrue(jtextfield.getListeners(FocusListener.class).length!=0);
		
		//this thread is defined to wait until the focus event get fired
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//The test established on JTextField binding model
		Assert.assertTrue(model.getName().equals("Nom"));
		//The test established on JCheckBox binding model
		JCheckBox jcheckbox1=(JCheckBox)view.getJcheckbox1();
		JCheckBox jcheckbox2=(JCheckBox)view.getJcheckbox2();
		jcheckbox1.doClick();
		jcheckbox2.doClick();
		List<String> checked=new ArrayList<String>();
		checked.add(jcheckbox1.getText());
		checked.add(jcheckbox2.getText());
		Assert.assertEquals(model.getChoices(),checked);
		//The test established on JRadioButton
		JRadioButton jradiobutton1=(JRadioButton)view.getJradiobutton1();
		JRadioButton jradiobutton2=(JRadioButton)view.getJradiobutton2();
		jradiobutton1.doClick();
		Assert.assertEquals(model.getChoice(),model.getInitChoice1());
		jradiobutton2.doClick();
		Assert.assertEquals(model.getChoice(),model.getInitChoice2());
		//The test established on JLabel binding model
		JLabel jlabel=(JLabel)view.getJlabel();
		Assert.assertEquals(jlabel.getText(),model.getLabelInitValue());
		//The test established on JList binding model
		JList jlist=(JList)view.getJlist();
		Assert.assertTrue(jlist.getVisibleRowCount()!=0);		
		// The test established  on JTable binding model
		JTable jtable=(JTable)view.getTable();
		Assert.assertTrue(view.getTable().getRowCount()==1);
		//The test established on JSpinner binding model
		JSpinner jspinner=view.getJspinner();
		Assert.assertEquals(jspinner.getValue(),model.getProfils().get(0));
		// The test established  on JComboBox binding model
		JComboBox jcombobox=(JComboBox)view.getProfilComboBox();
	    Assert.assertTrue(view.getProfilComboBox().getItemCount()==1);
		
		
		
	}
	
	@Test
	public void testBindPresenter(){
	
		presenter=new PresenterObject();
		model=new ModelObject();
	    ViewObject view=new ViewObject();
		appController.bindPresenter(view, presenter);
		//The test on JButton binding with the presenter
		JButton okButton=view.getOkButton();	
		Assert.assertTrue(okButton.getActionListeners().length!=0);		 	 
		okButton.doClick();
		//The test on JmenuItem binding with the presenter
		JMenuItem menuItem=view.getJmenuitem();
		Assert.assertTrue(menuItem.getActionListeners().length!=0);
        menuItem.doClick();
	}
	
	

	
}
