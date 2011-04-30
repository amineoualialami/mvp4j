package com.atos.profilerclient.ui.model;



import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.impl.swing.JTableModelComponent;

public class CustomizedTableModel extends JTableModelComponent {

	
	
	public CustomizedTableModel(ModelBinding modelBinding) {
		super(modelBinding);
		getCustomizedColumns().put("idUser", "hjyh toto");
		getCustomizedColumns().put("name", "name toto");
		getCustomizedColumns().put("phone", "name toto");
		//test Commit 
		initTableModel(getCustomizedColumns());
	}

	
	
	
	

	

	
	
	

}
