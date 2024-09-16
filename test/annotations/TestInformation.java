package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author o.le
 * @version 1.1
 * @since 1.2.4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestInformation {

	Class<?> testedClass();
	String[] testedMethod();
	String behavior();
	boolean isStatic() default false;
}
