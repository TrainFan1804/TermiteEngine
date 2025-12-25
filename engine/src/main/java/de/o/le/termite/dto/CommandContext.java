package de.o.le.termite.dto;

import de.o.le.termite.backend.data.room.Room;

import java.util.List;
import java.util.Optional;

/**
 * This builder class provide additional context for {@link CommandResult}.
 *
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.24
 */
public class CommandContext {

    private Room room;
    private List<ActionDescription> description;

    public Optional<Room> getRoom() {
        return Optional.ofNullable(room);
    }

    public Optional<List<ActionDescription>> getDescription() {
        return Optional.ofNullable(description);
    }

    public CommandContext addRoom(Room room){
        this.room = room;
        return this;
    }

    public CommandContext addDescription(List<ActionDescription> description) {
        this.description = description;
        return this;
    }
}
