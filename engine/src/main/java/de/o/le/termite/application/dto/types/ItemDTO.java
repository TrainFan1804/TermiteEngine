package de.o.le.termite.application.dto.types;

import de.o.le.termite.application.dto.types.mapper.ItemMapper;
import de.o.le.termite.core.model.Item;

/**
 * This DTO represent the {@link Item} data object.
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
