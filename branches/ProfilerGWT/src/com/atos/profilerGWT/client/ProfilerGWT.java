package com.atos.profilerGWT.client;




import java.util.ArrayList;
import java.util.List;

import com.atos.profilerGWT.client.model.UserModel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.ui.AbsolutePanel;



import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProfilerGWT implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */


	private AbsolutePanel formulairePanel;
	private TextBox name,mail,phone;
	private Label nameLabel,mailLabel,phoneLabel,listProfilsLabel;
    private ListBox listProfils;
	private FlexTable tableRows;
	private List<UserModel> listUsers;
	
	private Button ajouterButton;
	
	public void onModuleLoad() {
		
		Window.setMargin("300px");
	
		
		
		RootPanel.get().add(getFormulairePanel());

	}

	
	
	
	
	
	public AbsolutePanel getFormulairePanel() {
		if(formulairePanel==null){
			formulairePanel=new AbsolutePanel();
			formulairePanel.setSize("700px","700px");
			formulairePanel.add(getNameLabel(),0,0);
			formulairePanel.add(getName(), 50,0);
			formulairePanel.add(getListProfilsLabel(),0,50);
			formulairePanel.add(getListProfils(),50,50);
			formulairePanel.add(getPhoneLabel(),0,100);
			formulairePanel.add(getPhone(),50,100);
			formulairePanel.add(getMailLabel(),0,150);
			formulairePanel.add(getMail(),50,150);
			formulairePanel.add(getAjouterButton(),50,200);
			formulairePanel.add(getVerticalPanel(),300,0);
			
		}
			return formulairePanel;
		
	}

	public TextBox getName() {
		if(name==null){
			name=new TextBox();
		}
		return name;
	}

	public TextBox getMail() {
		if(mail==null){
			mail=new TextBox();
			getFormulairePanel().add(nameLabel,0,0);
		}
		return mail;
	}

	public TextBox getPhone() {
		if(phone==null){
			phone=new TextBox();
		}
		return phone;
	}

	public Label getNameLabel() {
		if(nameLabel==null){
			nameLabel=new Label("Nom:");
			
		}
		return nameLabel;
	}

	public Label getMailLabel() {
		if(mailLabel==null){
			mailLabel=new Label("Mail:");
		
		}
		return mailLabel;
	}

	public Label getPhoneLabel() {
		if(phoneLabel==null){
			phoneLabel=new Label("Phone:");
		
		}
		return phoneLabel;
	}

	
	
	public Button getAjouterButton() {
		if(ajouterButton==null){
			ajouterButton=new Button();
			ajouterButton.setTitle("Ajouter Utilisateur");
			ajouterButton.setText("Ajouter");
			ajouterButton.setSize("100px","30px");
		}
		ajouterButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			UserModel userModel=new UserModel();
			userModel.setNom(getName().getText());
			userModel.setMail(getMail().getText());
			userModel.setPhone(Integer.parseInt(getPhone().getText()));
		    userModel.setProfil(getListProfils().getItemText(getListProfils().getSelectedIndex()));
		    getListUsers().add(userModel);
		    initTableValues();
		    
				
			}
		});
		return ajouterButton;
	}






	public Label getListProfilsLabel() {
		if(listProfilsLabel==null){
			listProfilsLabel=new Label("Profil:");
			
		}
		return listProfilsLabel;
	}






	public ListBox getListProfils() {
		if(listProfils==null){
			listProfils=new ListBox();
			listProfils.addItem("Profil 1");
			listProfils.addItem("Profil 2");
			listProfils.setWidth("170px");
			listProfils.addChangeHandler(new ChangeHandler() {
				
				@Override
				public void onChange(ChangeEvent event) {
					Window.alert("Vous avez choisis : "+listProfils.getItemText(listProfils.getSelectedIndex()));
					
				}
			});
		}
		return listProfils;
	}






	public FlexTable getTableRows() {
		if(tableRows==null){
			tableRows=new FlexTable();
			tableRows.setWidth("400px");
			tableRows.setBorderWidth(2);
			tableRows.getColumnFormatter().setWidth(0,"100px");
			tableRows.getColumnFormatter().setWidth(1,"100px");
			tableRows.getColumnFormatter().setWidth(2,"100px");
			tableRows.getColumnFormatter().setWidth(3,"100px");
			
			 
		}
		return tableRows;
	}

	public FlexTable getTableColumns(){	
		FlexTable tableColumns=new FlexTable();
		tableColumns.setTitle("Table d'utilisateurs");
		tableColumns.setWidth("400");
		
		tableColumns.setBorderWidth(2);
		tableColumns.setText(0,0,"Nom");
		tableColumns.getColumnFormatter().setWidth(0,"100px");
		tableColumns.setText(0,1,"Profil");
		tableColumns.getColumnFormatter().setWidth(1,"100px");
		tableColumns.setText(0,2,"Phone");
		tableColumns.getColumnFormatter().setWidth(2,"100px");
		tableColumns.setText(0,3,"Mail");
		tableColumns.getColumnFormatter().setWidth(3,"100px");
		
		
		
		
		return tableColumns;
	}
	public ScrollPanel getScrollPane(){
		ScrollPanel scrollPanel=new ScrollPanel(getTableRows());
		scrollPanel.setWidth("400px");
		scrollPanel.setHeight("400px");
		return scrollPanel;
	}

	public VerticalPanel getVerticalPanel(){
		VerticalPanel verticalPanel=new VerticalPanel();
		verticalPanel.setSize("400","400");
		verticalPanel.setSpacing(0);
		verticalPanel.add(getTableColumns());
		verticalPanel.add(getScrollPane());
		return verticalPanel;
	}

	public List<UserModel> getListUsers() {
		if(listUsers==null){
			listUsers=new ArrayList<UserModel>();
		}
		return listUsers;
	}
	
	public void initTableValues(){
		int i=1;
		for (UserModel userModel :listUsers) {
			getTableRows().setText(i,0,userModel.getNom());
			getTableRows().setText(i, 1,userModel.getProfil());
			getTableRows().setText(i, 2,userModel.getPhone()+"");
			getTableRows().setText(i, 3, userModel.getMail());
			i++;
		}
	}
}
