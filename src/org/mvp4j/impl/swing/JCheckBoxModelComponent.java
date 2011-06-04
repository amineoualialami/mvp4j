package org.mvp4j.impl.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JCheckBox;

import org.apache.log4j.Logger;
import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.impl.swing.utils.LoggerUtils;

public class JCheckBoxModelComponent extends ModelComponent {

	private ActionListener actionListerner;
	private JCheckBox checkBox;
	private Logger logger = LoggerUtils.getLogger();

	private static Collection list;

	public JCheckBoxModelComponent() {
	}

	@Override
	public void bind() {
		actionListerner = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object object = modelBinding.getInitPropertyValue();
				if (checkBox.isSelected()) {
					list = getList();
					if (!list.contains(object)) {
						list.add(object);
						modelBinding.setPropertyValue(list);
					}

				}
				if (!checkBox.isSelected()) {
					list = getList();
					if (list.contains(object)) {
						list.remove(object);
						modelBinding.setPropertyValue(list);
					}
				}
			}
		};
		checkBox.addActionListener(actionListerner);
		if (modelBinding.getPropertyValue() != null) {
			Collection list = (Collection) modelBinding.getPropertyValue();
			
			checkBox.setSelected(list.contains(modelBinding
					.getInitPropertyValue()));
		}

	}

	@Override
	public void unbind() {
		// TODO Auto-generated method stub

	}

	public Collection getList() {
		if (list == null) {
			list = new ArrayList();
		}
		return list;
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
		checkBox = (JCheckBox) modelBinding.getComponent();
		
	}



}
