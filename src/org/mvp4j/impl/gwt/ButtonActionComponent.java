package org.mvp4j.impl.gwt;


import org.mvp4j.adapter.ActionBinding;
import org.mvp4j.adapter.ActionComponent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.gwtent.reflection.client.Reflection;

public class ButtonActionComponent extends ActionComponent implements Reflection {

	private static final Class<?> DEFAULT_EVENT_TYPE = ClickHandler.class;
	
	private ClickHandler clickHandler;
	
	private Button button;
	private ActionBinding actionbinding;
	private String eventAction;
	
	@Override
	public void initActionComponent(ActionBinding actionBinding) {
		this.actionbinding=actionBinding;
		this.button=(Button) actionBinding.getComponent();
		
	}

	@Override
	public void bind() {
		Class<?> eventType = actionbinding.getEventType();
		eventAction = actionbinding.getEventAction();
		
		if (eventType == null) {
			eventType = DEFAULT_EVENT_TYPE;
		}
		if(eventType==ClickHandler.class){
			clickHandler = new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					if(eventAction.equals("onClick") || eventAction.equals("") ){
						actionbinding.callAction(event);
					}
					
				}
			};
			
			button.addClickHandler(clickHandler);
		}
		
	}

	@Override
	public void unbind() {
		
	}

}