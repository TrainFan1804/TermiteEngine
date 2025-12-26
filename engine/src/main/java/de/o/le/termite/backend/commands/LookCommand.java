package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.GameState;
import de.o.le.termite.backend.data.GameObject;
import de.o.le.termite.backend.data.item.Item;
import de.o.le.termite.backend.data.room.Room;
import de.o.le.termite.backend.data.room.RoomLookAction;
import de.o.le.termite.dto.CommandResult;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.13
 */
public class LookCommand implements CommandHandler {

    @Override
    public CommandResult execute(List<String> args, EngineContext context, GameState state) {
        if (args.isEmpty()) {
            return CommandResult.failure("Nothing found.");
        }

        String a = args.getFirst();
        Room currentRoom = GameState.getInstance().getCurrentRoom();

        RoomLookAction action = currentRoom.getLook(a);
        if (action == null) {
            return CommandResult.failure("You can't look there!");
        }
        Item roomItem = context.gameObjectManager().getData(GameObject.ITEM, action.getItem());
        GameState.getInstance().addItemToInventory(roomItem);

        return CommandResult.success(currentRoom.getLook(a).getMessage());
    }
}
