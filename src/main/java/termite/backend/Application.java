package termite.backend;

/**
 * @author                              o.le
 * @version                             0.3
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

    protected CommandType decode(String input) {

        return this.decoder.decode(input);
    }
}
