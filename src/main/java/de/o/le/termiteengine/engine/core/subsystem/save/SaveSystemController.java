package de.o.le.termiteengine.engine.core.subsystem.save;

import de.o.le.termiteengine.engine.core.EngineInputResource;
import de.o.le.termiteengine.engine.core.EngineOutputResource;
import de.o.le.termiteengine.engine.core.service.output.MessageType;
import de.o.le.termiteengine.engine.core.subsystem.util.ExitFileMenuException;
import de.o.le.termiteengine.engine.core.subsystem.util.FileNameExtractor;
import java.io.File;

/**
 * This class is a controller to control the save routine. Will handle exceptions,
 * save order, etc.
 * 
 * @author o.le
 * @version 1.2
 * @since 1.1.1
 */
final class SaveSystemController {

	private final EngineOutputResource RES;

	/**
	 * Create a SaveSystemController.
	 */
	SaveSystemController() {

		this.RES = EngineOutputResource.getInstance();
	}

	/*
	TODO this is bad very very bad..
	*/
	/**
	 * Initialize the controller. 
	 */
	void init() {
		
		// I could extract some methods e.g. one for file name asking,
		// one for connection etc. but I don't want to do this
		try {

			FileNameExtractor extractor = new FileNameExtractor();
			String fileName = extractor.extractFileName(MessageType.MSG_SAVE_ASK_FILE);

			File file = new File(fileName + ".json");
			if (file.exists()) this.requestOverride();

			SaveFileGenerator fileGenerator = new SaveFileGenerator();
			fileGenerator.generateSaveFile(file);

		} catch (ExitFileMenuException e) {

			this.RES.OUT.printMessage(MessageType.MSG_SAVE_CANCEL);
		}
	}

	/**
	 * When a file with the entered name already exist ask the user if he
	 * want to override the file.
	 * 
	 * @throws ExitFileMenuException Will end the save routine.
	 */
	private void requestOverride() throws ExitFileMenuException {

		this.RES.OUT.printMessage(MessageType.MSG_SAVE_OVR_FILE);

		String input;
		do {

			input = EngineInputResource.getInstance().IN.read().toUpperCase();

			if (input.equals("N")) throw new ExitFileMenuException(); 

			// move this line because this will also be printed when
			// entered "Y"
			this.RES.OUT.printMessage(MessageType.MSG_WRONG_INPUT);
		} while(!input.equals("Y"));
	}
}
