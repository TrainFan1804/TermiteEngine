package de.o.le.termite.engine.core.service;

import de.o.le.termite.engine.core.Command;
import de.o.le.termite.engine.core.subsystem.SubSystemFactory;
import de.o.le.termite.engine.core.subsystem.EngineSubsystem;

/**
 * This service will determine what {@link EngineSubsystem} will handle the
 * the given {@link Command}.
 * <p>
 * A Subsystem is <b>NOT</b> a service! To see what the definition of a subsystem
 * is see the package-info.java in the subsytem package.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
public class CommandDeterminationService {

    	private final SubSystemFactory FACTORY = SubSystemFactory.getFactory();

    	/**
     	* Will determine what subsystem will handle the given command.
     	* 
     	* @param command The command that should be handled by a subsystem.
     	* @return The subsystem that will handle the command.
     	*/
    	public EngineSubsystem determineEngineSubsystem(Command command) {

        	return this.FACTORY.getSystem(command);
   	}
}
