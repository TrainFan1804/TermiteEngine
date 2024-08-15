package termite.engine.delegationsystem;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
public class DelegationHandler {

    private EngineSystem engineSystem;

    public DelegationHandler(EngineSystem engineSystem) {

        this.engineSystem = engineSystem;
    }

    public void send() { this.engineSystem.handle(); }
}
