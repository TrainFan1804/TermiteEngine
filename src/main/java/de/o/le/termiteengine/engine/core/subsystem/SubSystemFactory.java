package de.o.le.termiteengine.engine.core.subsystem;

import de.o.le.termiteengine.engine.core.Command;
import de.o.le.termiteengine.engine.core.subsystem.exit.EXSFacade;
import de.o.le.termiteengine.engine.core.subsystem.help.HSFacade;
import de.o.le.termiteengine.engine.core.subsystem.load.LSFacade;
import de.o.le.termiteengine.engine.core.subsystem.save.SSFacade;

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

    public EngineSubsystem getSystem(Command command) {
        
        return switch(command) {
            
            case SAVE -> SSFacade.getSystem(); 
            case LOAD -> LSFacade.getSystem();
            case EXIT -> EXSFacade.getSystem();
            case HELP -> HSFacade.getSystem();
            // case INV -> new NullSystem();
            // case MAP -> new NullSystem();
            default -> new EventSystem(this.MAPPER
                                        .mapCommandToInstanceEventType(command));
        };
    }
}
