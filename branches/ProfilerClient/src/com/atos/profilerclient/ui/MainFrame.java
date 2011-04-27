package com.atos.profilerclient.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import org.kahvi.paketti.dtobuilder.DtoBuilder;
import org.kahvi.paketti.dtobuilder.DtoConfigurationException;
import org.kahvi.paketti.dtobuilder.DtoDismantler;

import com.atos.profilerclient.dao.UserSessionDAO;
import com.atos.profilerclient.dao.UserSessionDAOImpl;
import com.atos.profilerclient.dto.UserDTO;
import com.atos.profilerclient.locator.ServiceLocator;
import com.atos.profilerclient.ui.model.UserModel;

public class MainFrame extends JFrame {

	JPanel panel1;
	JPanel panel2;
	JPanel buttonPanel;
	JButton okButton, delButton, editButton, clearButton;
	JTextField nameTextField, mailTextField, telTextField;
	JLabel nameLabel, mailLabel, telLabel, profilLabel;
	JComboBox profilComboBox;
	SpringLayout springLayout;
	UserSessionDAO userSession = new UserSessionDAOImpl();
	JTable table;
	DefaultTableModel model;
	JScrollPane scrollPane;
	DtoDismantler<UserModel, UserDTO> userDTODismantler;
	DtoBuilder<UserModel> userDTOBuilder;

	public MainFrame() {

		setTitle("Profiler Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JPanel());
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		add(getPanel1());
		add(getPanel2());
		add(getButtonPanel());

	}

	// =========== GETTERS and SETTERS (JPanel)============

	public JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setLayout(null);
			panel1.setBounds(490, 20, 500, 500);

			panel1.add(getScrollPane());

		}
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JPanel getPanel2() {
		if (panel2 == null) {
			panel2 = new JPanel();
			panel2.setLayout(null);
			panel2.setBounds(50, 150, 300, 300);

			panel2.add(getNameLabel());
			panel2.add(getNameTextField());

			panel2.add(getProfilLabel());
			panel2.add(getProfilComboBox());

			panel2.add(getMailLabel());
			panel2.add(getMailTextField());

			panel2.add(getTelLabel());
			panel2.add(getTelTextField());

		}

		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.setLayout(null);
			buttonPanel.setBounds(10, 510, 950, 100);

			buttonPanel.add(getOkButton());
			buttonPanel.add(getClearButton());
			buttonPanel.add(getDelButton());
			buttonPanel.add(getEditButton());
		}
		return buttonPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	// =========== GETTERS and SETTERS (JButton)============

	
	public JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton("OK");
			okButton.setBounds(10, 10, 70, 40);
		
