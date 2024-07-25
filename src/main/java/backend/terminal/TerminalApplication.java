package backend.terminal;

// custom import
import de.o.le.Game;

/**
 * @author                              o.le
 * @version                             0.5
 * @since                               0.1
 */
public class TerminalApplication {

    private Game game;
    private KeyWordInputEngine inputEngine;

    public TerminalApplication(Game game) {

        this.game = game;
        this.inputEngine = new KeyWordInputEngine();
        this.game.create();
        this.run();
    }
    
    private void run() {

        while(this.game.getInstance() != null) {

            System.out.println(this.game.getInstance().display());
            
            this.game.setCommand(this.inputEngine.waitForInput());
            this.game.execute();
        }
    }
}
