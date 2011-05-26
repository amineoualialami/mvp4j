package org.mvp4j.impl.gen;

import org.mvp4j.AppController;
import org.mvp4j.adapter.MVPAdapter;
import org.mvp4j.adapter.MVPBinding;
import org.mvp4j.annotation.MVP;

import com.gwtent.reflection.client.ClassType;
import com.gwtent.reflection.client.TypeOracle;

public class AppControllerGen implements AppController{

	@Override
	public MVPBinding bind(Object view, Object model, Object presenter) {
		processView(view.getClass());
		return null;
	}

	@Override
	public MVPBinding bindModel(Object view, Object model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MVPBinding bindPresenter(Object view, Object presenter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refreshView(Object view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAdapter(MVPAdapter adapter) {
		// TODO Auto-generated method stub
		
	}
	
	private void processView(Class<?> viewClass){
		ClassType classType = TypeOracle.Instance.getClassType(viewClass);
		MVP mvp = classType.getAnnotation(MVP.class);
		System.out.println("The model Class : "+mvp.modelClass());
		
	}

}
