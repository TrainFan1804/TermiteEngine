package de.o.le.termite.backend.manager.state;

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
                gs.getInventory().asStringList()
        );
    }
}
