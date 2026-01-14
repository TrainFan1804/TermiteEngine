package de.o.le.termite.dto;

import de.o.le.termite.backend.data.room.Room;

import java.util.List;
import java.util.Optional;

/**
 * This builder class provide additional context for {@link CommandResult}.
 *
 * @author                              o.le
 * @version                             2.0
 * @since                               25.12.24
 */
public class CommandContext {

    private Room room;
    private List<RoomActionsDTO> actionDescription;
    private List<ItemDTO> inventoryDTO;

    public Optional<Room> getRoom() {
        return Optional.ofNullable(room);
    }

    public Optional<List<RoomActionsDTO>> getActionDescription() {
        return Optional.ofNullable(actionDescription);
    }

    public Optional<List<ItemDTO>> getInventoryDesc() {
        return Optional.ofNullable(inventoryDTO);
    }

    public CommandContext addRoom(Room room){
        this.room = room;
        return this;
    }

    public CommandContext addActionDescription(List<RoomActionsDTO> desc) {
        this.actionDescription = desc;
        return this;
    }

    public CommandContext addInventoryDTO(List<ItemDTO> dto) {
        this.inventoryDTO = dto;
        return this;
    }
}
