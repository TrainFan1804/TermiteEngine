package de.o.le.termite.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {
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
