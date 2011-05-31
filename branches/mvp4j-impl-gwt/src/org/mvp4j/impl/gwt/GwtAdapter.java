package org.mvp4j.impl.gwt;

import org.mvp4j.adapter.ActionComponent;
import org.mvp4j.adapter.MVPAdapter;
import org.mvp4j.adapter.ModelComponent;

import com.google.gwt.user.client.ui.Button;
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
		return null;
	}

}
