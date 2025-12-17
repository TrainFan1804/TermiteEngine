package de.o.le.termite.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.3
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

    public static class RoomInfo {
        String name;
        String description;
        String image;

        public String getName() { return name; }

        public String getDescription() { return description; }

        public String getImage() { return image; }
    }

    private RoomInfo info;

    public RoomInfo getInfo() { return this.info; }

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
