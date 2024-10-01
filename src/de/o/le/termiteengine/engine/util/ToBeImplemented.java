package de.o.le.termiteengine.engine.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author o.le
 * @version 1.0
 * @since 1.4.4
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToBeImplemented {

	String message() default "Will be implemented properly in a future version.";
}
