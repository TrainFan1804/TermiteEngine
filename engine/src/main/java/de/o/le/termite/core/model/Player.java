package de.o.le.termite.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.3
 */
public class Player {

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String startRoom;

    public Player() { }

    public String getName() { return this.name; }

    public String getStartRoom() { return this.startRoom; }
}
