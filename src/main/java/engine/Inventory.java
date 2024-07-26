package engine;

// java import
import java.util.List;
import java.util.LinkedList;

/**
 * The inventory represent the {@link Item} the player owns.
 * 
 * @author                              o.le
 * @version                             1.1
 * @since                               0.2
 */
public class Inventory {

    private List<Item> inventoryList;

    public Inventory() {

        this.inventoryList = new LinkedList<>();
    }

    /**
     * Add an item to the inventory.
     * 
     * @param item                      The new item.
     */
    public void addItemToInventory(Item item) {

        this.inventoryList.add(item);
    }

    /**
     * Get an item at a given index.
     * 
     * @param index                     The index of the wanted item.
     * @return                          The item at the given index.
     */
    public Item getItemAtIndex(int index) {

        if (index < 0 || index >= this.inventoryList.size()) {

            throw new IllegalArgumentException("Index is invalid");
        }

        return this.inventoryList.get(index);
    }

    @Override
    public String toString() {
        
        return inventoryList.toString();
    }
}
