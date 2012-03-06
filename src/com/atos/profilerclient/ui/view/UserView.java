package com.atos.profilerclient.ui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.kahvi.paketti.dtobuilder.DtoBuilder;
import org.kahvi.paketti.dtobuilder.DtoDismantler;
import org.mvp4j.adapter.EventAction;
import org.mvp4j.annotation.Action;
import org.mvp4j.annotation.Actions;
import org.mvp4j.annotation.MVP;
import org.mvp4j.annotation.Model;

import com.atos.profilerclient.dto.UserDTO;
import com.atos.profilerclient.ui.model.UserModel;
import com.atos.profilerclient.ui.presenter.UserPresenter;

@MVP(modelClass = UserModel.class, presenterClass = UserPresenter.class)
public class UserView extends JFrame {

	JPanel panel1;
	JPanel panel2;
	JPanel buttonPanel;
	
	@Action(name = "addUser" , EventType=ActionListener.class)
	JButton okButton;
	
	@Action(name = "removeUser")
	JButton delButton;
	
	@Action(name = "editUser")
	JButton editButton;
	
	@Actions( { @Action(name="clear"), @Action(name="toto"), @Action(name="tata") })
	JButton clearButton;
	
	@Model(property = "name")
	JTextField nameTextField;
	
	@Model(property = "mail")
	JTextField mailTextField;
	
	@Model(property = "phone")
	JTextField telTextField;
	
	@Model(property="date")
	JTextField dateTextField;
	
	JPasswordField namePasswordField;
	JLabel nameLabel, mailLabel, telLabel, profilLabel,dateLabel;
	
	@Model(property = "profil", initProperty = "profils")
	JComboBox profilComboBox;
	
	SpringLayout springLayout;

	@Model(initProperty = "users", property = "user")
//	@Action(name="edit" , EventType=MouseListener.class , EventAction="mousePressed" )
	JTable table;
	
	JScrollPane scrollPane;

	//@Model(property="profils2", initProperty="profil1")
	JCheckBox profilCheckBox1;
	
	//@Model(property="profils2", initProperty="profil2")
	JCheckBox profilCheckBox2;

	DtoDismantler<UserModel, UserDTO> userDTODismantler;
	DtoBuilder<UserModel> userDTOBuilder;

	ButtonGroup buttonGroup;
	//@Model(property="profil", initProperty="profil1")
	JRadioButton profilRadioButton1 ;
	
	//@Model(property="profil" , initProperty="profil2" )
	JRadioButton profilRadioButton2 ;
	
	@Model(initProperty="users", property="user")
	JList list;
	
	JMenuBar menuBar;
	JMenu menu;
	@Action(name = "actionMenu1")
	JMenuItem menuItem1;
	
	@Action(name = "actionMenu2")
	JMenuItem menuItem2;

