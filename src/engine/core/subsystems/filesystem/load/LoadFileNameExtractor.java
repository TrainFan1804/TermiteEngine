package engine.core.subsystems.filesystem.load;

import engine.core.EngineResources;
import engine.core.services.output.MessageType;

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
