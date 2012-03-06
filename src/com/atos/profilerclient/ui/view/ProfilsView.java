package com.atos.profilerclient.ui.view;

import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.mvp4j.annotation.Action;
import org.mvp4j.annotation.MVP;
import org.mvp4j.annotation.Model;

import com.atos.profilerclient.ui.model.ProfilsModel;
import com.atos.profilerclient.ui.presenter.ProfilsPresenter;


@MVP(modelClass = ProfilsModel.class, presenterClass = ProfilsPresenter.class)
public class ProfilsView extends JFrame {
	
	@Model(initProperty="profils", property = "profil")
//	@Action(name="actionTable",EventAction="mousePressed",EventType=MouseListener.class)
	private JTable table;
	
	@Model(property="name")
	JTextField nameTextField;
	
	
	
	public ProfilsView() {
		setTitle("Profiler Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.add(getScrollPane());
		panel.add(getNameTextField());
		
		add(panel);
	}
	
	public JScrollPane getScrollPane() {
		JScrollPane scrollPane = new JScrollPane(getTable());
		return scrollPane;
	}
	
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}

	public JTextField getNameTextField() {
		if(nameTextField==null){
			nameTextField = new JTextField();
			nameTextField.setColumns(15);
		}
		return nameTextField;
	}

	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}
	
	

}
