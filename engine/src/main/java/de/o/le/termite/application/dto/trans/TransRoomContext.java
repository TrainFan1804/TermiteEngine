package de.o.le.termite.application.dto.trans;

import de.o.le.termite.application.dto.types.RoomDTO;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public record TransRoomContext(
        RoomDTO room
) implements TransContext {

    @Override
    public void accept(TransContextVisitor visitor) {
        visitor.visit(this);
    }
}
