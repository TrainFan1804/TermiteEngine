package de.o.le.termite.util;

import java.util.logging.*;

/**
 * Simple logger facade.
 *
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.6
 */
public class LogService {

    private static boolean INITIALIZED = false;
    private static final ConsoleHandler CONSOLE_HANDLER = new ConsoleHandler();

    private final Logger LOGGER;

    public LogService(String name) {
        this.LOGGER = Logger.getLogger(name);
        this.LOGGER.setUseParentHandlers(false);

        if (!INITIALIZED) {
            Formatter formatter = new LogFormatter();
            CONSOLE_HANDLER.setFormatter(formatter);
            CONSOLE_HANDLER.setLevel(Level.ALL);
            INITIALIZED = true;
        }

        this.LOGGER.addHandler(CONSOLE_HANDLER);
        this.LOGGER.setLevel(Level.ALL);
    }

    public void info(String msg) { LOGGER.info(msg); }

    public void warning(String msg) { LOGGER.warning(msg); }

    public void error(String msg) { LOGGER.severe(msg); }

    public void config(String msg) { LOGGER.config(msg); }

    public void filesystem(String msg) { LOGGER.fine(msg); }

    public void gameEvents(String msg) { LOGGER.finer(msg); }
}
