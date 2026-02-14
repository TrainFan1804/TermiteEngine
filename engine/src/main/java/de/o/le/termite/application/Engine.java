package de.o.le.termite.application;

import de.o.le.termite.application.commands.ICommandHandler;

import de.o.le.termite.core.model.Inventory;
import de.o.le.termite.core.model.Player;
import de.o.le.termite.infrastructure.entity.room.RoomEntity;
import de.o.le.termite.application.state.GameState;
import de.o.le.termite.application.commands.CommandResult;

import de.o.le.termite.application.commands.CommandParser;
import de.o.le.termite.application.dto.trans.TransContext;
import de.o.le.termite.application.dto.trans.TransRoomContext;
import de.o.le.termite.application.dto.types.mapper.RoomMapper;

import de.o.le.termite.util.LogService;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.6
 */
public class Engine {

    private static final LogService LOG = new LogService(Engine.class.getName());

    private EngineContext context;

    public Engine(GameObjectRepository gor) {
        LOG.info("Create engine");

        GameState gs = new GameState();
        this.context = new EngineContext(gor, gs);
    }

    public CommandResult loadGame() {
        LOG.info("Start game...");

        GameObjectRepository gom = this.context.gameObjectRepository();

        Player player = gom.getData(GameObject.PLAYER, "player");
        Inventory inventory = gom.getData(GameObject.INVENTORY, "inventory");
        RoomEntity startRoom = gom.getData(GameObject.ROOM, player.getStartRoom());

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
