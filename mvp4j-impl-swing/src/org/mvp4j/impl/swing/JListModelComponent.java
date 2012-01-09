package org.mvp4j.impl.swing;

import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.Logger;
import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.exception.PropertyNotBindableException;
import org.mvp4j.impl.swing.utils.LoggerUtils;

public class JListModelComponent extends ModelComponent {

	private JList list;
	private MouseListener mouseListener;
	private List<Object> initValues;
	private Logger logger = LoggerUtils.getLogger();

	public JListModelComponent() {
	}

	@Override
	public void bind() {
		try{
		initValues = (List<Object>) modelBinding.getInitPropertyValue();
		}
		catch (ClassCastException e) {
			logger.error("initProperty '"+modelBinding.getInitPropertyName()+"' must be Collection");
        	throw new PropertyNotBindableException(
					modelBinding.getInitPropertyName(), modelBinding
							.getInitPropertyName().getClass(),
							list.getClass());
		}
		if (initValues instanceof Collection) {
		DefaultListModel listModel = new DefaultListModel();
		for (Object object : initValues) {
			listModel.addElement(object);
		}
		list.setModel(listModel);

		ListSelectionListener selectionListener = new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try{
				initValues = (List<Object>) modelBinding.getInitPropertyValue();
				modelBinding.setPropertyValue(initValues.get(list
						.getSelectedIndex()));
				}
				catch (ArrayIndexOutOfBoundsException a) {
				}
			}
		};
		list.addListSelectionListener(selectionListener);
		}
		else{
			logger.error("initProperty '"+modelBinding.getInitPropertyName()+"' must be Collection");
			throw new PropertyNotBindableException(
					modelBinding.getInitPropertyName(), modelBinding
							.getInitPropertyName().getClass(),
					list.getClass());
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

	@Override
	public void init(ModelBinding modelBinding) {
		super.init(modelBinding);
		list = (JList) modelBinding.getComponent();
		
	}

}
