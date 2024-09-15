package engine.core.subsystems.filesystem.load;

import engine.core.ApplicationResources;
import engine.core.services.output.MessageType;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.0
 */
@Deprecated
class LoadFileNameExtractor {

	String askForFileName() {

		ApplicationResources.OUT.printMessage(MessageType.MSG_LOAD_ASK_FILE);
		String input = ApplicationResources.IN.read();
		return input;
	}
}
