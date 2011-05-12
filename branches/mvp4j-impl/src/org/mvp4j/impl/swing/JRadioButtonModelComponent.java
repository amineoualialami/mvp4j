package org.mvp4j.impl.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import org.apache.log4j.Logger;
import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.impl.swing.utils.LoggerUtils;

public class JRadioButtonModelComponent extends ModelComponent {

	private ModelBinding modelBinding;
	private ActionListener actionListerner;
	private JRadioButton radionButton;
	private Logger logger = LoggerUtils.getLogger();

	public JRadioButtonModelComponent(ModelBinding modelBinding) {
		super(modelBinding);
		this.modelBinding = modelBinding;
		radionButton = (JRadioButton) modelBinding.getComponent();

	}

	@Override
	public void bind() {
		actionListerner = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object object = modelBinding.getInitPropertyValue();
				modelBinding.setPropertyValue(object);

			}
		};
		radionButton.addActionListener(actionListerner);

		if (modelBinding.getPropertyValue() != null) {
			if (modelBinding.getPropertyValue().toString()
					.equals(modelBinding.getInitPropertyValue().toString())) {
				radionButton.setSelected(true);
			}
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
