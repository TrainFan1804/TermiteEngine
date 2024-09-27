package de.o.le.termiteengine.internal.core.subsystem.filesystem.load;

import de.o.le.termiteengine.internal.core.EngineResources;
import de.o.le.termiteengine.internal.core.service.output.MessageType;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.0
 */
@Deprecated
class LoadFileNameExtractor {

	String askForFileName() {

		EngineResources.INSTANCE.OUT.printMessage(MessageType.MSG_LOAD_ASK_FILE);
		String input = EngineResources.INSTANCE.IN.read();
		return input;
	}
}
