package org.mvp4j.impl.gwt;

import org.mvp4j.adapter.ActionBinding;
import org.mvp4j.adapter.ActionComponent;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.GestureChangeEvent;
import com.google.gwt.event.dom.client.GestureChangeHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.gwtent.reflection.client.Reflection;

public class ListBoxActionComponent extends ActionComponent implements
		Reflection {
	public static final Class<?> DEFAULT_EVENT_TYPE = ChangeHandler.class;
	private String eventAction;
	private ListBox listBox;
	private ChangeHandler changeHandler;
	private BlurHandler blurHandler;
	private ClickHandler clickHandler;
	private DoubleClickHandler doubleClickHandler;
	private FocusHandler focusHandler;
	private GestureChangeHandler gestureChangeHandler;

	@Override
	public void init(ActionBinding actionBinding) {
		super.init(actionBinding);
		listBox = (ListBox) actionBinding.getComponent();

	}

	@Override
	public void bind() {
		Class<?> eventType = actionBinding.getEventType();
		eventAction = actionBinding.getEventAction();

		if (eventType == null) {
			eventType = DEFAULT_EVENT_TYPE;
		}
		if (eventType == ChangeHandler.class) {
			changeHandler = new ChangeHandler() {

				@Override
				public void onChange(ChangeEvent event) {
					if (eventAction.equals("")
							|| eventAction.equals("onChange")) {
						actionBinding.callAction(event);
					}

				}
			};
			listBox.addChangeHandler(changeHandler);
		}
		if (eventType == BlurHandler.class) {
			blurHandler = new BlurHandler() {

				@Override
				public void onBlur(BlurEvent event) {
					if (eventAction.equals("") || eventAction.equals("onBlur")) {
						actionBinding.callAction(event);
					}

				}

			};
			listBox.addBlurHandler(blurHandler);
		}
		if (eventType == ClickHandler.class) {
			clickHandler = new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					if (eventAction.equals("") || eventAction.equals("onClick")) {
						actionBinding.callAction(event);
					}
				}
			};
			listBox.addClickHandler(clickHandler);
		}
		if (eventType == DoubleClickHandler.class) {
			doubleClickHandler = new DoubleClickHandler() {

				@Override
				public void onDoubleClick(DoubleClickEvent event) {
					if (eventAction.equals("")
							|| eventAction.equals("onDoubleClick")) {
						actionBinding.callAction(event);
					}

				}
			};
			listBox.addDoubleClickHandler(doubleClickHandler);
		}

		if (eventType == FocusHandler.class) {
			focusHandler = new FocusHandler() {

				@Override
				public void onFocus(FocusEvent event) {

					if (eventAction.equals("") || eventAction.equals("onFocus")) {
						actionBinding.callAction(event);
					}
				}
			};
			listBox.addFocusHandler(focusHandler);
		}
		if (eventType == GestureChangeHandler.class) {
			gestureChangeHandler = new GestureChangeHandler() {

				@Override
				public void onGestureChange(GestureChangeEvent event) {
					if (eventAction.equals("")
							|| eventAction.equals("onGestureChange")) {
						actionBinding.callAction(event);
					}

				}
			};
			listBox.addGestureChangeHandler(gestureChangeHandler);
		}
	}

	@Override
	public void unbind() {

	}

}
