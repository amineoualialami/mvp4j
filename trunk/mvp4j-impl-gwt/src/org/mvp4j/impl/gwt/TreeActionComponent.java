package org.mvp4j.impl.gwt;

import org.mvp4j.adapter.ActionBinding;
import org.mvp4j.adapter.ActionComponent;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
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
import com.google.gwt.event.dom.client.TouchCancelHandler;
import com.google.gwt.event.dom.client.TouchEndHandler;
import com.google.gwt.event.dom.client.TouchMoveHandler;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.TreeListener;
import com.gwtent.reflection.client.Reflection;

public class TreeActionComponent extends ActionComponent implements Reflection{
	
private static final Class<?> DEFAULT_EVENT_TYPE = TreeListener.class;
	
	
	private BlurHandler blurHandler;
	private FocusHandler focusHandler;
	private KeyDownHandler keyDownHandler;
	private KeyPressHandler keyPressHandler;
	private KeyUpHandler keyUpHandler;
	private  MouseDownHandler mouseDownHandler;
	private  MouseMoveHandler mouseMoveHandler;
	private  MouseOutHandler mouseOutHandler;
	private MouseOverHandler mouseOverHandler;
	private MouseUpHandler mouseUpHandler;
    private	MouseWheelHandler mouseWheelHandler;
    private TreeListener treeListener;
	private Tree tree;
	private String eventAction;

	@Override
	public void init(ActionBinding actionBinding) {
		super.init(actionBinding);
		tree=(Tree)actionBinding.getComponent();
	}

	@Override
	public void bind() {
		Class<?> eventType = actionBinding.getEventType();
		eventAction = actionBinding.getEventAction();
		
		if (eventType == null) {
			eventType = DEFAULT_EVENT_TYPE;
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
			
			tree.addBlurHandler(blurHandler);
			
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
			
			
			
			tree.addFocusHandler(focusHandler);
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
		
			tree.addKeyDownHandler(keyDownHandler);
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
		
			tree.addKeyPressHandler(keyPressHandler);
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
		
			tree.addKeyUpHandler(keyUpHandler);
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
		
			tree.addMouseDownHandler(mouseDownHandler);
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
			tree.addMouseMoveHandler(mouseMoveHandler);
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
			tree.addMouseOutHandler(mouseOutHandler);
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
		
			tree.addMouseOverHandler(mouseOverHandler);
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
		
			tree.addMouseUpHandler(mouseUpHandler);
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
		
			tree.addMouseWheelHandler(mouseWheelHandler);
		}
       
        if(eventType==TreeListener.class){
        	
                	treeListener= new TreeListener(
                			) {
						
						@Override
						public void onTreeItemStateChanged(TreeItem item) {
							System.out.println("TreeItemStateChanged");
							
						}
						
						@Override
						public void onTreeItemSelected(TreeItem item) {
							System.out.println("TreeItemSelected");
							
						}
					};
        	tree.addTreeListener(treeListener);
        }
         
        
     
        

		
		
	}

	@Override
	public void unbind() {
		// TODO Auto-generated method stub
		
	}

}
