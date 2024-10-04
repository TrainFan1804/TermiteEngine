package de.o.le.termiteengine.engine.core;

import de.o.le.termiteengine.engine.core.service.InputService;

/**
 * @author o.le
 * @version 1.0
 * @since 1.4.6
 */
public final class EngineInputResource {

	private static EngineInputResource INSTANCE; 

	public static EngineInputResource getInstance() { 
		
		if (INSTANCE == null ) INSTANCE = new EngineInputResource();

		return INSTANCE; 
	}


	public final InputService IN;

	private EngineInputResource() { 
	
		this.IN = new InputService();

	}
}
