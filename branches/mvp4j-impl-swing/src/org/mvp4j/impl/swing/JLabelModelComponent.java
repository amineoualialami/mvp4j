package org.mvp4j.impl.swing;

import javax.swing.JLabel;

import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;

public class JLabelModelComponent extends ModelComponent{

	  
	private JLabel jlabel;

	
	public JLabelModelComponent() {
	}

	@Override
	public void bind(){
		
		jlabel.setText(modelBinding.getInitPropertyName().toString());
		if(modelBinding.getPropertyValue()!=null){
		jlabel.setText((String)modelBinding.getPropertyValue());
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
	public void init(ModelBinding modelBinding) {
		super.init(modelBinding);
		jlabel=(JLabel)modelBinding.getComponent();
	}


}
