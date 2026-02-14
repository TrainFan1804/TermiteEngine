package de.o.le.termite.core.model;

import java.util.Objects;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.02.14
 */
public class ModelIdGenerator {

    public static String generateId(Object obj) {

        int hash = Objects.hash(obj);
        return obj.getClass().getSimpleName() + "_" + hash;
    }
}
