package example;

// custom import
import engine.NonPlayerCharacter;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.10
 */
class ExampleNPC extends NonPlayerCharacter {

    public ExampleNPC(String name) {
        
        super(name);
    }

    @Override
    public String getDialog() {
        
        return null;
    }
}
