package org.mvp4j.impl.swing;


import java.util.List;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;

public class JSpinnerModelComponent extends ModelComponent {

	private ModelBinding modelBinding;
	private JSpinner jspinner;
	private ChangeListener changeListener;
	private List<Object> initValues;

	public JSpinnerModelComponent() {
	}

	@Override
	public void bind() {
		SpinnerListModel spinnerModel =new SpinnerListModel();
	    initValues=(List<Object>) modelBinding.getInitPropertyValue();
	    spinnerModel.setList(initValues);
	    jspinner.setModel(spinnerModel);
	    if(modelBinding.getPropertyValue()==null){
	    	  modelBinding.setPropertyValue(jspinner.getValue());
	    }
	 
	    changeListener=new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				modelBinding.setPropertyValue(jspinner.getValue());
				
			}
	    	
	    };
	   
	    jspinner.addChangeListener(changeListener);
	    
	    if(modelBinding.getPropertyValue()!=null){
	    	for(int i=0;i<initValues.size();i++){
	    		
	    		if(initValues.get(i).toString().equals(modelBinding.getPropertyValue())){
	    			spinnerModel.setValue(spinnerModel.getList().get(i));
	    		}
	    	}
	    }
	
	}

	@Override
	public void unbind() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setConverter(Converter converter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Converter getConverter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initModelComponent(ModelBinding modelBinding) {
		jspinner=(JSpinner)modelBinding.getComponent();
		this.modelBinding=modelBinding;
		
	}

}
