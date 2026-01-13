package de.o.le.termite.backend.data.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.26
 */
public class Item {

    private ItemInfo info;

    public Item() { }

    public ItemInfo getInfo() { return this.info; }
}
