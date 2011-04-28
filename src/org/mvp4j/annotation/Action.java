package org.mvp4j.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.mvp4j.AppController;

/**
 * <p>
 * The scope of this annotation is the view, use this annotation to define 
 * an action to be executed when a certain event has happened in a component of the view. 
 * the action to be executed is a method presenter with the same name as the action annotation
 *<p>
 * Example with an action in the view : 
 
 	@Action(name="addItem")
	 public Button getAddButton(){
	 	return new Button();
	 }
	 
 * In the presenter we have to define a method with the same name as the action
 	
 	public void addItem(){
 		doSomething();
	}
	
 * <p>
 * The {@link AppController} will call the method addItem when the user click on the button
 * <p>
 * We can add a parameter as an EventObect :
 * in this case the runtime will call addItem 
 * with the eventObject associated to the current event
 * 
 * public void addItem(EventObject event){
 *  doSomething();
 * } 
 * 
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Action {

	/**
	 * 
	 * @return the action name
	 */

	String name();
	
	/**
	 * Optional Event type to add a specific event depending on the component
	 * 
	 * @return the type of event
	 */
	Class<?> EventType() default Action.class;
	/**
	 * 
	 * @return the method within the event's supported methods that it will be implemented
	 */
	String EventAction() default "";
}
