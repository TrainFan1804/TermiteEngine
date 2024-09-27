package engine.core.services;

import engine.core.Command;
import engine.core.subsystems.SubSystemFactory;
import engine.core.subsystems.EngineSubsystem;

/**
 * This service will determine what {@link EngineSubsystem} will handle the
 * the given {@link Command}.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
public class CommandDeterminationService {

    private final SubSystemFactory FACTORY = SubSystemFactory.getFactory();

    public EngineSubsystem determineEngineSubsystem(Command command) {

        return this.FACTORY.getSystem(command);
    }
}