			okButton.addActionListener(new ActionListener() {

			
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						System.out.println("OkButton");
						UserModel userModel = new UserModel();
						userModel.setName(getNameTextField().getText());
						userModel.setMail(getMailTextField().getText());
						userModel.setPhone(Integer.parseInt(getTelTextField()
								.getText()));
						System.out.println("------------"+userModel.getName());
						// String profilName = (String) getProfilComboBox()
						// .getSelectedItem();
						// user.setProfil(getUserSession().getProfilByName(profilName));
						if (table.getSelectedRow() != -1) {

							String idString = (String) model.getValueAt(
									table.getSelectedRow(), 0);

							long id = Long.parseLong(idString);

							UserDTO userDTO = userSession.findUser(id);
							if (userDTO == null) {
								UserDTO userDTO1;
								userDTO1 = getUserDTODismantler().dismantle(
										userModel);
								userDTO1.setPhone(Integer.parseInt(getTelTextField()
										.getText()));
								userSession.addUser(userDTO1);
							} else {
								userModel.setIdUser(id);
								UserDTO userDTO2 = getUserDTODismantler()
										.dismantle(userModel);
								userDTO2.setIdUser(id);
								userDTO2.setPhone(Integer.parseInt(getTelTextField()
								.getText()));
								userSession.updateUser(userDTO2);
							}

						} else {
							UserDTO userDTO2 = getUserDTODismantler()
									.dismantle(userModel);
							userDTO2.setPhone(Integer.parseInt(getTelTextField()
									.getText()));
							userSession.addUser(userDTO2);
						}
						refreshTable();
						getNameTextField().setText("");
						getTelTextField().setText("");
						getMailTextField().setText("");
						//getProfilComboBox().setSelectedIndex(0);
					} catch (DtoConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});
		}
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	
	public JButton getDelButton() {
		if (delButton == null) {
			delButton = new JButton("Delete");
			delButton.setBounds(850, 10, 70, 40);
			delButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("DelButtton");
					table.getSelectedRow();
					String idString = (String) model.getValueAt(
							table.getSelectedRow(), 0);
					userSession.deleteUser(Long.parseLong(idString));
					refreshTable();

				}
			});
		}

		return delButton;
	}

	public void setDelButton(JButton delButton) {
		this.delButton = delButton;
	}

	public JButton getEditButton() {
		if (editButton == null) {
			editButton = new JButton("Edit");
			editButton.setBounds(770, 10, 70, 40);
			editButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						System.out.println("EditButton");
						table.getSelectedRow();
						String idString = (String) model.getValueAt(
								table.getSelectedRow(), 0);

						UserDTO userDTO = userSession.findUser(Long
								.parseLong(idString));
						UserModel userModel;

						userModel = getUserDTOBuilder().build(userDTO);

						getNameTextField().setText(userModel.getName());
						getTelTextField().setText(userModel.getPhone() + "");
						getMailTextField().setText(userModel.getMail());
						// getProfilComboBox().setSelectedIndex(
						// Integer.parseInt((userModel.getProfil().getId() - 1)
						// + ""));

					} catch (DtoConfigurationException e1) {
						e1.printStackTrace();
					}
				}

			});
		}
		return editButton;
	}

	public void setEditButton(JButton editButton) {
		this.editButton = editButton;
	}

	public JButton getClearButton() {
		if (clearButton == null) {
			clearButton = new JButton("Clear");
			System.out.println(clearButton);
			clearButton.setBounds(90, 10, 70, 40);
			clearButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("clearButton");
					getNameTextField().setText("");
					getTelTextField().setText("");
					getMailTextField().setText("");
					getProfilComboBox().setSelectedIndex(0);

				}
			});
		}
		return clearButton;
	}

	public void setClearButton(JButton clearButton) {
		this.clearButton = clearButton;
	}

	// =========== GETTERS and SETTERS (JTextField)============

	public JTextField getNameTextField() {
		if (nameTextField == null) {
			nameTextField = new JTextField();
			nameTextField.setBounds(70, 20, 150, 30);

		}
		return nameTextField;
	}

	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}

	public JTextField getMailTextField() {
		if (mailTextField == null) {
			mailTextField = new JTextField();
			mailTextField.setBounds(70, 100, 150, 30);
		}
		return mailTextField;
	}

	public void setMailTextField(JTextField mailTextField) {
		this.mailTextField = mailTextField;
	}

	// @Model("tel")
	public JTextField getTelTextField() {
		if (telTextField == null) {
			telTextField = new JTextField();
			telTextField.setName("tel");
			telTextField.setBounds(70, 150, 150, 30);

		}
		return telTextField;
	}

	public void setTelTextField(JTextField telTextField) {
		this.telTextField = telTextField;
	}

	// =========== GETTERS and SETTERS (JLabel)============

	public JLabel getNameLabel() {
		if (nameLabel == null) {
			nameLabel = new JLabel("Name :");
			nameLabel.setBounds(10, 10, 50, 50);
		}
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getMailLabel() {
		if (mailLabel == null) {
			mailLabel = new JLabel("E-Mail :");
			mailLabel.setBounds(10, 90, 50, 50);
		}
		return mailLabel;
	}

	public void setMailLabel(JLabel mailLabel) {
		this.mailLabel = mailLabel;
	}

	public JLabel getTelLabel() {
		if (telLabel == null) {
			telLabel = new JLabel("Tel :");
			telLabel.setBounds(10, 140, 50, 50);
		}
		return telLabel;
	}

	public void setTelLabel(JLabel telLabel) {
		this.telLabel = telLabel;
	}

	public JLabel getProfilLabel() {
		if (profilLabel == null) {
			profilLabel = new JLabel("Profil :");
			profilLabel.setBounds(10, 50, 50, 50);
		}
		return profilLabel;
	}

	public void setProfilLabel(JLabel profilLabel) {
		this.profilLabel = profilLabel;
	}

	// =========== GETTERS and SETTERS (JComboBox)============

	public JComboBox getProfilComboBox() {
		if (profilComboBox == null) {
			profilComboBox = new JComboBox();
			profilComboBox.setBounds(70, 60, 150, 30);

			// List<Profil> profils = userSession.loadAllProfil();
			//
			// for (Profil p : profils) {
			// profilComboBox.addItem(p.getName());
			// }

		}
		return profilComboBox;
	}

	public void setProfilComboBox(JComboBox profilComboBox) {
		this.profilComboBox = profilComboBox;
	}

	public JScrollPane getScrollPane() {

		table = new JTable(getModel());

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 450, 450);
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public DefaultTableModel getModel() {
		try {
			String[] entetes = { "Id", "Name", "Mail", "Phone", "Profil" };
			// List<User> users = getUserSession().loadAll();
			List<UserDTO> listUsersDTO = userSession.getAllUsers();
			List<UserModel> listUsersModel = new ArrayList<UserModel>();
			for (UserDTO userDTO : listUsersDTO) {
                UserModel userModel = getUserDTOBuilder().build(userDTO);
                listUsersModel.add(userModel);
			}

			String[][] data = { { "", "", "", "", "" } };
			model = new DefaultTableModel(data, entetes);

			for (int i = 0; i < listUsersModel.size(); i++) {

				model.insertRow(i, new Object[] {
						listUsersModel.get(i).getIdUser() + "",
						listUsersModel.get(i).getName(),
						listUsersModel.get(i).getMail(),
						listUsersModel.get(i).getPhone() + "", ""

				});
			}
		} catch (DtoConfigurationException e) {
			e.printStackTrace();
		}

		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public void refreshTable() {
		table.setModel(getModel());

	}

	public DtoDismantler<UserModel, UserDTO> getUserDTODismantler() {
		if (userDTODismantler == null) {
			userDTODismantler = new DtoDismantler<UserModel, UserDTO>(
					UserModel.class, UserDTO.class);
		}
		return userDTODismantler;
	}

	public DtoBuilder<UserModel> getUserDTOBuilder() {
		if (userDTOBuilder == null) {
			userDTOBuilder = new DtoBuilder<UserModel>(UserModel.class);
		}
		return userDTOBuilder;
	}

}
