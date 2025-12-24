package de.o.le.termite.backend.data.room;

/**
 * This is a wrapper for the room model's info data.
 *
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.20
 */
public class RoomInfo {

    private String name;
    private String description;
    private String image;

    public RoomInfo() { }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public String getImage() { return image; }
}
