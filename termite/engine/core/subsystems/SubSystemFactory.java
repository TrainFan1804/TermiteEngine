package engine.core.subsystems;

import engine.core.Command;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.31
 */
public final class SubSystemFactory {

    private static final SubSystemFactory FACTORY = new SubSystemFactory();

    public static SubSystemFactory getFactory() { return FACTORY; }
    
    private final CommandInstanceEventMapper MAPPER;
    
    private SubSystemFactory() {
        
        this.MAPPER = new CommandInstanceEventMapper();
    }

    public EngineCommandSystem getSystem(Command command) {
        
        return switch(command) {
            
            case SAVE -> new SaveSystem();
            case LOAD -> new LoadSystem();
            case EXIT -> new ExitSystem();
            case HELP -> new HelpSystem();
            // case INV -> new NullSystem();
            // case MAP -> new NullSystem();
            default -> new EventSystem(this.MAPPER
                                        .mapCommandToInstanceEventType(command));
        };
    }
}
