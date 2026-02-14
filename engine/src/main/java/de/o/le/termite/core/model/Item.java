package de.o.le.termite.core.model;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.26
 */
public class Item {

    private String itemId;

    private String name;

    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.itemId = ModelIdGenerator.generateId(this);
    }

    public String getItemId() { return itemId; }

    public String getName() { return this.name; }

    public String getDescription() { return this.description; }
}
