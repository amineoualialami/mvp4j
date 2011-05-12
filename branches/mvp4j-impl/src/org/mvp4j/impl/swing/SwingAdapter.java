package org.mvp4j.impl.swing;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.mvp4j.Converter;
import org.mvp4j.adapter.ActionComponent;
import org.mvp4j.adapter.MVPAdapter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.impl.reflect.AppControllerReflect;
import org.mvp4j.impl.reflect.AppControllerReflectFactory;
import org.mvp4j.impl.reflect.ModelBindingImpl;
import org.mvp4j.impl.reflect.ModelInfo;
import org.mvp4j.impl.reflect.ModelViewInfo;
import org.mvp4j.impl.swing.utils.LoggerUtils;

public class SwingAdapter implements MVPAdapter {

	public static final Converter DEFAULT_CONVERTER = new DefaultConverter();
	private Converter currentConverter = DEFAULT_CONVERTER;
	private Logger logger = LoggerUtils.getLogger();
	private Map<Object, Object> customizedComponentsModels = new HashMap<Object, Object>();

	@Override
	public Class<? extends ActionComponent> getComponentAction(
			Class<?> componentKlass) {

		if (componentKlass.equals(JButton.class)) {
			return AbstractButtonActionComponent.class;
		} else if (componentKlass == JMenuItem.class)
			return AbstractButtonActionComponent.class;
		else if (componentKlass==JComboBox.class){
			return JComboBoxActionComponent.class;
		}
		else if(componentKlass==JList.class){
			return JListActionComponent.class;
		}
		else if(componentKlass==JTextField.class ){
			return JTextActionComponent.class;
		}
		else if(componentKlass==JRadioButton.class){
			return JRadioButtonActionComponent.class;
		}
		else if(componentKlass==JTable.class){
			return JTableActionComponent.class;
		}
		else if(componentKlass==JPasswordField.class){
			return JTextActionComponent.class;
		}
		else if(componentKlass==JCheckBox.class){
			return JCheckBoxActionComponent.class;
		}
		else if(componentKlass == JFormattedTextField.class){
			return JTextActionComponent.class;
		}
		else if (componentKlass == JTextArea.class) {
			return JTextActionComponent.class;
		}
		else if (componentKlass == JSpinner.class){
			return JSpinnerActionComponent.class;
		}
		
			logger.error("Action Component " + componentKlass.getName()
					+ "  is not supported");
		throw new IllegalArgumentException();
	}

