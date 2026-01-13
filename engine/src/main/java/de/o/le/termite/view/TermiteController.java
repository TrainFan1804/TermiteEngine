package de.o.le.termite.view;

import de.o.le.termite.backend.Engine;
import de.o.le.termite.dto.CommandContext;
import de.o.le.termite.dto.CommandResult;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.6
 */
public class TermiteController {

    private Engine engine;
    private Termite view;

    public TermiteController(Engine engine, Termite view) {

        this.engine = engine;
        this.view = view;
    }

    public void onGameStart() {

        CommandResult result = engine.loadGame();
        view.showMessage(result.getMessage());
        result.getContext().getRoom().ifPresent(view::showRoom);
    }

    public void handleCommand(String input) {

        CommandResult result = this.engine.processCommand(input);
        if (!result.isSuccess()) {
            this.view.showError(result.getMessage());
            return;
        }
        this.view.showMessage(result.getMessage());

        CommandContext ctx = result.getContext();
        ctx.getRoom().ifPresent(view::showRoom);
        ctx.getActionDescription().ifPresent(list -> {
            for (var desc : list) {
                view.showMessage(desc.toString());
            }
        });
        ctx.getInventoryDesc().ifPresent(list -> {
            for (var desc : list) {
                view.showMessage(desc.toString());
            }
        });
    }
}
