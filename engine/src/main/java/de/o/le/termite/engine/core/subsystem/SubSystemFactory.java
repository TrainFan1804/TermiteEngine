package de.o.le.termite.engine.core.subsystem;

import de.o.le.termite.engine.core.Command;
import de.o.le.termite.engine.core.subsystem.exit.EXSFacade;
import de.o.le.termite.engine.core.subsystem.help.HSFacade;
import de.o.le.termite.engine.core.subsystem.load.LSFacade;
import de.o.le.termite.engine.core.subsystem.save.SSFacade;

/**
 * To 'create' the {@link EngineSubsystem} instances you must use this factory
 * class.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.31
 */
public final class SubSystemFactory {

    	private static final SubSystemFactory FACTORY = new SubSystemFactory();

	/**
	 * Because this class was designed as a singleton you can get the
	 * instance with this method.
	 * 
	 * @return The SubSystemFactory instance.
	 */
    	public static SubSystemFactory getFactory() { return FACTORY; }
    
    	private final CommandInstanceEventMapper MAPPER;
    
	/**
	 * Private constructor.
	 */
    	private SubSystemFactory() {
        
        	this.MAPPER = new CommandInstanceEventMapper();
    	}

	/**
	 * Get the system that belong to the entered command.
	 * 
	 * @param command The entered command by the player.
	 * @return The subsystem that should start his routine.
	 */
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
