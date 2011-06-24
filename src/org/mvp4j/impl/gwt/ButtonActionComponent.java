package org.mvp4j.impl.gwt;


import org.mvp4j.adapter.ActionBinding;
import org.mvp4j.adapter.ActionComponent;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.GestureChangeEvent;
import com.google.gwt.event.dom.client.GestureChangeHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.dom.client.TouchCancelEvent;
import com.google.gwt.event.dom.client.TouchCancelHandler;
import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchEndHandler;
import com.google.gwt.event.dom.client.TouchMoveEvent;
import com.google.gwt.event.dom.client.TouchMoveHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ButtonBase;
import com.gwtent.reflection.client.Reflection;

public class ButtonActionComponent extends ActionComponent implements Reflection {

	private static final Class<?> DEFAULT_EVENT_TYPE = ClickHandler.class;
	
	private ClickHandler clickHandler;
	private BlurHandler blurHandler;
	private DoubleClickHandler doubleClickHandler;
	private FocusHandler focusHandler;
	private GestureChangeHandler gestureChangeHandler;
	private KeyDownHandler keyDownHandler;
	private KeyPressHandler keyPressHandler;
	private KeyUpHandler keyUpHandler;
	private  MouseDownHandler mouseDownHandler;
	private  MouseMoveHandler mouseMoveHandler;
	private  MouseOutHandler mouseOutHandler;
	private MouseOverHandler mouseOverHandler;
	private MouseUpHandler mouseUpHandler;
    private	MouseWheelHandler mouseWheelHandler;
    private TouchMoveHandler touchMoveHandler;
    private TouchCancelHandler touchCancelHandler;
    private  TouchEndHandler touchEndHandler;
    private TouchStartHandler touchStartHandler;
    private ButtonBase button;
	private String eventAction;
	
	@Override
	public void init(ActionBinding actionBinding) {
		super.init(actionBinding);
		this.button=(ButtonBase) actionBinding.getComponent();
	
	}

	@Override
	public void bind() {
		Class<?> eventType = actionBinding.getEventType();
		eventAction = actionBinding.getEventAction();
		
		if (eventType == null) {
			eventType = DEFAULT_EVENT_TYPE;
		}
		if(eventType==ClickHandler.class){
			clickHandler = new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					if(eventAction.equals("onClick") || eventAction.equals("") ){
						actionBinding.callAction(event);
					}
					
				}
			};
			
