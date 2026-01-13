package de.o.le.termite.backend.utils;

import de.o.le.termite.backend.utils.annotations.InjectId;

import java.lang.reflect.Field;
import java.nio.file.Path;

/**
 * This injector will inject ids on objects with an {@link InjectId} annotation.
 * <p>
 *     The id is build from the name of the file name from the correspondence
 *     JSON file.
 * </p>
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.13
 */
public class IdInjector {

    private IdInjector() { }

    public static void inject(Object target, Path source) {

        Class<?> targetClass = target.getClass();

        for (Field field : targetClass.getDeclaredFields()) {

            if (!field.isAnnotationPresent(InjectId.class)) {
                continue;
            }

            field.setAccessible(true);
            try {
                field.set(target, source.getFileName().toString());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
