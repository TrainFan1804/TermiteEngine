package de.o.le.termite.backend.data.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.26
 */
public class Item {

    @JsonIgnore
    private String itemId;

    @JsonProperty
    private ItemInfo info;

    public Item() { }

    public String getItemId() { return itemId; }

    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getName() { return this.info.getName(); }

    public String getDescription() { return this.info.getDescription(); }
}
