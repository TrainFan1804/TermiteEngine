package de.o.le.termite.engine.core.service;

import de.o.le.termite.engine.core.subsystem.EngineSubsystem;

/**
 * This service take an {@link EngineSubsystem} and will delegate the engine
 * call to the given subsystem.
 * @author 				o.le
 * @version 				1.0
 * @since				0.38
 */
public class SystemDelegationService {
	
	/**
	 * Delegate the engine call to the given EngineSubsytem.
	 * 
	 * @param system The system that will handle the engine call.
	 */
	public void delegate(EngineSubsystem system) { system.execute(); }
}
