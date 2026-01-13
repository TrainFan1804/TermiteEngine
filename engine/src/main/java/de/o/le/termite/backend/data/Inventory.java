package de.o.le.termite.backend.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.o.le.termite.backend.data.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.26
 */
public class Inventory {

    private List<Item> inventory;

    public Inventory() { }

    public List<Item> getInventory() { return this.inventory; }

    public void addItem(Item item) { this.inventory.add(item); }

    public List<String> asStringList() {

        List<String> list = new ArrayList<>();
        for (Item item : inventory) {
            list.add(item.getName());
        }
        return list;
    }
}
