package de.o.le.termite.dto;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.26
 * @deprecated Was replaced with {@link RoomActionsDTO} and {@link ItemDTO}
 */
@Deprecated(since = "26.01.14", forRemoval = true)
public record StringStringDescription(
        String name,
        String description
) {
    @Override
    public String toString() {
        return name + ": " + description;
    }
}
