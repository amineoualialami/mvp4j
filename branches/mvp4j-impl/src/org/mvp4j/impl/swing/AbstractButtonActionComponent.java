package org.mvp4j.impl.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

import org.apache.log4j.Logger;
import org.mvp4j.adapter.ActionBinding;
import org.mvp4j.adapter.ActionComponent;
import org.mvp4j.impl.swing.utils.LoggerUtils;

public class AbstractButtonActionComponent extends ActionComponent {

	
	private AbstractButton abstractButton;
	private ActionBinding actionBinding;
	private static final Class<?> DEFAULT_EVENT_TYPE = ActionListener.class;
	private ActionListener listener = null;
	private Logger logger = LoggerUtils.getLogger();
	
	public AbstractButtonActionComponent(ActionBinding actionBinding) {
		super(actionBinding);
		this.abstractButton =  (AbstractButton) actionBinding.getComponent();
		this.actionBinding = actionBinding;
	}

	@Override
	public void bind() {
		Class<?> eventType = actionBinding.getEventType();
		if (eventType == null) {
			eventType = DEFAULT_EVENT_TYPE;
		}

		if (eventType == ActionListener.class) {
			listener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					actionBinding.callAction();
				}
			};
			abstractButton.addActionListener(listener);
		} else {
			logger.error("The event type " + actionBinding.getEventType()
					+ " is not supported");
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public void unbind() {
		abstractButton.removeActionListener(listener);
		
	}

}
