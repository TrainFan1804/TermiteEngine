package de.o.le.termite.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.13
 */
public class SaveState {

    @JsonProperty
    private String currentRoom;

    @JsonProperty
    private List<String> inventory;

    public SaveState() { }

    public SaveState(String currentRoomName, List<String> inventory) {

        this.currentRoom = currentRoomName;
        this.inventory = inventory;
    }
}
