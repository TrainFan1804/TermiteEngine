package de.o.le.termite.application.dto.types;

import de.o.le.termite.infrastructure.entity.room.RoomExitActionEntity;
import de.o.le.termite.infrastructure.entity.room.RoomLookActionEntity;

/**
 * This DTO represent both the class
 * {@link RoomLookActionEntity} and
 * {@link RoomExitActionEntity} in term of type of
 * action and name of the object.   <br>
 * <b>Example:</b>     <br>
 * EXIT : north
 *
 * TODO: Right now the type is a string but in the future I might want a enum type for that.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public record RoomActionsDTO (
        String type,
        String name
) {
    @Override
    public String toString() {
        return type + ": " + name;
    }
}
