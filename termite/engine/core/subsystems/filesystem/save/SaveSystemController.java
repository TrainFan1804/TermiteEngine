package engine.core.subsystems.filesystem.save;

import engine.core.ApplicationResources;
import engine.core.services.output.MessageType;
import engine.core.subsystems.filesystem.utils.ExitFileMenuException;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.filesystem.utils.FileNameExtractor;

/**
 * @author o.le
 * @version 1.1
 * @since 1.1.1
 */
final class SaveSystemController {

	void init() {
		
		// I could extract some methods e.g. one for file name asking,
		// one for connection etc. but I don't want to do this
		try {

			FileNameExtractor extractor = new FileNameExtractor();
			String fileName = extractor.extractFileName(MessageType.MSG_SAVE_ASK_FILE);

			FileConnection con = new FileConnection(fileName);
			if (con.getConnection().exists()) this.requestOverride();

			SaveFileGenerator fileGenerator = new SaveFileGenerator();
			fileGenerator.generateSaveFile(new FileConnection(fileName));

		} catch (ExitFileMenuException e) {

			ApplicationResources.OUT.printMessage(MessageType.MSG_SAVE_CANCEL);
		}
	}

	private void requestOverride() throws ExitFileMenuException {

		ApplicationResources.OUT.printMessage(MessageType.MSG_SAVE_OVR_FILE);

		String input;
		do {

			input = ApplicationResources.IN.read().toUpperCase();

			if (input.equals("N")) throw new ExitFileMenuException(); 

			ApplicationResources.OUT.printMessage(MessageType.MSG_WRONG_INPUT);
		} while(!input.equals("Y"));
	}
}
