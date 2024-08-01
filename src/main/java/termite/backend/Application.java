package termite.backend;

import termite.backend.commands.CommandAction;
import termite.backend.commands.CommandDecoder;

/**
 * @author                              o.le
 * @version                             0.4
 * @since                               0.12
 */
public abstract class Application {

    protected Game game;
    protected CommandDecoder decoder;

    protected Application(Game game) {

        this.game = game;
        this.decoder = CommandDecoder.getDecoder();
        
        this.game.init();
    }

    public abstract void start();

    protected CommandAction decode(String input) {

        return this.decoder.decode(input);
    }
}
