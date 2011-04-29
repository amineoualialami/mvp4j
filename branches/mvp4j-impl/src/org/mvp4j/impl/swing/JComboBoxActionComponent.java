package org.mvp4j.impl.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyListener;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.PopupMenuListener;

import org.apache.log4j.Logger;
import org.mvp4j.adapter.ActionBinding;
import org.mvp4j.adapter.ActionComponent;
import org.mvp4j.impl.swing.utils.LoggerUtils;

public class JComboBoxActionComponent extends ActionComponent{

	private ActionBinding actionBinding;
	private JComboBox jcombobox;
	private static final Class<?> DEFAULT_EVENT_TYPE = ItemListener.class;
	private ItemListener itemListener;
	private ActionListener actionListener;
	private MouseListener mouseListener;
	private KeyListener keyListener;
	
	private ComponentListener componentListener;
	private AncestorListener ancestorListener;
	private ContainerListener containerListener;
	private FocusListener focusListener;
	private HierarchyBoundsListener hierarchyBoundsListener;
	private HierarchyListener hierarchyListener;
	private InputMethodListener inputMethodListener;
	private MouseMotionListener mouseMotionListener;
	private MouseWheelListener mouseWheelListener;
	private PopupMenuListener popupMenuListener;
	private PropertyChangeListener propertyChangeListener;
	private Logger logger = LoggerUtils.getLogger();
	private String eventAction;
	
	public JComboBoxActionComponent(ActionBinding actionBinding) {
		super(actionBinding);
		this.actionBinding=actionBinding;
		jcombobox=(JComboBox)actionBinding.getComponent();
	}

	@Override
	public void bind() {
		Class<?> eventType = actionBinding.getEventType();
		eventAction=actionBinding.getEventAction();
		
		if(eventType==null){
			eventType=DEFAULT_EVENT_TYPE;
		}
		
		
		
		if(eventType==ItemListener.class){
			if(eventAction.equals("")){
				eventAction="itemStateChanged";
			}
			itemListener=new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(eventAction.equals("itemStateChanged")){
					actionBinding.callAction(e);
					
					}}
				
			};
			jcombobox.addItemListener(itemListener);
		}
		else if(eventType==ActionListener.class){
	    	if(eventAction.equals("")){
				eventAction="actionPerformed";
				
			}
	    	actionListener=new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					if(eventAction.equals("actionPerformed")){
						actionBinding.callAction(e);
						
					}
					  
				}
	    		
	    	};
	    	jcombobox.addActionListener(actionListener);
	    }
		else if(eventType==MouseListener.class){
	    	mouseListener=new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					if(eventAction.equals("mouseReleased")){
						actionBinding.callAction(e);
						
					}
					
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					if(eventAction.equals("mousePressed")){
						actionBinding.callAction(e);
						
					}
					
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					if(eventAction.equals("mouseExited")){
						actionBinding.callAction(e);
						
					}
					
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					if(eventAction.equals("mouseEntered")){
						actionBinding.callAction(e);
						
					}
					
					
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if(eventAction.equals("mouseClicked")){
						actionBinding.callAction(e);
						
					}
					
					
				}
			};
			jcombobox.addMouseListener(mouseListener);
			
	    }
	    
		else if(eventType==KeyListener.class){
		  
		  keyListener=new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(eventAction.equals("keyTyped")){
					actionBinding.callAction(e);
					
				}
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(eventAction.equals("keyReleased")){
					actionBinding.callAction(e);
					
				}
				
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(eventAction.equals("keyPressed")){
					actionBinding.callAction(e);
					
				}
				
				
			}
			
		};
		jcombobox.addKeyListener(keyListener);
		
	  }
		else if(eventType==ComponentListener.class){
			componentListener=new ComponentListener() {
				
				@Override
				public void componentShown(ComponentEvent e) {
					if(eventAction.equals("componentShown")){
						actionBinding.callAction(e);
						
					}
					
					
				}
				
				@Override
				public void componentResized(ComponentEvent e) {
					if(eventAction.equals("componentResized")){
						actionBinding.callAction(e);
						
					}
					
					
				}
				
				@Override
				public void componentMoved(ComponentEvent e) {
					if(eventAction.equals("componentMoved")){
						actionBinding.callAction(e);
						
					}
					
				}
				
				@Override
				public void componentHidden(ComponentEvent e) {
					if(eventAction.equals("componentHidden")){
						actionBinding.callAction(e);
						
					}
					
					
				}
			};
			jcombobox.addComponentListener(componentListener);
		}
		else if(eventType==AncestorListener.class){
			ancestorListener=new AncestorListener() {
				
				@Override
				public void ancestorRemoved(AncestorEvent e) {
					if(eventAction.equals("ancestorRemoved")){
						actionBinding.callAction(e);
						
					}
					
					
				}
				
				@Override
				public void ancestorMoved(AncestorEvent e) {
					if(eventAction.equals("ancestorMoved")){
						actionBinding.callAction(e);
						
					}
					
					
				}
				
				@Override
				public void ancestorAdded(AncestorEvent e) {
					if(eventAction.equals("ancestorAdded")){
						actionBinding.callAction(e);
						
					}
					
					
				}
			};
			jcombobox.addAncestorListener(ancestorListener);
		}
		else
			logger.info("This event type "+eventType+" is not supported");
	}

	@Override
	public void unbind() {
		// TODO Auto-generated method stub
		
	}

}
