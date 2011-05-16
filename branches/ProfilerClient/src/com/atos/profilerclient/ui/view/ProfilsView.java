package com.atos.profilerclient.ui.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.mvp4j.annotation.MVP;
import org.mvp4j.annotation.Model;

import com.atos.profilerclient.ui.model.ProfilsModel;
import com.atos.profilerclient.ui.presenter.ProfilsPresenter;


@MVP(modelClass = ProfilsModel.class, presenterClass = ProfilsPresenter.class)
public class ProfilsView extends JFrame {
	
	@Model(initProperty="profils", property = "")
	private JTable table;
	
	
	
	public ProfilsView() {
		setTitle("Profiler Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.add(getScrollPane());
		
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

}
