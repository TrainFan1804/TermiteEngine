package de.o.le.termite.core.model;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.26
 */
public class Inventory {

    private List<Item> items;

    public Inventory(List<Item> items) {
        this.items = items;
    }

    public List<Item> get() { return this.items; }

    public List<Item> getItems() { return this.items; }

    public void add(Item item) {
        if (item == null) {
            throw new IllegalStateException("Item can't be null!");
        }
        this.items.add(item);
    }

    public boolean remove(Item item) {
        return this.items.remove(item);
    }

    public boolean contains(Item item) {
        return this.items.contains(item);
    }
}
