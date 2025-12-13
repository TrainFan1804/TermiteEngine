package de.o.le.termite.backend;

import de.o.le.termite.Main;
import de.o.le.termite.backend.commands.CommandParser;
import de.o.le.termite.backend.commands.LookCommand;
import de.o.le.termite.backend.commands.ParsedCommand;
import de.o.le.termite.data.GameObject;
import de.o.le.termite.data.Room;
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

    private static final LogService LOG = new LogService(Main.class.getName());

    private GameObjectManager manager;

    public Engine() throws IOException {
        this("game/default");
    }

    public Engine(String startPath) throws IOException {
        LOG.info("Start engine");


        EngineContext context = EngineContext.getInstance();
        context.init(startPath);
        this.manager = context.gameObjectManager();
        loadGame();

        LOG.info("Stop engine");
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
            case WALK: return "";
            case LOOK: return new LookCommand().look(parsedCommand.args());
        }
        return "This should be displayed at any circumstances!"; // At least I guess it should...
    }

    public GameState getGameState() { return GameState.getInstance(); }
}
