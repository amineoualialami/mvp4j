package com.atos.profilerclient.ui.model;



import java.util.Map;

import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.impl.swing.JTableModelComponent;

public class CustomizedTableModel extends JTableModelComponent {

	@Override
	public Object initTableModel(Map<String, String> customizedColumns) {
		getCustomizedColumns().put("name","nameee");
		getCustomizedColumns().put("date","date");
		return super.initTableModel(getCustomizedColumns());
	}

	
	
	
	

	

	
	
	

}
