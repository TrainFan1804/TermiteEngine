package termite;

import java.util.Scanner;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Engine {

    private Game game;
    private Scanner scanner;

    public Engine(Game game) {

        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        // ask for input
        String input = scanner.next().toUpperCase();
        // decode input to command
        Command command = Command.valueOf(input);
        // determine if engine / game command
        switch (command) {
            case SAVE:
            case LOAD:
            case HELP:
                break; 
            default:
                this.sendToGame(command);
                break;
        }
        // send engine command to engine or game command to game instance
    }
    
    private void sendToGame(Command command) {
        
        EventType type = CommandEventMapper.mapCommandToEventType(command);

        this.game.getInstanceManger().getInstanceById(0)
                    .getEventHandler().getEventById(type.ID)
                    .startEvent();
    } 
}
