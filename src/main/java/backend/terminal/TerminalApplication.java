package backend.terminal;

// custom import
import de.o.le.Game;

/**
 * @author                              o.le
 * @version                             0.3
 * @since                               0.1
 */
public class TerminalApplication {

    private Game game;

    public TerminalApplication(Game game) {

        this.game = game;
        this.game.create();
        this.run();
    }
    
    private void run() {

        while(this.game.getInstance() != null) {

            System.out.println(this.game.getInstance().display());
            // ask for input
    
            this.game.getInstance().talk();
            this.game.getInstance().use();
            this.game.getInstance().search();
        }
    }
}
