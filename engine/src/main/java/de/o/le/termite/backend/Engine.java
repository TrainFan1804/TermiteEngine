package de.o.le.termite.backend;

import de.o.le.termite.backend.commands.*;
import de.o.le.termite.backend.data.GameObject;
import de.o.le.termite.backend.data.Inventory;
import de.o.le.termite.backend.data.Player;
import de.o.le.termite.backend.data.room.Room;
import de.o.le.termite.backend.manager.GameObjectManager;
import de.o.le.termite.backend.manager.state.GameState;
import de.o.le.termite.dto.CommandContext;
import de.o.le.termite.dto.CommandResult;
import de.o.le.termite.util.LogService;

import java.io.IOException;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.6
 */
public class Engine {

    private static final LogService LOG = new LogService(Engine.class.getName());

    private EngineContext context;

    public Engine() throws IOException {
        this("game/default");
        LOG.warning("You are using the default game path. This might not be your intention. Check your arguments!");
    }

    public Engine(String startPath) throws IOException {
        LOG.info("Start engine");

        GameObjectManager gom = new GameObjectManager(startPath);
        GameState gs = new GameState();

        this.context = new EngineContext(gom, gs);
    }

    public CommandResult loadGame() {
        LOG.info("Start game...");

        GameObjectManager gom = this.context.gameObjectManager();
        Player player = gom.getData(GameObject.PLAYER, "player");
        Inventory inventory = gom.getData(GameObject.INVENTORY, "inventory");
        Room startRoom = gom.getData(GameObject.ROOM, player.getStartRoom());

        GameState gs = this.context.gameState();
        gs.setCurrentRoom(startRoom);
        gs.setPlayer(player);
        gs.setInventory(inventory);

        return CommandResult.success(startRoom.getInfo().getDescription(), new CommandContext().addRoom(startRoom));
    }

    public CommandResult processCommand(String command) {

        CommandParser parser = new CommandParser();
        CommandHandler ch = parser.parse(command);
        return ch.execute(this.context);
    }
}
