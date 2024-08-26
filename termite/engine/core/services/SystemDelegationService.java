package engine.core.services;

import engine.core.subsystems.EngineSubsystem;

/**
 * @author 				o.le
 * @version 				1.00
 * @since				0.38
 */
public class SystemDelegationService {
	
	public void delegate(EngineSubsystem system) { system.execute(); }
}
