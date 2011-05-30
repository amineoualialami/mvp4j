package org.mvp4j.impl.gwt;

import org.mvp4j.adapter.ActionComponent;
import org.mvp4j.adapter.MVPAdapter;
import org.mvp4j.adapter.ModelComponent;

import com.google.gwt.user.client.ui.Button;

public class GwtAdapter implements MVPAdapter{

	@Override
	public Class<? extends ActionComponent> getComponentAction(
			Class<?> componentKlass) {
		if(componentKlass.equals(Button.class)){
			System.out.println("Button");
			return ButtonActionComponent.class;
		}
		System.out.println("machi button");
		return null;
	}

	@Override
	public Class<? extends ModelComponent> getComponentModel(
			Class<?> componentKlass) {
		// TODO Auto-generated method stub
		return null;
	}

}
