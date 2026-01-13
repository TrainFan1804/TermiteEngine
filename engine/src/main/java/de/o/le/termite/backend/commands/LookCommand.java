package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.manager.GameState;
import de.o.le.termite.backend.data.GameObject;
import de.o.le.termite.backend.data.item.Item;
import de.o.le.termite.backend.data.room.Room;
import de.o.le.termite.backend.data.room.RoomLookAction;
import de.o.le.termite.dto.CommandResult;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.4
 * @since                               25.12.13
 */
public class LookCommand implements CommandHandler {

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
        Room currentRoom = gs.getCurrentRoom();

        RoomLookAction action = currentRoom.getLook(a);
        if (action == null) {
            return CommandResult.failure("You can't look there!");
        }
        if (/*action.isSearched()*/false) {
            return CommandResult.success(action.getAltMessage());
        }

        Item roomItem = context.gameObjectManager().getData(GameObject.ITEM, action.getItem());
        gs.addItemToInventory(roomItem);
//        action.setSearched(true); // TODO persistent save in [item_name].json
        return CommandResult.success(currentRoom.getLook(a).getMessage());
    }
}
