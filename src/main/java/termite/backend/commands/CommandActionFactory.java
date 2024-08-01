package termite.backend.commands;

import java.util.Map;
import java.util.HashMap;

/**
 * This type use the GoF Singleton pattern.
 * 
 * @author                              o.le
 * @version                             0.2
 * @since                               0.15
 */
final class CommandActionFactory {

    private static final CommandActionFactory factory = new CommandActionFactory();

    private static final Map<CommandType, CommandAction> commands;

    static {

        commands = new HashMap<>();

        commands.put(CommandType.SAVE, new SaveCommand());
        commands.put(CommandType.LOAD, new LoadCommand());
        commands.put(CommandType.EXIT, new ExitCommand());
        commands.put(CommandType.HELP, new HelpCommand());
    }

    public static CommandActionFactory getFactory() {

        return factory;
    }

    private CommandActionFactory() {}

    public CommandAction getCommand(CommandType command) {

        return commands.get(command);
    }
}
