package de.o.le.termite.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple logger facade.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.6
 */
public class LogService {

    private static final ConsoleHandler CONSOLE_HANDLER = new ConsoleHandler();
    private final Logger LOGGER;

    public LogService(String name) {
        this.LOGGER = Logger.getLogger(name);
        this.LOGGER.setUseParentHandlers(false);

        // bit useless to set formatter and level each time a service
        // is created but idc
        Formatter formatter = new LogFormatter();
        CONSOLE_HANDLER.setFormatter(formatter);
        CONSOLE_HANDLER.setLevel(Level.ALL);

        this.LOGGER.addHandler(CONSOLE_HANDLER);

        this.LOGGER.setLevel(Level.ALL);
    }

    public void info(String msg) { LOGGER.info(msg); }

    public void warning(String msg) { LOGGER.warning(msg); }

    public void error(String msg) { LOGGER.severe(msg); }
}
