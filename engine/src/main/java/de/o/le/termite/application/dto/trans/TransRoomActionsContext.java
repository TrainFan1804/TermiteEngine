package de.o.le.termite.application.dto.trans;

import de.o.le.termite.application.dto.types.RoomActionsDTO;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public record TransRoomActionsContext(
        List<RoomActionsDTO> actions
) implements TransContext {

    @Override
    public void accept(TransContextVisitor visitor) {
        visitor.visit(this);
    }
}
