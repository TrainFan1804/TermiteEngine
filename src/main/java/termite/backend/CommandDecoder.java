package termite.backend;

/**
 * This type use the GoF Singleton pattern.
 * 
 * @author                              o.le
 * @version                             0.2
 * @since                               0.13
 */
public final class CommandDecoder {

    private static final CommandDecoder decoder = new CommandDecoder();

    public static CommandDecoder getDecoder() {

        return decoder;
    }

    private CommandDecoder() {}

    public CommandType decode(String input) {

        return CommandType.valueOf(input.toUpperCase());
    }
}
