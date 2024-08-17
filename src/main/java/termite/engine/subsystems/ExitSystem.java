package termite.engine.subsystems;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
public class ExitSystem implements EngineSystem {

    @Override
    public void execute() {

        System.out.println("Leave game");
        System.exit(0);
    }
}
