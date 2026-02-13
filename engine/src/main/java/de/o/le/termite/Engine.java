package de.o.le.termite;

import de.o.le.termite.application.port.GameObjectRepository;
import de.o.le.termite.application.EngineContext;

import de.o.le.termite.core.commands.*;
import de.o.le.termite.core.model.GameObject;
import de.o.le.termite.core.model.Inventory;
import de.o.le.termite.core.model.Player;
import de.o.le.termite.core.model.room.Room;
import de.o.le.termite.core.state.GameState;
import de.o.le.termite.core.commands.CommandResult;

import de.o.le.termite.infrastructure.persistance.GameObjectManager;

import de.o.le.termite.application.commands.CommandParser;
import de.o.le.termite.application.dto.trans.TransContext;
import de.o.le.termite.application.dto.trans.TransRoomContext;
import de.o.le.termite.application.dto.types.mapper.RoomMapper;

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

        GameObjectRepository gom = this.context.gameObjectManager();
        Player player = gom.getData(GameObject.PLAYER, "player");
        Inventory inventory = gom.getData(GameObject.INVENTORY, "inventory");
        Room startRoom = gom.getData(GameObject.ROOM, player.getStartRoom());

        GameState gs = this.context.gameState();
        gs.setCurrentRoom(startRoom);
        gs.setPlayer(player);
        gs.setInventory(inventory);

        TransContext ctx = new TransRoomContext(RoomMapper.from(startRoom));
        return CommandResult.success(startRoom.getDescription(), ctx);
    }

    public CommandResult processCommand(String command) {

        CommandParser parser = new CommandParser();
        ICommandHandler ch = parser.parse(command);
        return ch.execute(this.context);
    }
}
