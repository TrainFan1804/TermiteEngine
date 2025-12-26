package de.o.le.termite.backend;

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
 */
public class CommandRegistry {

    private Map<CommandType, CommandHandler> commands = new HashMap<>();

    public void register(CommandType type, CommandHandler command) {
        this.commands.put(type, command);
    }

    public CommandHandler get(CommandType type) {
        return this.commands.getOrDefault(type, new NullCommand());
    }
}
