package de.o.le.termite.engine.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used when a method / type signature is already existing but
 * must still be implemented right.
 * 
 * @author o.le
 * @version 1.2
 * @since 1.4.4
 */
@Target({ElementType.METHOD,
	ElementType.TYPE,
	ElementType.FIELD,
	ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToBeImplemented {

	String message() default "Will be implemented properly in a future version.";
}
