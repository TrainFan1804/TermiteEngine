package termite.backend.commands;

/**
 * This type use the GoF Singleton pattern.
 * 
 * @author                              o.le
 * @version                             1.1
 * @since                               0.13
 */
public final class CommandDecoder {

    private static final CommandDecoder decoder = new CommandDecoder();

    public static CommandDecoder getDecoder() {

        return decoder;
    }

    private CommandDecoder() {}

    public CommandAction decode(String input) {

        CommandType type = CommandType.valueOf(input.toUpperCase());
        return CommandController.getController().getCommandAction(type);
    }
}
