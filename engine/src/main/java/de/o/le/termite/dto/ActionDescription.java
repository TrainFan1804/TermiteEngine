package de.o.le.termite.dto;

import de.o.le.termite.backend.data.room.RoomActionType;

/**
 * Simple DTO to wrap room action names and types.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.25
 * @deprecated                          Deprecated after {@link de.o.le.termite.dto.StringStringDescription} was
 *      introduced.
 */
@Deprecated(since = "25.12.26")
public record ActionDescription(
        RoomActionType type,
        String actionName
) { }
