package termite.engine.delegationsystem;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
public class ExitSystem implements EngineSystem {

    @Override
    public void handle() {

        System.out.println("Leave game");
        System.exit(0);
    }
}
