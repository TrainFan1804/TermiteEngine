package de.o.le.termite.util;

import de.o.le.termite.backend.Engine;

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

    public static void disableLogging() {

        Logger l = LogManager.getLogManager().getLogger(Engine.class.getName());
        l.severe("Loggin has been disabled globally! This option shouldn't be used.");
        Level level = Level.OFF;
        CONSOLE_HANDLER.setLevel(level);

        // alle existierenden Logger aktualisieren
        LogManager.getLogManager()
                .getLoggerNames()
                .asIterator()
                .forEachRemaining(name -> {
                    Logger logger = Logger.getLogger(name);
                    logger.setLevel(level);
                });
    }

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
