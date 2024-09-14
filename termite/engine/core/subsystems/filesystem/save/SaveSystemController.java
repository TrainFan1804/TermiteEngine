package engine.core.subsystems.filesystem.save;

import engine.core.ApplicationResources;
import engine.core.services.output.MessageType;
import engine.core.subsystems.filesystem.utils.FileConnection;

/**
 * @author o.le
 * @version 1.0
 * @since 1.1.1
 */
class SaveSystemController {

	void init() {
		
		try {

			SaveFileNameExtractor extractor = new SaveFileNameExtractor();
			String fileName = extractor.extractFileName();

			FileConnection con = new FileConnection(fileName);
			if (con.getConnection().exists()) this.requestOverride();

			SaveFileGenerator fileGenerator = new SaveFileGenerator();
			fileGenerator.generateSaveFile(new FileConnection(fileName));

		} catch (ExitSaveMenuException e) {

			ApplicationResources.OUT.printMessage(MessageType.MSG_SAVE_CANCEL);
		}
	}

	private void requestOverride() throws ExitSaveMenuException {

		ApplicationResources.OUT.printMessage(MessageType.MSG_SAVE_OVR_FILE);

		String input;
		do {

			input = ApplicationResources.IN.read().toUpperCase();

			if (input.equals("N")) throw new ExitSaveMenuException(); 

			ApplicationResources.OUT.printMessage(MessageType.MSG_WRONG_INPUT);
		} while(!input.equals("Y"));
	}
}
