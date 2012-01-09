package org.mvp4j.impl.gwt;

import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.gwtent.reflection.client.Reflection;

public class TextBoxModelComponent extends ModelComponent implements Reflection{

	private TextBox textBox;
	private Converter converter;
	private BlurHandler blurHandler;

	@Override
	public void init(ModelBinding modelBinding) {
		super.init(modelBinding);
		textBox = (TextBox) modelBinding.getComponent();
	}

	@Override
	public void bind() {

		blurHandler = new BlurHandler() {

			@Override
			public void onBlur(BlurEvent event) {
				GWT.log("Focus Lost");
				modelBinding.setPropertyValue(textBox.getText());

			}
		};
        
		textBox.addBlurHandler(blurHandler);

		if (modelBinding.getPropertyValue() == null
				|| modelBinding.getPropertyValue().equals("0")) {
		    
			textBox.setText("");
		} else {
			String string = modelBinding.getPropertyValue() + "";
			textBox.setText(string);
		}

	}

	@Override
	public void unbind() {
		// TODO Auto-generated method stub

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
