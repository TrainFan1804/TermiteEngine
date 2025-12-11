package de.o.le.termite.view;

import de.o.le.termite.backend.Engine;
import de.o.le.termite.engine.core.Command;
import de.o.le.termite.engine.core.service.CommandDecodeService;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.6
 */
public class TermiteController {

    private Engine engine;
    private Termite view;

    private CommandDecodeService decodeService;

    public TermiteController(Engine engine, Termite view) {

        this.engine = engine;
        this.view = view;

        this.decodeService = new CommandDecodeService();
    }

    public void handleCommand(String command) {

        Command c = this.decodeService.commandDecode(command);
        if (c != null) {
            String ret = this.engine.processCommand(c);
            this.view.updatePlayArea(ret);
        } else {
            this.view.updatePlayArea("Unknown command");
        }
    }
}
