package de.o.le.termite.infrastructure.persistance.utils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation can be placed on different Game Objects inside the
 * {@link de.o.le.termite.core.model} package to enforce object ids on
 * game object creation.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectId { }
