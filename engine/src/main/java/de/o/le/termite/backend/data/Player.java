package de.o.le.termite.backend.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.3
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {
    private String name;
    private String room;

    public Player() { }

    public String getName() { return this.name; }

    public String getRoom() { return this.room; }
}
