package de.o.le.termite.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.02.14
 */
public class PlayerEntity {

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String startRoom;

    public PlayerEntity() { }

    public String getName() { return this.name; }

    public String getStartRoom() { return this.startRoom; }
}
