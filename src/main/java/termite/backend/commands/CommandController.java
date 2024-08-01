package termite.backend.commands;

/**
 * This type use the GoF Singleton pattern.
 * 
 * @author                              o.le
 * @version                             0.6
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
