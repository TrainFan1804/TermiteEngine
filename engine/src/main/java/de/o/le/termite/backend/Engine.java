package de.o.le.termite.backend;

import de.o.le.termite.backend.commands.*;
import de.o.le.termite.backend.data.GameObject;
import de.o.le.termite.backend.data.Inventory;
import de.o.le.termite.backend.data.Player;
import de.o.le.termite.backend.data.room.Room;
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

        CommandRegistry cr = new CommandRegistry();
        cr.register(CommandType.SHOW, new ShowCommand());
        cr.register(CommandType.WALK, new WalkCommand());
        cr.register(CommandType.LOOK, new LookCommand());
        cr.register(CommandType.INV, new InvCommand());

        this.context = new EngineContext(gom, cr);
    }

    public CommandResult loadGame() {
        LOG.info("Start game...");

        GameObjectManager manager = this.context.gameObjectManager();
        Player player = manager.getData(GameObject.PLAYER, "player");
        Inventory inventory = manager.getData(GameObject.Inventory, "inventory");
        Room startRoom = manager.getData(GameObject.ROOM, player.getRoom());

        GameState.getInstance().setCurrentRoom(startRoom);
        GameState.getInstance().setPlayer(player);
        GameState.getInstance().setInventory(inventory);

        return CommandResult.success(startRoom.getInfo().getDescription(), new CommandContext().addRoom(startRoom));
    }

    public CommandResult processCommand(String command) {

        CommandParser parser = new CommandParser();
        ParsedCommand parsedCommand = parser.parse(command);

        if (parsedCommand == null) { return CommandResult.failure("Unknown command"); }

        CommandRegistry cr = this.context.commandRegistry();

        CommandHandler ch = cr.get(parsedCommand.type());
        return ch.execute(parsedCommand.args(), this.context, GameState.getInstance());
    }
}
