package engine.core.subsystems;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class ExitSystem implements EngineCommandSystem {

    @Override
    public void execute() {

        System.out.println("Leave game");
        System.exit(0);
    }
}
