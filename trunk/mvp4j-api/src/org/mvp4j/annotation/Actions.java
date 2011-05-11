package org.mvp4j.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * <p>
 * The scope of this annotation is the view, use this annotation to define more than one action  
 * in the same view component 
 *<p>
 */


@Retention(RetentionPolicy.RUNTIME)

public @interface Actions {

	Action[] value();
}
