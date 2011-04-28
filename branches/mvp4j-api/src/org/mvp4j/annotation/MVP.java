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
 * Use this to annotate a class as view and associate two class as presenter and model view
 * <p>
 * Example :
 * 
 * @MVP(viewClass = ClientPresenter.class, modelClass = ClientModel.class)
 * public class ClientFrame extends JFrame{
 * 	
 * }
 * 
 * The {@link AppController#processView(Class)} will analyse this annotation and associate the with presenter and model classes
 *  
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MVP {
	/**
	 * Specify the model class of the current view 
	 * 
	 */
	public Class<?> modelClass();
	/**
	 * Specify the presenter class of the current view 
	 * 
	 */
	public Class<?> presenterClass();

}
