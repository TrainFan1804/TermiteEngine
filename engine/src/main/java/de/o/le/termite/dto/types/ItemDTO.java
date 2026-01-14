package de.o.le.termite.dto.types;

import de.o.le.termite.dto.types.mapper.ItemMapper;

/**
 * This DTO represent the {@link de.o.le.termite.backend.data.item.Item} data object.
 * Use {@link ItemMapper} for object creation.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public record ItemDTO(
        String itemName,
        String itemDescription
) {
    @Override
    public String toString() {
        return itemName + " : " + itemDescription;
    }
}
