package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.manager.state.GameState;
import de.o.le.termite.backend.data.GameObject;
import de.o.le.termite.backend.data.item.Item;
import de.o.le.termite.backend.data.room.Room;
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
