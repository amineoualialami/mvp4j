package com.atos.profilergwt.client;

import java.util.ArrayList;
import java.util.List;

import org.mvp4j.annotation.MVP;

import com.atos.profilergwt.client.model.UserModel;
import com.atos.profilergwt.shared.Profil;
import com.atos.profilergwt.shared.User;
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

@MVP(modelClass = UserView.class, presenterClass = UserView.class)
public class UserView implements Reflection {
	private AbsolutePanel formulairePanel;
	private TextBox name, mail, phone;
	private Label nameLabel, mailLabel, phoneLabel, listBoxProfilsLabel;
	private ListBox listBoxProfils;
	private FlexTable tableRows;
	private Button ajouterButton;

	public UserView() {

		formulairePanel = new AbsolutePanel();
		formulairePanel.setSize("700px", "700px");
		formulairePanel.add(getNameLabel(), 0, 0);
		formulairePanel.add(getName(), 50, 0);
		formulairePanel.add(getlistBoxProfilsLabel(), 0, 50);
		formulairePanel.add(getlistBoxProfils(), 50, 50);
		formulairePanel.add(getPhoneLabel(), 0, 100);
		formulairePanel.add(getPhone(), 50, 100);
		formulairePanel.add(getMailLabel(), 0, 150);
		formulairePanel.add(getMail(), 50, 150);
		formulairePanel.add(getAjouterButton(), 50, 200);
		formulairePanel.add(getVerticalPanel(), 300, 0);

	}

	public TextBox getName() {
		if (name == null) {
			name = new TextBox();
		}
		return name;
	}

	public TextBox getMail() {
		if (mail == null) {
			mail = new TextBox();
			formulairePanel.add(nameLabel, 0, 0);
		}
		return mail;
	}

	public TextBox getPhone() {
		if (phone == null) {
			phone = new TextBox();
		}
		return phone;
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
		ajouterButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				final User user = new User();
				
				AsyncCallback callback = new AsyncCallback() {
					public void onSuccess(Object result) {
						initTableValues();
					}

					public void onFailure(Throwable caught) {
					}
				};
				
				AsyncCallback callback2 = new AsyncCallback() {
					public void onSuccess(Object result) {
						user.setProfil((Profil) result);
					}

					public void onFailure(Throwable caught) {
					}
				};
				
				
				user.setName(getName().getText());
				user.setPhone(Integer.parseInt(getPhone().getText()));
				user.setMail(getMail().getText());
				
				getService().getProfilByName(
						getlistBoxProfils().getItemText(
								getlistBoxProfils().getSelectedIndex()),
						callback2);
				
				getService().addUser(user, callback);


				

				

				

			}
		});
		return ajouterButton;
	}

	public Label getlistBoxProfilsLabel() {
		if (listBoxProfilsLabel == null) {
			listBoxProfilsLabel = new Label("Profil:");

		}
		return listBoxProfilsLabel;
	}

	public ListBox getlistBoxProfils() {
		if (listBoxProfils == null) {
			listBoxProfils = new ListBox();
			listBoxProfils.setWidth("170px");
			AsyncCallback callback = new AsyncCallback() {
				public void onSuccess(Object result) {
					List<Profil> listProfils = (List<Profil>) result;
					for (Profil profil : listProfils) {
						listBoxProfils.addItem(profil.toString());
					}
				}

				public void onFailure(Throwable caught) {
					// do some UI stuff to show failure
				}
			};

			getService().getProfils(callback);

			listBoxProfils.addChangeHandler(new ChangeHandler() {

				@Override
				public void onChange(ChangeEvent event) {
					Window.alert("Vous avez choisis : "
							+ listBoxProfils.getItemText(listBoxProfils
									.getSelectedIndex()));

				}
			});
		}
		return listBoxProfils;
	}

	public FlexTable getTableRows() {
		if (tableRows == null) {
			tableRows = new FlexTable();
			tableRows.setWidth("400px");
			tableRows.setBorderWidth(2);
			tableRows.getColumnFormatter().setWidth(0, "100px");
			tableRows.getColumnFormatter().setWidth(1, "100px");
			tableRows.getColumnFormatter().setWidth(2, "100px");
			tableRows.getColumnFormatter().setWidth(3, "100px");

		}
		return tableRows;
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
		ScrollPanel scrollPanel = new ScrollPanel(getTableRows());
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

	public void initTableValues() {

		AsyncCallback callback = new AsyncCallback() {
			public void onSuccess(Object result) {
				List<User> listUsers = (List<User>) result;
				int i = 1;
				for (User user : listUsers) {
					getTableRows().setText(i, 0, user.getName());
//					getTableRows().setText(i, 1, user.getProfil().toString());
					getTableRows().setText(i, 2, user.getPhone() + "");
					getTableRows().setText(i, 3, user.getMail());
					i++;
				}
			}

			public void onFailure(Throwable caught) {
				// do some UI stuff to show failure
			}
		};
		getService().getUsers(callback);

	}

	public AbsolutePanel getFormulairePanel() {

		return formulairePanel;
	}

	public void setFormulairePanel(AbsolutePanel formulairePanel) {
		this.formulairePanel = formulairePanel;
	}

	public void test() {
		System.out.println("Decollage reussit");
	}

	public static UserServicesAsync getService() {
		// Create the client proxy. Note that although you are creating the
		// service interface proper, you cast the result to the asynchronous
		// version of
		// the interface. The cast is always safe because the generated proxy
		// implements the asynchronous interface automatically.
		UserServicesAsync service = (UserServicesAsync) GWT
				.create(UserServices.class);
		// Specify the URL at which our service implementation is running.
		// Note that the target URL must reside on the same domain and port from
		// which the host page was served.
		//
		ServiceDefTarget endpoint = (ServiceDefTarget) service;
		String moduleRelativeURL = GWT.getModuleBaseURL() + "user";
		endpoint.setServiceEntryPoint(moduleRelativeURL);
		return service;
	}
}
