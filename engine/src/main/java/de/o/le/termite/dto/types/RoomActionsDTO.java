package de.o.le.termite.dto.types;

/**
 * This DTO represent both the class
 * {@link de.o.le.termite.backend.data.room.RoomLookAction} and
 * {@link de.o.le.termite.backend.data.room.RoomExitAction} in term of type of
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
