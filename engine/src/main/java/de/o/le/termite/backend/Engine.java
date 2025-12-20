package de.o.le.termite.backend;

import de.o.le.termite.backend.commands.CommandParser;
import de.o.le.termite.backend.commands.LookCommand;
import de.o.le.termite.backend.commands.ParsedCommand;
import de.o.le.termite.backend.commands.WalkCommand;
import de.o.le.termite.data.GameObject;
import de.o.le.termite.data.room.Room;
import de.o.le.termite.util.LogService;

import java.io.IOException;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.6
 *
 * @apiNote {@link GameState} might be a global singleton instance but right now it should only be accessed via
 * this class
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

        EngineContext context = EngineContext.getInstance();
        context.init(startPath);
        this.manager = context.gameObjectManager();
        loadGame();
    }

    private void loadGame() {
        Room startRoom = this.manager.getData(GameObject.ROOM, "default");
        GameState.getInstance().setCurrentRoom(startRoom);
    }

    public String processCommand(String command) {

        CommandParser parser = new CommandParser();
        ParsedCommand parsedCommand = parser.parse(command);

        if (parsedCommand == null) { return "Unknown command"; }

        switch (parsedCommand.type()) {
            case WALK: return new WalkCommand().walk(parsedCommand.args());
            case LOOK: return new LookCommand().look(parsedCommand.args());
        }
        return "If this message show up, the dev f*cked up"; // At least I guess it should...
    }

    public GameState getGameState() { return GameState.getInstance(); }
}
