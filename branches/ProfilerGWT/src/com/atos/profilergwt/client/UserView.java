package com.atos.profilergwt.client;

import java.util.List;

import org.mvp4j.annotation.Action;
import org.mvp4j.annotation.MVP;
import org.mvp4j.annotation.Model;

import com.atos.profilergwt.client.model.UserModel;
import com.atos.profilergwt.client.presenter.UserPresenter;
import com.atos.profilergwt.shared.Profil;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
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

@MVP(modelClass = UserModel.class, presenterClass = UserPresenter.class)
public class UserView implements Reflection {
	private AbsolutePanel formulairePanel;

	@Model(property = "name")
	private TextBox nameTextBox;

	@Model(property = "mail")
	private TextBox mailTextBox;

	@Model(property = "phone")
	private TextBox phoneTextBox;
	
	private Label nameLabel, mailLabel, phoneLabel, listBoxProfilsLabel;
	
	private ListBox profilsListBox;
	
	private FlexTable flexTable;

	@Action(name = "action1")
	private Button ajouterButton;

	public UserView() {

		formulairePanel = new AbsolutePanel();
		formulairePanel.setSize("700px", "700px");
		formulairePanel.add(getNameLabel(), 0, 0);
		formulairePanel.add(getNameTextBox(), 50, 0);
		formulairePanel.add(getlistBoxProfilsLabel(), 0, 50);
		formulairePanel.add(getProfilsListBox(), 50, 50);
		formulairePanel.add(getPhoneLabel(), 0, 100);
		formulairePanel.add(getPhoneTextBox(), 50, 100);
		formulairePanel.add(getMailLabel(), 0, 150);
		formulairePanel.add(getMailTextBox(), 50, 150);
		formulairePanel.add(getAjouterButton(), 50, 200);
		formulairePanel.add(getVerticalPanel(), 300, 0);

	}
	
	public TextBox getNameTextBox() {
		if (nameTextBox == null) {
			nameTextBox = new TextBox();
		}
		return nameTextBox;
	}

	public TextBox getMailTextBox() {
		if (mailTextBox == null) {
			mailTextBox = new TextBox();
			formulairePanel.add(nameLabel, 0, 0);
		}
		return mailTextBox;
	}

	public TextBox getPhoneTextBox() {
		if (phoneTextBox == null) {
			phoneTextBox = new TextBox();
		}
		return phoneTextBox;
	}


	public ListBox getProfilsListBox() {
		if (profilsListBox == null) {
			profilsListBox = new ListBox();
			profilsListBox.setWidth("170px");
			AsyncCallback callback = new AsyncCallback() {
				public void onSuccess(Object result) {
					List<Profil> listProfils = (List<Profil>) result;
					for (Profil profil : listProfils) {
						profilsListBox.addItem(profil.toString());
					}
				}

				public void onFailure(Throwable caught) {
					// do some UI stuff to show failure
				}
			};

			getService().getProfils(callback);

			profilsListBox.addChangeHandler(new ChangeHandler() {

				@Override
				public void onChange(ChangeEvent event) {
					Window.alert("Vous avez choisis : "
							+ profilsListBox.getItemText(profilsListBox
									.getSelectedIndex()));

				}
			});
		}
		return profilsListBox;
	}

	public FlexTable getFlexTable() {
		if (flexTable == null) {
			flexTable = new FlexTable();
			flexTable.setWidth("400px");
			flexTable.setBorderWidth(2);
			flexTable.getColumnFormatter().setWidth(0, "100px");
			flexTable.getColumnFormatter().setWidth(1, "100px");
			flexTable.getColumnFormatter().setWidth(2, "100px");
			flexTable.getColumnFormatter().setWidth(3, "100px");

		}
		return flexTable;
	}



	public Label getNameLabel() {
		if (nameLabel == null) {
			nameLabel = new Label("Nom:");

		}
		return nameLabel;
	}

	public Label getMailLabel() {
		if (mailLabel == null) {
			mailLabel = new Label("Mail:");

		}
		return mailLabel;
	}

	public Label getPhoneLabel() {
		if (phoneLabel == null) {
			phoneLabel = new Label("Phone:");

		}
		return phoneLabel;
	}

	public Button getAjouterButton() {
		if (ajouterButton == null) {
			ajouterButton = new Button();
			ajouterButton.setTitle("Ajouter Utilisateur");
			ajouterButton.setText("Ajouter");
			ajouterButton.setSize("100px", "30px");
		}
		return ajouterButton;
	}

	public Label getlistBoxProfilsLabel() {
		if (listBoxProfilsLabel == null) {
			listBoxProfilsLabel = new Label("Profil:");

		}
		return listBoxProfilsLabel;
	}



	public FlexTable getTableColumns() {
		FlexTable tableColumns = new FlexTable();
		tableColumns.setTitle("Table d'utilisateurs");
		tableColumns.setWidth("400");

		tableColumns.setBorderWidth(2);
		tableColumns.setText(0, 0, "Nom");
		tableColumns.getColumnFormatter().setWidth(0, "100px");
		tableColumns.setText(0, 1, "Profil");
		tableColumns.getColumnFormatter().setWidth(1, "100px");
		tableColumns.setText(0, 2, "Phone");
		tableColumns.getColumnFormatter().setWidth(2, "100px");
		tableColumns.setText(0, 3, "Mail");
		tableColumns.getColumnFormatter().setWidth(3, "100px");

		return tableColumns;
	}

	public ScrollPanel getScrollPane() {
		ScrollPanel scrollPanel = new ScrollPanel(getFlexTable());
		scrollPanel.setWidth("400px");
		scrollPanel.setHeight("400px");
		return scrollPanel;
	}

	public VerticalPanel getVerticalPanel() {
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSize("400", "400");
		verticalPanel.setSpacing(0);
		verticalPanel.add(getTableColumns());
		verticalPanel.add(getScrollPane());
		return verticalPanel;
	}

	
	

	public AbsolutePanel getFormulairePanel() {
		return formulairePanel;
	}

	public void setFormulairePanel(AbsolutePanel formulairePanel) {
		this.formulairePanel = formulairePanel;
	}


	public static UserServicesAsync getService() {
		UserServicesAsync service = (UserServicesAsync) GWT
				.create(UserServices.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) service;
		String moduleRelativeURL = GWT.getModuleBaseURL() + "user";
		endpoint.setServiceEntryPoint(moduleRelativeURL);
		return service;
	}

	
	
	
}
