package de.o.le.termite.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.3
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

    static class RoomInfo {
        String name;
        String description;
        String image;
    }

    private RoomInfo info;

    public String getName() {
        return info.name;
    }

    public String getDescription() {
        return info.description;
    }

    public String getImage() {
        return info.image;
    }
}
