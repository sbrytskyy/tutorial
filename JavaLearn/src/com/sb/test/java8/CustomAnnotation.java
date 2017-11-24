/**
 * 
 */
package com.sb.test.java8;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Documented
@Retention(RUNTIME)
@Target(value = ElementType.METHOD)
/**
 * @author brytsse
 *
 */
public @interface CustomAnnotation {
	
	String author();
	boolean canRun() default true;

}
