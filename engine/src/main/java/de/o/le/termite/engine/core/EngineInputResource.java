package de.o.le.termite.engine.core;

import de.o.le.termite.engine.core.service.InputService;
import de.o.le.termite.engine.util.ToBeImplemented;

/**
 * You can use this class directly to ask the player for input on the terminal.
 * This is just a simple api to the {@link InputService} to get input from the
 * terminal engine wide.
 * <p>
 * TODO right now you should use this class to handle inputs for your game.
 * In a future version there will be a public api that can be used instead. 
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.6
 */
@ToBeImplemented(message = "In a future version this class will have a public api"
	+ " so you don't need to use a engine class directly anymore")
public final class EngineInputResource {

	private static EngineInputResource INSTANCE; 

	/**
	 * Because this class is designed as a singleton you can get the instance
	 * with this method.
	 * 
	 * @return The saved instance.
	 */
	public static EngineInputResource getInstance() { 
		
		if (INSTANCE == null ) INSTANCE = new EngineInputResource();

		return INSTANCE; 
	}


	/**
	 * Public field for the {@link InputService}.
	 */
	public final InputService IN;

	/**
	 * A private constructor.
	 */
	private EngineInputResource() { 
	
		this.IN = new InputService();

	}
}
