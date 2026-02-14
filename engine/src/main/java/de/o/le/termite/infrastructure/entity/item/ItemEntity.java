package de.o.le.termite.infrastructure.entity.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.o.le.termite.infrastructure.persistance.utils.annotations.InjectId;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.02.14
 */
public class ItemEntity {

    @InjectId
    @JsonIgnore
    private String itemId;

    @JsonProperty
    private ItemInfoEntity info;

    public ItemEntity() { }

    public String getItemId() { return itemId; }

    public String getName() { return this.info.getName(); }

    public String getDescription() { return this.info.getDescription(); }
}
