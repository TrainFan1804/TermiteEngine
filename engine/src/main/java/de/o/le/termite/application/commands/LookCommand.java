package de.o.le.termite.application.commands;

import de.o.le.termite.application.EngineContext;
import de.o.le.termite.application.state.GameState;
import de.o.le.termite.core.model.GameObject;
import de.o.le.termite.core.model.Item;
import de.o.le.termite.infrastructure.entity.room.RoomEntity;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.4
 * @since                               25.12.13
 */
public class LookCommand implements ICommandHandler {

    private List<String> args;

    public LookCommand(List<String> args) {
        this.args = args;
    }

    @Override
    public CommandResult execute(EngineContext context) {
        if (args.isEmpty()) {
            return CommandResult.failure("Nothing found.");
        }
        GameState gs = context.gameState();

        String a = args.getFirst();
        RoomEntity currentRoom = gs.getCurrentRoom();

        String itemId = currentRoom.getLookItemId(a);
        if (itemId == null) {
            return CommandResult.failure("You can't look there!");
        }

        if (/*player.hasItem or something like that*/false) {
            return CommandResult.success(currentRoom.getLookAltMessage(a));
        }

        Item roomItem = context.gameObjectManager().getData(GameObject.ITEM, itemId);
        gs.addItemToInventory(roomItem);
        // TODO persistent / cache save that item was pick up
        return CommandResult.success(currentRoom.getLookMessage(a));
    }
}
