package engine;

/**
 * An item is something that can be used. An item isn't limited to the 
 * {@link Inventory} itself but can also be in an {@link Instance}. When the
 * item is in the inventory the user can use it with with {@code INV} command
 * and when the item belong to the instance itself he can use it with the
 * {@code USE} command.
 *  
 * @author                              o.le
 * @version                             1.0
 * @since                               0.1
 */
public abstract class Item {

    private String name;

    protected Item(String name) {

        this.name = name;
    }
    
    /**
     * Execute the saved behaivior of the item.
     */
    public abstract void useItem();

    @Override
    public String toString() {
     
        return this.name;
    }
}
