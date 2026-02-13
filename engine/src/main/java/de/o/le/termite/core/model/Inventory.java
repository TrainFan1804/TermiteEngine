package de.o.le.termite.core.model;

import de.o.le.termite.core.model.item.Item;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.26
 */
public class Inventory {

    private List<Item> inventory;

    public Inventory() { }

    public List<Item> get() { return this.inventory; }

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalStateException("Item can't be null!");
        }
        this.inventory.add(item);
    }
}
