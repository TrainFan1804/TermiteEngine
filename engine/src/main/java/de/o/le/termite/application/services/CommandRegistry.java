package de.o.le.termite.application.services;

import de.o.le.termite.application.commands.CommandParser;

import de.o.le.termite.core.commands.ICommandHandler;
import de.o.le.termite.core.commands.CommandType;
import de.o.le.termite.core.commands.NullCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * This registry hold all {@link ICommandHandler} that the engine support.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.26
 * @deprecated                          This registry class is declared as deprecated
 * but might be reimplemented in the future because it <b>could</b> be useful to
 * track all {@link ICommandHandler} to reduce object creation in {@link CommandParser}
 */
@Deprecated(since = "26.01.13", forRemoval = false)
public class CommandRegistry {

    // The CommandType type could be replaced with a String or an inner class called CommandType
    private Map<CommandType, ICommandHandler> commands = new HashMap<>();

    public void register(CommandType type, ICommandHandler command) {
        this.commands.put(type, command);
    }

    public ICommandHandler get(CommandType type) {
        return this.commands.getOrDefault(type, new NullCommand());
    }
}
