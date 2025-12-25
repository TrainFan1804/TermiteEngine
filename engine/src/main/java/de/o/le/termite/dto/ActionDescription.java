package de.o.le.termite.dto;

import de.o.le.termite.backend.data.room.RoomActionType;

/**
 * Simple DTO to wrap room action names and types.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.25
 */
public record ActionDescription(
        RoomActionType type,
        String actionName
) { }
