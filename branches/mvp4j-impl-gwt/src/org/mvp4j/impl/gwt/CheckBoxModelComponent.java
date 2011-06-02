package org.mvp4j.impl.gwt;

import java.util.ArrayList;
import java.util.Collection;

import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.gwtent.reflection.client.Reflection;

public class CheckBoxModelComponent extends ModelComponent implements Reflection{
	
	private CheckBox checkBox;
	private Converter converter;
	private ModelBinding modelBinding;
	
	private static Collection list;

	@Override
	public void initModelComponent(ModelBinding modelBinding) {
		this.modelBinding=modelBinding;
		checkBox = (CheckBox) modelBinding.getComponent();
		
	}

	@Override
	public void bind() {
		
		
		
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Object object = modelBinding.getInitPropertyValue();
				if (checkBox.getValue()) {
					list = getList();
					if (!list.contains(object)) {
						list.add(object);
						modelBinding.setPropertyValue(list);
					}

				}
				if (!checkBox.getValue()) {
					if (list.contains(object)) {
						list.remove(object);
						modelBinding.setPropertyValue(list);
					}
				}
			}
		};
		
		checkBox.addClickHandler(clickHandler);
		
		if (modelBinding.getPropertyValue() != null) {
			Collection list = (Collection) modelBinding.getPropertyValue();
			checkBox.setEnabled(list.contains(modelBinding
					.getInitPropertyValue()));
		}
		
	}

	@Override
	public void unbind() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setConverter(Converter converter) {
		this.converter=converter;
		
	}

	@Override
	public Converter getConverter() {
		return converter;
	}

	public static Collection getList() {
		if (list == null) {
			list = new ArrayList();
		}
		return list;
	}
	
	

}
