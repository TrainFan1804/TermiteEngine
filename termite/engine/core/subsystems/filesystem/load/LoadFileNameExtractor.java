package engine.core.subsystems.filesystem.load;

import engine.core.ApplicationResourcesSingleton;
import engine.core.services.output.MessageType;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.0
 */
@Deprecated
class LoadFileNameExtractor {

	String askForFileName() {

		ApplicationResourcesSingleton.INSTANCE.OUT.printMessage(MessageType.MSG_LOAD_ASK_FILE);
		String input = ApplicationResourcesSingleton.INSTANCE.IN.read();
		return input;
	}
}
