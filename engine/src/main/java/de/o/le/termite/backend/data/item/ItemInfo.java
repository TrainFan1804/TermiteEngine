package de.o.le.termite.backend.data.item;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.26
 */
public class ItemInfo {

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String description;

    public String getName() { return this.name; }

    public String getDescription() { return this.description; }
}