	@Override
	public Class<? extends ModelComponent> getComponentModel(
			Class<?> componentKlass) {

		if (componentKlass == JTextField.class) {
			if (customizedComponentsModels.get(JTextField.class) == null)
				return JTextModelComponent.class;
			else
				return (Class<? extends ModelComponent>) customizedComponentsModels
						.get(JTextField.class);
		}

		else if (componentKlass == JRadioButton.class) {
			if (customizedComponentsModels.get(JRadioButton.class) == null)
				return JRadioButtonModelComponent.class;
			else
				return (Class<? extends ModelComponent>) customizedComponentsModels
						.get(JRadioButton.class);
		}

		else if (componentKlass == JComboBox.class) {
			if (customizedComponentsModels.get(JComboBox.class) == null)
				return JComboBoxModelComponent.class;
			else
				return (Class<? extends ModelComponent>) customizedComponentsModels
						.get(JComboBox.class);
		}

		else if (componentKlass == JTable.class) {
			if (customizedComponentsModels.get(JTable.class) == null)
				return JTableModelComponent.class;
			else
				return (Class<? extends ModelComponent>) customizedComponentsModels
						.get(JTable.class);
		}

		else if (componentKlass == JPasswordField.class) {

			if (customizedComponentsModels.get(JPasswordField.class) == null)
				return JTextModelComponent.class;
			else
				return (Class<? extends ModelComponent>) customizedComponentsModels
						.get(JPasswordField.class);
		}

		else if (componentKlass == JCheckBox.class) {
			if (customizedComponentsModels.get(JCheckBox.class) == null)
				return JCheckBoxModelComponent.class;
			else
				return (Class<? extends ModelComponent>) customizedComponentsModels
						.get(JCheckBox.class);
		}

		else if (componentKlass == JFormattedTextField.class) {
			if (customizedComponentsModels.get(JFormattedTextField.class) == null)
				return JTextModelComponent.class;
			else
				return (Class<? extends ModelComponent>) customizedComponentsModels
						.get(JFormattedTextField.class);
		}

		else if (componentKlass == JTextArea.class) {
			if (customizedComponentsModels.get(JTextArea.class) == null)
				return JTextModelComponent.class;
			else
				return (Class<? extends ModelComponent>) customizedComponentsModels
						.get(JTextArea.class);
		}

		else if (componentKlass == JLabel.class) {
			if (customizedComponentsModels.get(JLabel.class) == null)
				return JLabelModelComponent.class;
			else
				return (Class<? extends ModelComponent>) customizedComponentsModels
						.get(JLabel.class);
		}

		else if (componentKlass == JSpinner.class) {
			if (customizedComponentsModels.get(JSpinner.class) == null)
				return JSpinnerModelComponent.class;
			else
				return (Class<? extends ModelComponent>) customizedComponentsModels
						.get(JSpinner.class);
		} else if (componentKlass == JList.class) {
			if (customizedComponentsModels.get(JList.class) == null)
				return JListModelComponent.class;
			else
				return (Class<? extends ModelComponent>) customizedComponentsModels
						.get(JList.class);
		} else
			logger.error("Model Component " + componentKlass.getName()
					+ "  is not supported");
		throw new IllegalArgumentException();
	}

	@Override
	public Converter getConverter() {
		return currentConverter;
	}
	@Override
	public void setConverter(Converter converter) {
		this.currentConverter = converter;
	}
	

//	@Override
//	public void setComponentModel(ModelComponent modelComponent,
//			Class<? extends ModelComponent> customizedModelComponent) {
//		customizedComponentsModels.put(modelComponent,customizedModelComponent);
//	}
	
	
	

	@Override
	public ModelComponent getComponentModel(Object view,Object component) {
		AppControllerReflect appController = AppControllerReflectFactory
		.getAppControllerInstance();
		Map<String, ModelViewInfo> modelViewInfoMap = appController.getModelViewInfoMap();
		ModelViewInfo modelViewInfo = modelViewInfoMap.get(view.getClass().toString());
		List<ModelInfo> listModelInfo = modelViewInfo.getModelsInfo();
		for (ModelInfo modelInfo : listModelInfo) {
			try {
				if(modelInfo.getMethod().invoke(view)==component){
					return modelInfo.getComponentModel();
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

@Override
public void setComponentModel(Object view,Object model, Object component,
		Class<? extends ModelComponent> customizedModelComponent) {
	AppControllerReflect appController = AppControllerReflectFactory
	.getAppControllerInstance();
	Map<String, ModelViewInfo> modelViewInfoMap = appController.getModelViewInfoMap();
	ModelViewInfo modelViewInfo = modelViewInfoMap.get(view.getClass().toString());
	List<ModelInfo> listModelInfo = modelViewInfo.getModelsInfo();
	for (ModelInfo modelInfo : listModelInfo) {
		try {
			if(modelInfo.getMethod().invoke(view)==component){
				Class<? extends ModelComponent> componentModelClass = customizedModelComponent;
				Constructor<? extends ModelComponent>  constructor = componentModelClass.getConstructor(ModelBinding.class);
				ModelComponent componentModel = (ModelComponent) constructor.newInstance(new ModelBindingImpl(view, model,modelInfo, this));
				modelInfo.setComponentModel(componentModel);
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

	


	
	

}
