package de.o.le.termiteengine.api;

import de.o.le.termiteengine.engine.core.EngineResources;

/**
 * This class provide a interface to the engine output system that allow you to
 * delegate the wanted output to the engine.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.6
 */
public final class EngineOutput {

	private static final EngineResources RES = EngineResources.getInstance();

	public static void out(String str) { RES.OUT.printString(str); }

	private EngineOutput() { }
}
