package org.mvp4j.impl.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.Logger;
import org.mvp4j.adapter.ActionBinding;
import org.mvp4j.adapter.ActionComponent;
import org.mvp4j.impl.swing.utils.LoggerUtils;

public class JListActionComponent extends ActionComponent{

	private ActionBinding actionBinding;
	private JList jlist;
	private static final Class<?> DEFAULT_EVENT_TYPE = ListSelectionListener.class;
	private MouseListener mouseListener;
	private KeyListener keyListener;
	private ListSelectionListener listSelectionListener;
	private boolean MethodIsInvoked=true;
	private Logger logger = LoggerUtils.getLogger();
	private String eventAction;
	
	public JListActionComponent(ActionBinding actionBinding) {
		super(actionBinding);
		this.actionBinding=actionBinding;
		jlist=(JList)actionBinding.getComponent();
		
	}

	@Override
	public void bind() {
		
		Class<?> eventType = actionBinding.getEventType();
		eventAction=actionBinding.getEventAction();
		
		if(eventType==null){
			eventType=DEFAULT_EVENT_TYPE;
		}		
		else if(eventType==ListSelectionListener.class){
			if(eventAction.equals("")){
				eventAction="valueChanged";
			}
		listSelectionListener=new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(eventAction.equals("valueChanged")){
					actionBinding.callAction(e);
					MethodIsInvoked=true;
				}
				if(MethodIsInvoked==false){
					  
					  logger.error("The event Action "+eventAction+" is not supported by this event type ");
				  }
				
			}
		};		
		jlist.addListSelectionListener(listSelectionListener);
	
		}
		
		else  if(eventType==MouseListener.class){
	    	mouseListener=new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					if(eventAction.equals("mouseReleased")){
						actionBinding.callAction(e);
						MethodIsInvoked=true;
					}
					if(MethodIsInvoked==false){
						  
						  logger.error("The event Action "+eventAction+" is not supported by this event type ");
					  }
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					if(eventAction.equals("mousePressed")){
						actionBinding.callAction(e);
						MethodIsInvoked=true;
					}
					if(MethodIsInvoked==false){
						  
						  logger.error("The event Action "+eventAction+" is not supported by this event type ");
					  }
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					if(eventAction.equals("mouseExited")){
						actionBinding.callAction(e);
						MethodIsInvoked=true;
					}
					if(MethodIsInvoked==false){
						  
						  logger.error("The event Action "+eventAction+" is not supported by this event type ");
					  }
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					if(eventAction.equals("mouseEntered")){
						actionBinding.callAction(e);
						MethodIsInvoked=true;
					}
					if(MethodIsInvoked==false){
						  
						  logger.error("The event Action "+eventAction+" is not supported by this event type ");
					  }
					
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if(eventAction.equals("mouseClicked")){
						actionBinding.callAction(e);
						MethodIsInvoked=true;
					}
					if(MethodIsInvoked==false){
						  
						  logger.error("The event Action "+eventAction+" is not supported by this event type ");
					  }
					
				}
			};
			jlist.addMouseListener(mouseListener);
	    }
	    
	    else if(eventType==KeyListener.class){
		  
		  keyListener=new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(eventAction.equals("keyTyped")){
					actionBinding.callAction(e);
					MethodIsInvoked=true;
				}
				if(MethodIsInvoked==false){
					  
					  logger.error("The event Action "+eventAction+" is not supported by this event type ");
				  }
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(eventAction.equals("keyReleased")){
					actionBinding.callAction(e);
					MethodIsInvoked=true;
				}
				if(MethodIsInvoked==false){
					  
					  logger.error("The event Action "+eventAction+" is not supported by this event type ");
				  }
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(eventAction.equals("keyPressed")){
					actionBinding.callAction(e);
					MethodIsInvoked=true;
				}
				if(MethodIsInvoked==false){
					  
					  logger.error("The event Action "+eventAction+" is not supported by this event type ");
				  }
				
			}
			
		};
		jlist.addKeyListener(keyListener);
		
	  }
	    else{
	  logger.info("This event type "+eventType+" is not supported");
	    }
	}

	@Override
	public void unbind() {
		// TODO Auto-generated method stub
		
	}

}
