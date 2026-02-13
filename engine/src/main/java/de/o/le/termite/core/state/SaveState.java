package de.o.le.termite.core.state;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.13
 */
public class SaveState {

    @JsonProperty
    private String currentRoomId;

    @JsonProperty
    private List<String> inventory;

    public SaveState() { }

    public SaveState(String currentRoomId, List<String> inventory) {

        this.currentRoomId = currentRoomId;
        this.inventory = inventory;
    }
}
