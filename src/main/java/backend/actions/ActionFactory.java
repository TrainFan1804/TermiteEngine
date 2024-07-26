package backend.actions;

/**
 * This type will transform a {@link CommandType} into an {@link Action} subtype.
 * <p>
 * This factory is designed like the GoF Factory pattern.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.8
 */
public class ActionFactory {

    private static ActionFactory actionFactory;
    
    /**
     * Get a ActionFactory object.
     * 
     * @return                          The created factory. The factory will
     *                                  always be the same object.
     */
    public static ActionFactory getFactory() {

        if (actionFactory == null) {

            actionFactory = new ActionFactory();
        }

        return actionFactory;
    }

    /** Private constructor */
    private ActionFactory() {}

    /**
     * This method will transform the given command into a action.
     * 
     * @param command                   The command that should be transformed.
     * @return                          The transformed action. Will never be 
     *                                  {@code null}.
     */
    public Action commandToAction(CommandType command) {

        switch (command) {
            case SAVE: return new SaveAction();
            case EXIT: return new ExitAction();
            case GO: return new GoAction();
            case HELP: return new HelpAction();
            case INV: return new InventoryAction();
            case LEAVE: return new LeaveAction();
            case LOAD: return new LoadAction();
            case MAP: return new MapAction();
            case SEARCH: return new SearchAction();
            case TALK: return new TalkAction();
            case USE: return new UseAction();
        }

        /*
         * This method will never return null because the all command types are
         * in the switch case above.
         */
        return null;
    }
}
