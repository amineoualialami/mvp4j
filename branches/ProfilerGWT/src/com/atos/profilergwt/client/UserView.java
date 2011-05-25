package com.atos.profilergwt.client;

import java.util.ArrayList;
import java.util.List;

import org.mvp4j.annotation.MVP;

import com.atos.profilergwt.client.model.UserModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtent.reflection.client.Reflection;

@MVP(modelClass =UserView.class, presenterClass = UserView.class)
public class UserView implements Reflection{
	private ServiceDefTarget endpoint;
	private UserListServiceAsync userService;
	private AbsolutePanel formulairePanel;
	private TextBox name,mail,phone;
	private Label nameLabel,mailLabel,phoneLabel,listProfilsLabel;
    private ListBox listProfils;
	private FlexTable tableRows;
	private List<UserModel> listUsers;
	private Button ajouterButton;
	
	public UserView(){
		
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

		userService=(UserListServiceAsync)GWT.create(UserListService.class);
		endpoint=(ServiceDefTarget)userService;
		
		String moduleRelativeURL = GWT.getModuleBaseURL() + "user";
		endpoint.setServiceEntryPoint(moduleRelativeURL);
		 AsyncCallback callback=new AsyncCallback() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Failure");
					
				}

				@Override
				public void onSuccess(Object result) {
					Window.alert("Success");
					
				}
		    	
			};
			userService.initProfils(callback);
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
			formulairePanel.add(nameLabel,0,0);
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
			userModel.setName(getName().getText());
			userModel.setMail(getMail().getText());
			userModel.setPhone(Integer.parseInt(getPhone().getText()));
		    userModel.setProfil(getListProfils().getItemText(getListProfils().getSelectedIndex()));
		    getListUsers().add(userModel);
		    initTableValues();
		   
		   /* AsyncCallback callback = new AsyncCallback() {
		    	public void onSuccess(Object result) {
		    	
		    	}
		    	public void onFailure(Throwable caught) {
		    	// do some UI stuff to show failure
		    	}
		    	};
		    userService.addUser(userModel, callback);*/
				
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
			listProfils.setWidth("170px");
			listProfils.addItem("Profil 1");
			listProfils.addItem("Profil 2");
			/*AsyncCallback callback = new AsyncCallback() {
		    	public void onSuccess(Object result) {
		    	Window.alert("Service is successfuly invoked");
		    	}
		    	public void onFailure(Throwable caught) {
		    	System.out.println("connexion failure");
		    	}
		    	};
		    	userService.initProfils(callback);*/
		    	
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
			getTableRows().
			setText(i,0,userModel.getName());
			getTableRows().setText(i, 1,userModel.getProfil());
			getTableRows().setText(i, 2,userModel.getPhone()+"");
			getTableRows().setText(i, 3, userModel.getMail());
			i++;
		}
	}

	public AbsolutePanel getFormulairePanel() {
		
		return formulairePanel;
	}

	public void setFormulairePanel(AbsolutePanel formulairePanel) {
		this.formulairePanel = formulairePanel;
	}
	public void test(){
		System.out.println("Decollage reussit");
	}
}
