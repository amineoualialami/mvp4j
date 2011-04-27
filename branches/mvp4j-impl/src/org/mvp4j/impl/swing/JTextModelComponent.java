package org.mvp4j.impl.swing;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.text.JTextComponent;

import org.apache.log4j.Logger;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.impl.swing.utils.LoggerUtils;

public class JTextModelComponent extends ModelComponent {

	private JTextComponent textField;
	private KeyListener keyListener;
	private FocusListener focusListener;
	private ModelBinding modelBinding;
	private Logger logger = LoggerUtils.getLogger();

	public JTextModelComponent(ModelBinding modelBinding) {
		super(modelBinding);
		textField = (JTextComponent) modelBinding.getComponent();
		this.modelBinding = modelBinding;
	}

	@Override
	public void bind() {

		keyListener = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				modelBinding.setPropertyValue(textField.getText());

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		};
		focusListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			
				modelBinding.setPropertyValue(textField.getText());

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		};
		textField.addKeyListener(keyListener);
		textField.addFocusListener(focusListener);

		if (modelBinding.getPropertyValue() == null) {
			textField.setText("");
		} else {
			String string = modelBinding.getPropertyValue().toString();
			textField.setText(string);
		}

	}

	@Override
	public void unbind() {
		textField.removeKeyListener(keyListener);
		textField.removeFocusListener(focusListener);
	}

}
