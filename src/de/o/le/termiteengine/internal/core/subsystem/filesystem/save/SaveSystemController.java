package de.o.le.termiteengine.internal.core.subsystem.filesystem.save;

import de.o.le.termiteengine.internal.core.EngineResources;
import de.o.le.termiteengine.internal.core.service.output.MessageType;
import de.o.le.termiteengine.internal.core.subsystem.filesystem.util.ExitFileMenuException;
import de.o.le.termiteengine.internal.core.subsystem.filesystem.util.FileConnection;
import de.o.le.termiteengine.internal.core.subsystem.filesystem.util.FileNameExtractor;

/**
 * @author o.le
 * @version 1.1
 * @since 1.1.1
 */
final class SaveSystemController {

	private final EngineResources RES;

	SaveSystemController() {

		this.RES = EngineResources.getInstance();
	}

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

			this.RES.OUT.printMessage(MessageType.MSG_SAVE_CANCEL);
		}
	}

	private void requestOverride() throws ExitFileMenuException {

		this.RES.OUT.printMessage(MessageType.MSG_SAVE_OVR_FILE);

		String input;
		do {

			input = this.RES.IN.read().toUpperCase();

			if (input.equals("N")) throw new ExitFileMenuException(); 

			// move this line because this will also be printed when
			// entered "Y"
			this.RES.OUT.printMessage(MessageType.MSG_WRONG_INPUT);
		} while(!input.equals("Y"));
	}
}
