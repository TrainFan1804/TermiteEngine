package termite.backend.commands;

/**
 * This class will controll the command flow of the game. This class is only
 * used in {@link CommandDecoder}.
 * <p>
 * This type use the GoF Singleton pattern.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.15
 */
final class CommandController {

    private static final CommandController controller = new CommandController();

    private final CommandActionFactory factory;

    public static CommandController getController() {

        return controller;
    }

    private CommandController() {

        this.factory = CommandActionFactory.getFactory();
    }

    public CommandAction getCommandAction(CommandType command) {
        
        return this.factory.getCommand(command);
    }
}
