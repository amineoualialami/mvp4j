package org.mvp4j.impl.gwt;

import org.mvp4j.adapter.ActionComponent;
import org.mvp4j.adapter.MVPAdapter;
import org.mvp4j.adapter.ModelComponent;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

public class GwtAdapter implements MVPAdapter{

	@Override
	public Class<? extends ActionComponent> getComponentAction(
			Class<?> componentKlass) {
		if(componentKlass.equals(Button.class)){
			return ButtonActionComponent.class;
		}
		return null;
	}

	@Override
	public Class<? extends ModelComponent> getComponentModel(
			Class<?> componentKlass) {
		if(componentKlass==TextBox.class){
			return TextBoxModelComponent.class;
		}
		if(componentKlass==RadioButton.class){
			return RadioButtonModelComponent.class;
		}
		if(componentKlass==ListBox.class){
			return ListBoxModelComponent.class;
		}
		if(componentKlass==CheckBox.class){
			return CheckBoxModelComponent.class;
		}
		return null;
	}

}
