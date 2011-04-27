package org.mvp4j.impl.swing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
import java.util.List;

import javax.swing.JComboBox;

import org.apache.log4j.Logger;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.exception.PropertyNotBindableException;
import org.mvp4j.impl.swing.utils.LoggerUtils;

public class JComboBoxModelComponent extends ModelComponent {

	private ModelBinding modelBinding;
	private JComboBox jcombobox;
	private ItemListener itemlistener;
	private List<Object> initValues;
	private Logger logger = LoggerUtils.getLogger();

	public JComboBoxModelComponent(ModelBinding modelBinding) {
		super(modelBinding);
		this.modelBinding = modelBinding;
		jcombobox = (JComboBox) modelBinding.getComponent();
		try {
			initValues = (List<Object>) modelBinding.getInitPropertyValue();
		}
		catch (ClassCastException e) {
			logger.error("initProperty '"+modelBinding.getInitPropertyName()+"' must be Collection");
        	throw new PropertyNotBindableException(
					modelBinding.getInitPropertyName(), modelBinding
							.getInitPropertyName().getClass(),
							jcombobox.getClass());
		}
			
	}

	@Override
	public void bind() {
       
		if(modelBinding.getPropertyValue()!=null){
		
			for(int i=0;i<initValues.size();i++){
				if(initValues.get(i).toString().equals(modelBinding.getPropertyValue().toString())){
					jcombobox.setSelectedIndex(i);
				}
			}
	
		}
		if (!initValues.isEmpty()) {

			if(jcombobox.getItemCount()==0){
			for (Object object : initValues) {
				jcombobox.addItem(object);
				
			}
			}
		} else {
			logger.error("The value of Init Property is empty!!!");
			throw new IllegalArgumentException();
		}

		modelBinding.setPropertyValue(initValues.get(jcombobox
				.getSelectedIndex()));
       
		itemlistener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				
				modelBinding.setPropertyValue(initValues.get(jcombobox
						.getSelectedIndex()));

			}
		};
		jcombobox.addItemListener(itemlistener);
		
		 
	}

	@Override
	public void unbind() {

	}

}
