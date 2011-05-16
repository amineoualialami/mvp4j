package com.atos.profilerclient.ui.model;



import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.impl.swing.JTableModelComponent;

public class CustomizedTableModel extends JTableModelComponent {

	
	
	public CustomizedTableModel(ModelBinding modelBinding) {
		super(modelBinding);
//		getCustomizedColumns().put("idUser", "id toto");
//		getCustomizedColumns().put("name", "name toto");
//		getCustomizedColumns().put("phone", "phone toto");
		getCustomizedColumns().put("name","profil name");
		initTableModel(getCustomizedColumns());
	}

	
	
	
	

	

	
	
	

}
