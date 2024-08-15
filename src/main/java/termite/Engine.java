package termite;

import termite.instance.event.InstanceEventType;
import termite.instance.event.InstanceEvent;

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

        Command command;
        String input;
        while (true) {

            // ask for input
            input = scanner.next().toUpperCase();
            try {

                // decode input to command
                command = Command.valueOf(input);

            } catch (IllegalArgumentException exception) {

                System.out.println("Invalid command");
                continue;
            }
            // determine if engine / game command
            switch (command) {
                case SAVE:
                case LOAD:
                case EXIT:
                case HELP:
                    System.exit(0);
                default:
                    this.sendToGame(command);
                    break;
            }
            // send engine command to engine or game command to game instance
        }
    }
    
    private void sendToGame(Command command) {
        
        InstanceEventType type = CommandInstanceEventMapper.mapCommandToInstanceEventType(command);

        InstanceEvent event = this.game.getInstanceManger().getInstanceById(0)
                                        .getEventHandler().getEventById(type.ID);

        event.startEvent();
    } 
}
