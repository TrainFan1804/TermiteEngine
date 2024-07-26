package example;

// custom import
import engine.Game;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.7
 */
class ExampleGame extends Game  {

    String title;
    
    @Override
    public void create() {
    
        this.title = "Simple Example Game";

        super.setInstance(new StartInstance(this));
    }

    @Override
    public String toString() {

        return this.title;
    }
}
