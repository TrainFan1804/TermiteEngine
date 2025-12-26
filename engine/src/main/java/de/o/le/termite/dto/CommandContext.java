package de.o.le.termite.dto;

import de.o.le.termite.backend.data.room.Room;

import java.util.List;
import java.util.Optional;

/**
 * This builder class provide additional context for {@link CommandResult}.
 *
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.24
 */
public class CommandContext {

    private Room room;
    private List<StringStringDescription> actionDescription;
    private List<StringStringDescription> inventoryDescription;

    public Optional<Room> getRoom() {
        return Optional.ofNullable(room);
    }

    public Optional<List<StringStringDescription>> getActionDescription() {
        return Optional.ofNullable(actionDescription);
    }

    public Optional<List<StringStringDescription>> getInventoryDesc() {
        return Optional.ofNullable(inventoryDescription);
    }

    public CommandContext addRoom(Room room){
        this.room = room;
        return this;
    }

    public CommandContext addActionDescription(List<StringStringDescription> desc) {
        this.actionDescription = desc;
        return this;
    }

    public CommandContext addInventoryDesc(List<StringStringDescription> desc) {
        this.inventoryDescription = desc;
        return this;
    }
}
