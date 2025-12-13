package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.GameState;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.13
 */
public class LookCommand {

    public String look(List<String> args) {

        return GameState.getInstance().getCurrentRoom().getDescription();
    }
}
