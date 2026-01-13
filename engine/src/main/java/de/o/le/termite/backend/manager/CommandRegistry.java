package de.o.le.termite.backend.manager;

import de.o.le.termite.backend.commands.CommandHandler;
import de.o.le.termite.backend.commands.CommandType;
import de.o.le.termite.backend.commands.NullCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * This registry hold all {@link CommandHandler} that the engine support.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.26
 * @deprecated                          This registry class is declared as deprecated
 * but might be reimplemented in the future because it <b>could</b> be useful to
 * track all {@link CommandHandler} to reduce object creation in {@link de.o.le.termite.backend.commands.CommandParser}
 */
@Deprecated(since = "26.01.13", forRemoval = false)
public class CommandRegistry {

    // The CommandType type could be replaced with a String or an inner class called CommandType
    private Map<CommandType, CommandHandler> commands = new HashMap<>();

    public void register(CommandType type, CommandHandler command) {
        this.commands.put(type, command);
    }

    public CommandHandler get(CommandType type) {
        return this.commands.getOrDefault(type, new NullCommand());
    }
}
