package de.o.le.termite.core.model.room;

import de.o.le.termite.core.model.Item;
import de.o.le.termite.core.model.ModelIdGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.02.14
 */
public class Secret {

    private String secretId;

    private String description;

    private List<Item> items;

    private boolean discovered;

    public Secret(String description, List<Item> items, boolean discovered) {
        this.description = description;
        this.items = items;
        this.discovered = discovered;
        this.secretId = ModelIdGenerator.generateId(this);
    }

    public String getSecretId() {
        return secretId;
    }

    public String getDescription() {
        return description;
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public String discover() {
        if (discovered) {
            return null;
        }
        discovered = true;
        return description;
    }

    public List<Item> loot() {
        if (!discovered) {
            throw new IllegalStateException("Secret not discovered yet");
        }
        List<Item> loot = new ArrayList<>(items);
        items.clear();
        return loot;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
