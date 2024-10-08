package de.o.le.termite.engine.core;

import de.o.le.termite.engine.core.service.output.OuputContentHandler;
import de.o.le.termite.engine.core.service.output.OutputService;
import de.o.le.termite.engine.util.ToBeImplemented;
import java.io.File;

/**
 * You can use this class directly to ask the player for input on the terminal.
 * This is just a simple api to the {@link OutputService} to get input from the
 * terminal engine wide.
 * <p>
 * TODO right now you should use this class to handle outputs for your game.
 * In a future version there will be a public api that can be used instead. 
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.6
 */
@ToBeImplemented(message = "In a future version this class will have a public api"
	+ " so you don't need to use a engine class directly anymore")
public final class EngineOutputResource {

	@ToBeImplemented(message = "Should find a way to use the new ResourceLoader"
		+ " but first I need to find a way that the path will be converted"
		+ " to an InputStream")
	private static String pathToOutputContent = "src/main/resources/de/o/le/termiteengine/engine/core/default.json";
	 // private static String pathToOutputContent = ResourceLoader.loadRes(EngineResources.class, "default.json");

	private static EngineOutputResource INSTANCE; 

	/**
	 * Because this class is designed as a singleton you can get the instance
	 * with this method.
	 * 
	 * @return The saved instance.
	 */
	public static EngineOutputResource getInstance() { 
		
		if (INSTANCE == null ) INSTANCE = new EngineOutputResource();

		return INSTANCE; 
	}

	/**
	 * You can modify the path to the default messages. Using this to set
	 * the engine outputs to your defined messages. Should only used once.
	 * 
	 * @param path The path to your custom message file.
	 */
	public static void changeMessagePath(String path) {

		pathToOutputContent = path;
	}

	/**
	 * Public field for the {@link OutputService}.
	 */
	public final OutputService OUT;

	/**
	 * A private constructor.
	 */
	private EngineOutputResource() { 
	
		this.OUT = new OutputService();

		// TODO call jsonvalidator here for validate custom output / just for
		// custom path. Can be skipped if never calles EngineOutputResources.changeMessagePath(String)
		final File file = new File(pathToOutputContent);
		OuputContentHandler.init(file);
	}
}
