package de.o.le.termite.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class RoomInfo {
    String name;
    String description;
    String image;
}