			button.addClickHandler(clickHandler);
		}
		
		if(eventType==BlurHandler.class){
			blurHandler = new BlurHandler() {
				
				@Override
				public void onBlur(BlurEvent event) {
					if(eventAction.equals("onBlur") || eventAction.equals("")){
						actionBinding.callAction(event);
					}
					
				}
			};
			
			button.addBlurHandler(blurHandler);
			
		}
		if(eventType==DoubleClickHandler.class){
			doubleClickHandler = new DoubleClickHandler() {
				
				@Override
				public void onDoubleClick(DoubleClickEvent event) {
					if(eventAction.equals("onDoubleClick") || eventAction.equals("")){
						
						actionBinding.callAction(event);
					}
					
				}
			}; 
		button.addDoubleClickHandler(doubleClickHandler);	
		}
		if(eventType==FocusHandler.class){
		focusHandler=new FocusHandler() {
			
			@Override
			public void onFocus(FocusEvent event) {
				
				if(eventAction.equals("onFocus") || eventAction.equals("")){
					actionBinding.callAction(event);
				}
			}
		};
			
			
			
			button.addFocusHandler(focusHandler);
		}
		
		if(eventType==GestureChangeHandler.class){
			
				gestureChangeHandler= new GestureChangeHandler() {
					
					@Override
					public void onGestureChange(GestureChangeEvent event) {
						if(eventAction.equals("onGestureChange") || eventAction.equals("")){
							actionBinding.callAction(event);
						}
					}
				};
				
				
				button.addGestureChangeHandler(gestureChangeHandler);
		
			
			}
		
		if(eventType==KeyDownHandler.class){
			
			keyDownHandler= new KeyDownHandler() {
				
				@Override
				public void onKeyDown(KeyDownEvent event) {
				
					if(eventAction.equals("onKeyDown") || eventAction.equals("")){
						actionBinding.callAction(event);
					}
					
				}
			};
		
			button.addKeyDownHandler(keyDownHandler);
		}
		
        if(eventType==KeyPressHandler.class){
			keyPressHandler=new KeyPressHandler() {
				
				@Override
				public void onKeyPress(KeyPressEvent event) {
					if(eventAction.equals("onKeyPress") || eventAction.equals("")){
						actionBinding.callAction(event);
					}
					
				}
			};
		
			button.addKeyPressHandler(keyPressHandler);
		}
        
        if(eventType==KeyUpHandler.class){
			keyUpHandler = new KeyUpHandler() {
				
				@Override
				public void onKeyUp(KeyUpEvent event) {
					
					if(eventAction.equals("onKeyUp") || eventAction.equals("")){
						actionBinding.callAction(event);
					}
					
					
				}
			};
		
			button.addKeyUpHandler(keyUpHandler);
		}
        
        //**********************************************************************
        
        
        if(eventType==MouseDownHandler.class){
			mouseDownHandler= new MouseDownHandler() {
				
				@Override
				public void onMouseDown(MouseDownEvent event) {
					
					if(eventAction.equals("onMouseDown") || eventAction.equals("")){
						actionBinding.callAction(event);
					}
				}
			};
		
			button.addMouseDownHandler(mouseDownHandler);
		}
     
        if(eventType==MouseMoveHandler.class){
		mouseMoveHandler= new MouseMoveHandler() {
			
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				if(eventAction.equals("onMouseMove") || eventAction.equals("")){
					actionBinding.callAction(event);
				}
				
			}
		};
			button.addMouseMoveHandler(mouseMoveHandler);
		}
        
        
        if(eventType==KeyUpHandler.class){
	       mouseOutHandler= new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
	
				if(eventAction.equals("onMouseOut") || eventAction.equals("")){
					actionBinding.callAction(event);
				}
			}
		};
			button.addMouseOutHandler(mouseOutHandler);
		}
      
        
        if(eventType==MouseOverHandler.class){
			mouseOverHandler= new MouseOverHandler() {
				
				@Override
				public void onMouseOver(MouseOverEvent event) {
					
					if(eventAction.equals("onMouseOver") || eventAction.equals("")){
						actionBinding.callAction(event);
					}
				}
			};
		
			button.addMouseOverHandler(mouseOverHandler);
		}
       
        if(eventType==MouseUpHandler.class){
		mouseUpHandler= new MouseUpHandler() {
			
			@Override
			public void onMouseUp(MouseUpEvent event) {

				if(eventAction.equals("onMouseUp") || eventAction.equals("")){
					actionBinding.callAction(event);
				}
			}
		};
		
			button.addMouseUpHandler(mouseUpHandler);
		}
        
        if(eventType==MouseWheelHandler.class){
		mouseWheelHandler= new MouseWheelHandler() {
			
			@Override
			public void onMouseWheel(MouseWheelEvent event) {
				
				if(eventAction.equals("onMouseWheel") || eventAction.equals("")){
					actionBinding.callAction(event);
				}
			}
		};	
		
			button.addMouseWheelHandler(mouseWheelHandler);
		}
       
        if(eventType==KeyUpHandler.class){
		
		   touchCancelHandler = new TouchCancelHandler() {
			
			@Override
			public void onTouchCancel(TouchCancelEvent event) {
				if(eventAction.equals("onTouchCancel") || eventAction.equals("")){
					actionBinding.callAction(event);
				}
				
			}
		};
			button.addTouchCancelHandler(touchCancelHandler);
		}
         
        if(eventType==TouchEndHandler.class){
            touchEndHandler= new TouchEndHandler() {
				
				@Override
				public void onTouchEnd(TouchEndEvent event) {
			             
					if(eventAction.equals("onTouchEnd") || eventAction.equals("")){
						actionBinding.callAction(event);
					}		
				}
			};
		
			button.addTouchEndHandler(touchEndHandler);
		}
     
        if(eventType==KeyUpHandler.class){
        	touchMoveHandler= new TouchMoveHandler() {
				
				@Override
				public void onTouchMove(TouchMoveEvent event) {
					if(eventAction.equals("onTouchMove") || eventAction.equals("")){
						actionBinding.callAction(event);
					}		
					
				}
			};
			button.addTouchMoveHandler(touchMoveHandler);
		}
        
        if(eventType==TouchStartHandler.class){
		touchStartHandler= new TouchStartHandler() {
			
			@Override
			public void onTouchStart(TouchStartEvent event) {
			
				if(eventAction.equals("onTouchStart") || eventAction.equals("")){
					actionBinding.callAction(event);
				}
			}
		};
        	button.addTouchStartHandler(touchStartHandler);
		}
        
       		
	}

	@Override
	public void unbind() {
		
	}

}
