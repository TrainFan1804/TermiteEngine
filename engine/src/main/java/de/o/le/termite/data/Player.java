package de.o.le.termite.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.3
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {
    public String name;
    public String room;
}
