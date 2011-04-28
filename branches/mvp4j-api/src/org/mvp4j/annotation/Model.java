package org.mvp4j.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.mvp4j.AppController;

/**
 * <p>
 * The scope of this annotation is the view 
 * <p>
 * Use this to annotate the input component and bind it to the property name of the model
 * The value seized on the input component value will automatically stored in the value of associated property model
 * 
 * Example :
 * 
 * @Model(name="name")
 * TextField getTextFieldName(){
 * 	return textFieldName;
 * }
 * 
 * On the associated model we have 
 * 
 * public class TheModel{
 * 	private String name;
 * 
 * public void setName(String name){
 * 	this.name = name; 
 * }
 * <p>
 * The {@link AppController} will call the setter method(setName) to update model when the input text(textFieldName) 
 * value has been modified
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Model {
	
	/**
	 * @return The property name of the model, that used by component 
	 */
	String property();
	
	/**
	 * @return The initialization property name of the model, 
	 * that used by component that needs data to be displayed at rendering. for example a comboBox
	 */
	String initProperty() default "";
}
