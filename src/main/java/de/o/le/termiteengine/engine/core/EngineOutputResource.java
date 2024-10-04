package de.o.le.termiteengine.engine.core;

import de.o.le.termiteengine.engine.core.service.output.OuputContentHandler;
import de.o.le.termiteengine.engine.core.service.output.OutputService;
import de.o.le.termiteengine.engine.util.ToBeImplemented;

/**
 * @author o.le
 * @version 1.0
 * @since 1.4.6
 */
public final class EngineOutputResource {

	@ToBeImplemented(message = "Should find a way to use the new ResourceLoader"
		+ " but first I need to find a way that the path will be converted"
		+ " to an InputStream")
	private static String pathToOutputContent = "src/main/resources/de/o/le/termiteengine/engine/core/default.json";
	 // private static String pathToOutputContent = ResourceLoader.loadRes(EngineResources.class, "default.json");

	private static EngineOutputResource INSTANCE; 

	public static EngineOutputResource getInstance() { 
		
		if (INSTANCE == null ) INSTANCE = new EngineOutputResource();

		return INSTANCE; 
	}

	public static void changeMessagePath(String path) {

		pathToOutputContent = path;
	}

	public final OutputService OUT;

	private EngineOutputResource() { 
	
		this.OUT = new OutputService();

		// TODO call jsonvalidator here for validate custom output / just for
		// custom path. Can be skipped if never calles EngineOutputResources.changeMessagePath(String)
		OuputContentHandler.init(pathToOutputContent);
	}
}
