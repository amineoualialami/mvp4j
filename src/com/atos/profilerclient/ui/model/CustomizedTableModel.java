package com.atos.profilerclient.ui.model;



import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.impl.swing.JTableModelComponent;

public class CustomizedTableModel extends JTableModelComponent {

	
	
	public CustomizedTableModel(ModelBinding modelBinding) {
		super(modelBinding);
		getCustomizedColumns().put(0, "hjyh toto");
		getCustomizedColumns().put(1, "name toto");
		initTableModel(getCustomizedColumns());
	}

	
	
	
	

	

	
	
	

}
