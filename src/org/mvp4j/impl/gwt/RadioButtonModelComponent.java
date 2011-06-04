package org.mvp4j.impl.gwt;


import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.RadioButton;
import com.gwtent.reflection.client.Reflection;

public class RadioButtonModelComponent extends ModelComponent implements
		Reflection {

	private RadioButton radioButton;
	private Converter converter;

	@Override
	public void init(ModelBinding modelBinding) {
		super.init(modelBinding);
		radioButton= (RadioButton) modelBinding.getComponent();

	}

	@Override
	public void bind() {
		
		FocusHandler focusHandler = new FocusHandler() {
			
			@Override
			public void onFocus(FocusEvent event) {
				Object initProperty = modelBinding.getInitPropertyValue();
				modelBinding.setPropertyValue(initProperty);
				
			}
		};
		radioButton.addFocusHandler(focusHandler);
		
		if(modelBinding.getPropertyValue()!=null){
			if(modelBinding.getPropertyValue()
					.equals(modelBinding.getInitPropertyValue().toString())){
				radioButton.setFocus(true);
			}
		}

	}

	@Override
	public void unbind() {

	}

	@Override
	public void setConverter(Converter converter) {
		this.converter = converter;

	}

	@Override
	public Converter getConverter() {
		return converter;
	}

}
