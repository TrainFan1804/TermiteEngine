package de.o.le.termiteengine.engine.filesystem;

import de.o.le.termiteengine.engine.core.EngineResources;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Just a internal logger class that will log errors that may appear in the
 * engines filesystem handling.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.5
 */
class ErrorLogger {

	private static final ErrorLogger INSTANCE = new ErrorLogger();

	static ErrorLogger getInstance() { return INSTANCE; }

	private final Logger LOGGER;

	private ErrorLogger() {

		this.LOGGER = Logger.getLogger(ErrorLogger.class.getName());
	}

	void log(Collection<?> errorCollection) {

		try {
			final FileHandler handler = new FileHandler("error_log.log", false);
			this.LOGGER.addHandler(handler);

			final SimpleFormatter formatter = new SimpleFormatter();
			handler.setFormatter(formatter);

			for (var error: errorCollection) {

				this.LOGGER.warning(error.toString());
			}

			handler.close();
		} catch (IOException e) {

			EngineResources.getInstance().OUT.printError(e);
		}
	}
}
