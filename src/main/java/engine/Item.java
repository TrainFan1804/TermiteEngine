package engine;

/**
 * @author                              o.le
 * @version                             0.3
 * @since                               0.1
 */
public abstract class Item {

    private String name;

    protected Item(String name) {

        this.name = name;
    }
    
    public abstract void useItem();
}
