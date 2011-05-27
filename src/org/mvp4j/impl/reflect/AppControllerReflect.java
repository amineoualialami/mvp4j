package org.mvp4j.impl.reflect;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.mvp4j.AppController;
import org.mvp4j.adapter.MVPAdapter;
import org.mvp4j.adapter.MVPBinding;
import org.mvp4j.annotation.MVP;
import org.mvp4j.annotation.Model;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.gwtent.reflection.client.ClassType;
import com.gwtent.reflection.client.Constructor;
import com.gwtent.reflection.client.Field;
import com.gwtent.reflection.client.Method;
import com.gwtent.reflection.client.TypeOracle;

public class AppControllerReflect implements AppController {

	@Override
	public MVPBinding bind(Object view, Object model, Object presenter) {
		processView(view.getClass());
		ClassType classType = TypeOracle.Instance.getClassType(model.getClass());
		Field field = classType.getField("name");
		field.setFieldValue(model, "TestValue");
		System.out.println("field value  : "+field.getFieldValue(model));
		System.out.println("***field.set & field.get  OK***");
		
		ClassType classType2 = TypeOracle.Instance.getClassType(view.getClass());
		Method method2 = classType2.getMethod("getName", null);
		Boolean boolean2= method2.isAnnotationPresent(Model.class);
		System.out.println(boolean2);
		System.out.println("***method.isAnnotationPresent  OK***");
		
		TextBox textBox = (TextBox) method2.invoke(view, null);
		textBox.setText("test value");
		System.out.println("***method.invoke()  OK***");
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
		System.out.println("***Class.getAnnotation OK***");
		
		
		
		
		Field[] fields = classType.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		System.out.println("***Class.getDeclaredFields OK***");
		
		
		
		Method[] methods = classType.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		System.out.println("***Class.getDeclaredMethods  OK***");
		Method method = classType.getMethod("getTableRows", null);
		System.out.println(method.getName());
		System.out.println("***Class.getDeclaredMethod***");
		
		Constructor constructor = classType.findConstructor();
		Object object = constructor.newInstance();
		System.out.println(object.getClass());
		System.out.println("***class.getConstructor***");
		
		Field field = classType.getField("name");
		Boolean boolean1 =field.isAnnotationPresent(Model.class);
		System.out.println(boolean1);
		System.out.println("***field.isAnnotationPresent OK***");
		
		Model model = field.getAnnotation(Model.class);
		System.out.println("initProperty : "+model.initProperty()+" property = "+model.property());
		System.out.println("***field.getAnnotation   OK***");
		
		
		
	}

}
