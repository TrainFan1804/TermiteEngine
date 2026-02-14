package de.o.le.termite.application.commands;

import de.o.le.termite.application.services.CommandRegistry;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.13
 * @deprecated                          See deprecated annotation in {@link CommandRegistry}.
 * This might be still be removed.
 */
@Deprecated(since = "26.01.13", forRemoval = false)
public enum CommandType {
    WALK,
    LOOK,
    SHOW,
    INV
}
