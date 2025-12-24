package de.o.le.termite.dto;

import de.o.le.termite.backend.data.room.Room;

import java.util.Optional;

/**
 * This builder class provide additional context for {@link CommandResult}.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.24
 */
public class CommandContext {

    private Room room;

    public Optional<Room> getRoom() {
        return Optional.ofNullable(room);
    }

    public CommandContext addRoom(Room room){
        this.room = room;
        return this;
    }
}
