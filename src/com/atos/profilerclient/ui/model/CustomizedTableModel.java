package com.atos.profilerclient.ui.model;



import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.impl.swing.JTableModelComponent;

public class CustomizedTableModel extends JTableModelComponent {

	
	

	@Override
	public void initModelComponent(ModelBinding modelBinding) {
		super.initModelComponent(modelBinding);
		getCustomizedColumns().put("name","name");
		getCustomizedColumns().put("date","date");
		initTableModel(getCustomizedColumns());
	}

	
	
	
	

	

	
	
	

}
