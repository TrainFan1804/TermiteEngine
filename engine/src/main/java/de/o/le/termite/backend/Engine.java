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

    private GameObjectManager manager;

    public Engine() throws IOException {
        this("game/default");
        LOG.warning("You are using the default game path. This might not be your intention. Check your arguments!");
    }

    public Engine(String startPath) throws IOException {
        LOG.info("Start engine");

//        GameObjectManager gom = new GameObjectManager(startPath);


        EngineContext context = EngineContext.getInstance();
        context.init(startPath);
        this.manager = context.gameObjectManager();
    }

    public CommandResult loadGame() {
        LOG.info("Start game...");

        Player player = this.manager.getData(GameObject.PLAYER, "player");
        Inventory inventory = this.manager.getData(GameObject.Inventory, "inventory");
        Room startRoom = this.manager.getData(GameObject.ROOM, player.getRoom());

        GameState.getInstance().setCurrentRoom(startRoom);
        GameState.getInstance().setPlayer(player);
        GameState.getInstance().setInventory(inventory);

        return CommandResult.success(startRoom.getInfo().getDescription(), new CommandContext().addRoom(startRoom));
    }

    public CommandResult processCommand(String command) {

        CommandParser parser = new CommandParser();
        ParsedCommand parsedCommand = parser.parse(command);

        if (parsedCommand == null) { return CommandResult.failure("Unknown command"); }

        switch (parsedCommand.type()) {
            case WALK: return new WalkCommand().walk(parsedCommand.args());
            case LOOK: return new LookCommand().look(parsedCommand.args());
            case SHOW: return new ShowCommand().show();
            case INV: return new InvCommand().inv();
        }
        return CommandResult.failure("If this message show up, the dev f*cked up"); // At least I guess it should...
    }
}
