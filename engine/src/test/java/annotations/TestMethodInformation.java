package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author o.le
 * @version 1.2
 * @since 1.2.4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestMethodInformation {

	String targetMethod();
	String behavior();
	boolean isStatic() default false;
}
