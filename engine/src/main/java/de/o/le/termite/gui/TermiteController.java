package de.o.le.termite.gui;

import de.o.le.termite.Engine;
import de.o.le.termite.core.commands.CommandResult;
import de.o.le.termite.application.dto.trans.TransContext;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.6
 */
public class TermiteController {

    private Engine engine;
    private Termite view;
    private ViewTransContextVisitor visitor;

    public TermiteController(Engine engine, Termite view) {

        this.engine = engine;
        this.view = view;
        this.visitor = new ViewTransContextVisitor(this.view);
    }

    public void onGameStart() {

        CommandResult result = engine.loadGame();
        view.showMessage(result.getMessage());
        result.getCtx().accept(this.visitor);
    }

    public void handleCommand(String input) {

        CommandResult result = this.engine.processCommand(input);
        if (!result.isSuccess()) {
            this.view.showError(result.getMessage());
            return;
        }
        this.view.showMessage(result.getMessage());

        TransContext t = result.getCtx();
        // TODO this is ugly?
        if (t != null) {
            t.accept(this.visitor);
        }
    }
}
