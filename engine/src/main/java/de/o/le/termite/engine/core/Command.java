package de.o.le.termite.engine.core;

/**
 * This type represent the different available commands the user can enter into
 * the terminal to control the game flow.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 *
 * @deprecated This was replaced by {@link de.o.le.termite.backend.commands.CommandType}
 */
@Deprecated(since = "25-12-13")
public enum Command {

    // TODO add null pattern command?

    SAVE,
    LOAD,
    EXIT,
    HELP,

    // INV,
    // MAP,

    TALK,
    SEARCH,
    USE,
    GO,
    LEAVE;
}
