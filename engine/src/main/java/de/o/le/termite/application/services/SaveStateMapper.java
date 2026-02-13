package de.o.le.termite.application.services;

import de.o.le.termite.core.state.GameState;
import de.o.le.termite.core.state.SaveState;

/**
 * Static Class to map {@link GameState} to {@link SaveState}
 * <p>
 *     This class only exists to prevent high coupling between <b>SaveState</b>
 *     and <b>GameState</b>.
 * </p>
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public class SaveStateMapper {

    private SaveStateMapper() { }

    public static SaveState from(GameState gs) {
        return new SaveState(
                gs.getCurrentRoom().getRoomId(),
                InventoryService.asStringList(gs.getInventory())
        );
    }
}