	public UserView() {

		setTitle("Profiler Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JPanel());
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		add(getPanel1());
		add(getPanel2());
		add(getButtonPanel());
		menu = new JMenu("Menu");
		menu.add(getMenuItem1());
		menu.add(getMenuItem2());
		menuBar = new JMenuBar();
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		
		

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
			panel2.setBounds(50, 70, 400, 400);

			panel2.add(getNameLabel());
			panel2.add(getNameTextField());

			panel2.add(getProfilLabel());
			panel2.add(getProfilComboBox());

			panel2.add(getMailLabel());
			panel2.add(getMailTextField());

			panel2.add(getTelLabel());
			panel2.add(getTelTextField());
			
			panel2.add(getDateLabel());
			panel2.add(getDateTextField());

			getButtonGroup();

//			panel2.add(getProfilRadioButton1());
//			panel2.add(getProfilRadioButton2());
//			
//			panel2.add(getProfilCheckBox1());
//			panel2.add(getProfilCheckBox2());

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
			// delButton.addActionListener(new ActionListener() {
			//
			// @Override
			// public void actionPerformed(ActionEvent e) {
			// System.out.println("DelButtton");
			// table.getSelectedRow();
			// String idString = (String) model.getValueAt(
			// table.getSelectedRow(), 0);
			// //userSession.delete(Long.parseLong(idString));
			// refreshTable();
			//
			// }
			// });
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
	
	public JTextField getDateTextField() {
		if (dateTextField == null) {
			dateTextField = new JTextField();
			dateTextField.setName("date");
			dateTextField.setBounds(70, 200, 150, 30);

		}
		return dateTextField;
	}

	public void setDateTextField(JTextField dateTextField) {
		this.dateTextField = dateTextField;
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
	
	
	public JLabel getDateLabel() {
		if (dateLabel == null) {
			dateLabel = new JLabel("Date :");
			dateLabel.setBounds(10, 190, 50, 50);
		}
		return dateLabel;
	}

	public void setDateLabel(JLabel dateLabel) {
		this.dateLabel = dateLabel;
	}
	
	

	// =========== GETTERS and SETTERS (JComboBox)============

	
	

	public JComboBox getProfilComboBox() {
		if (profilComboBox == null) {
			profilComboBox = new JComboBox();
			profilComboBox.setBounds(70, 60, 150, 30);

		}
		return profilComboBox;
	}

	public void setProfilComboBox(JComboBox profilComboBox) {
		this.profilComboBox = profilComboBox;
	}

	public JScrollPane getScrollPane() {
		JScrollPane scrollPane = new JScrollPane(getTable());
//		JScrollPane scrollPane = new JScrollPane(getList());
		
		scrollPane.setBounds(10, 10, 450, 450);
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
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

	public void clear() {
		getNameTextField().setText("");
		getTelTextField().setText("");
		getMailTextField().setText("");
		getProfilComboBox().setSelectedIndex(0);
	}

	public ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(getProfilRadioButton1());
			buttonGroup.add(getProfilRadioButton2());
		}
		return buttonGroup;
	}

	public void setButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}

	public JRadioButton getProfilRadioButton1() {
		if (profilRadioButton1 == null) {
			profilRadioButton1 = new JRadioButton("profil 1");
			profilRadioButton1.setBounds(10, 180, 80, 50);
		}
		return profilRadioButton1;
	}

	public JRadioButton getProfilRadioButton2() {
		if (profilRadioButton2 == null) {
			profilRadioButton2 = new JRadioButton("profil 2");
			profilRadioButton2.setBounds(10, 220, 80, 50);
		}
		return profilRadioButton2;
	}

	
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}

	public JCheckBox getProfilCheckBox1() {
		if(profilCheckBox1==null){
			profilCheckBox1 = new JCheckBox("profil 1");
			profilCheckBox1.setBounds(10, 260, 80, 50);
		}
		return profilCheckBox1;
	}

	public JCheckBox getProfilCheckBox2() {
		if(profilCheckBox2==null){
			profilCheckBox2 = new JCheckBox("profil 2");
			profilCheckBox2.setBounds(10, 300, 80, 50);
		}
		return profilCheckBox2;
	}

	
	public JList getList() {
		if(list==null){
			list = new JList();
		}
		return list;
	}

	
	public JMenuItem getMenuItem1() {
		if(menuItem1==null){
			menuItem1 = new JMenuItem();
			menuItem1.setText("List Profils");
		}
		return menuItem1;
	}

	public void setMenuItem1(JMenuItem menuItem1) {
		this.menuItem1 = menuItem1;
	}

	
	public JMenuItem getMenuItem2() {
		if(menuItem2==null){
			menuItem2 = new JMenuItem();
			menuItem2.setText("menu item 2");	
		}
		return menuItem2;
	}

	public void setMenuItem2(JMenuItem menuItem2) {
		this.menuItem2 = menuItem2;
	}

	//@Model(property = "name")
//	public JPasswordField getNamePasswordField() {
//		if (namePasswordField == null) {
//			namePasswordField = new JPasswordField();
//			namePasswordField.setBounds(70, 20, 150, 30);
//
//		}
//		return namePasswordField;
//	}
//
//	public void setNamePasswordField(JPasswordField namePasswordField) {
//		this.namePasswordField = namePasswordField;
//	}

	
	

	
}
