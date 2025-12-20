package de.o.le.termite.view;

import de.o.le.termite.backend.Engine;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.6
 */
public class TermiteController {

    private Engine engine;
    private Termite view;

    public TermiteController(Engine engine, Termite view) {

        this.engine = engine;
        this.view = view;
    }

    public void handleCommand(String input) {

        String ret = this.engine.processCommand(input);
        this.view.updatePlayArea(ret);
    }

    public String getCurrentRoomName() {

        return this.engine.getGameState().getCurrentRoom().getInfo().getName();
    }
}
