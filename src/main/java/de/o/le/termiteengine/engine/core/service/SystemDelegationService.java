package de.o.le.termiteengine.engine.core.service;

import de.o.le.termiteengine.engine.core.subsystem.EngineSubsystem;

/**
 * @author 				o.le
 * @version 				1.0
 * @since				0.38
 */
public class SystemDelegationService {
	
	public void delegate(EngineSubsystem system) { system.execute(); }
}
