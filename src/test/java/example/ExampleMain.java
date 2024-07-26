package example;

// custom import
import backend.terminal.TerminalApplication;
import engine.Game;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.1
 */
public class ExampleMain {
    
    public static void main(String[] args) {
        
        Game exampleGame = new ExampleGame();
        TerminalApplication application = new TerminalApplication(exampleGame);
        application.start();
    }
}
