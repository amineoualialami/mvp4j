package org.mvp4j.impl.gwt;

import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.user.client.ui.RichTextArea;
import com.gwtent.reflection.client.Reflection;

public class RichTextAreaModelComponent extends ModelComponent implements Reflection {

	private RichTextArea textArea;
	
	@Override
	public void init(ModelBinding modelBinding) {
		super.init(modelBinding);
		textArea=(RichTextArea)modelBinding.getComponent();
	}

	@Override
	public void bind() {
	
		BlurHandler blurHandler=new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				modelBinding.setPropertyValue(textArea.getText());
				
			}
		};
		textArea.addBlurHandler(blurHandler);
		
		if (modelBinding.getPropertyValue() == null
				|| modelBinding.getPropertyValue().equals(0)) {
			textArea.setText("");
		} else {
			String string = modelBinding.getPropertyValue() + "";
			textArea.setText(string);
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

}
