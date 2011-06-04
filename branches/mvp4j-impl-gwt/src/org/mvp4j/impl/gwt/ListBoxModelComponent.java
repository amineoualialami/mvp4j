 package org.mvp4j.impl.gwt;

import java.util.List;

import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.exception.PropertyNotBindableException;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.gwtent.reflection.client.Reflection;

public class ListBoxModelComponent extends ModelComponent implements Reflection{
	
	private ListBox listBox;
	private List<Object> initValues;
	private ChangeHandler changeHandler;

	@Override
	public void init(ModelBinding modelBinding) {
		super.init(modelBinding);
		this.listBox=(ListBox) modelBinding.getComponent();
		try{
		initValues=(List<Object>) modelBinding.getInitPropertyValue();}
		catch(ClassCastException e){
			GWT.log("initProperty '"+modelBinding.getInitPropertyName()+"' must be Collection");
			throw new PropertyNotBindableException(
					modelBinding.getInitPropertyName(), modelBinding
							.getInitPropertyName().getClass(),
							listBox.getClass());
		}
	} 

	@Override
	public void bind() {
	
		GWT.log(initValues.isEmpty()+"");
		
		if(modelBinding.getPropertyValue()!=null){
			
			for(int i=0;i<initValues.size();i++){
				if(initValues.get(i).toString().equals(modelBinding.getPropertyValue()) & listBox.getItemCount()!=0){
					listBox.setSelectedIndex(i);
				}
			}
	
		}
		if(!initValues.isEmpty()){
			System.out.println(initValues.size());
			if(listBox.getItemCount()==0){
				for (Object element : initValues) {
					listBox.addItem(element.toString());
				}
			}
		}
		modelBinding.setPropertyValue(initValues.get(listBox
				.getSelectedIndex()));
		changeHandler=new ChangeHandler(){

			@Override
			public void onChange(ChangeEvent event) {
				
				modelBinding.setPropertyValue(initValues.get(listBox.getSelectedIndex()));
                
			}
			
		};
		listBox.addChangeHandler(changeHandler);
		
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

}
