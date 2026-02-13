package de.o.le.termite.core.model.room;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is a wrapper for the room model's info data.
 *
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.20
 */
public class RoomInfo {

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String description;

    private String image;

    public RoomInfo() { }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public String getImage() { return image; }
}
