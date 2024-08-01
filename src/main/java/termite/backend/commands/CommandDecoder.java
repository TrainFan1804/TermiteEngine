package termite.backend.commands;

/**
 * This class will decode the input from the user to a useable 
 * {@link CommandAction}.
 * <p>
 * This type use the GoF Singleton pattern.
 * 
 * @author                              o.le
 * @version                             1.3
 * @since                               0.13
 */
public final class CommandDecoder {

    private static final CommandDecoder decoder = new CommandDecoder();

    public static CommandDecoder getDecoder() {

        return decoder;
    }

    private CommandDecoder() {}

    /**
     * Decode the input to a {@link CommandAction}.
     * 
     * @param input                     The users input.
     * @return                          An {@link CommandAction} when the input.
     * @throws IllegalArgumentException When the given input was invalid.
     */
    public CommandAction decode(String input) {

        CommandType type = CommandType.valueOf(input.toUpperCase());
        return CommandController.getController().getCommandAction(type);
    }
}
