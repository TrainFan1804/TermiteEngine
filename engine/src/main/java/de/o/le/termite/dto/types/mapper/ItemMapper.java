package de.o.le.termite.dto.types.mapper;

import de.o.le.termite.backend.data.item.Item;
import de.o.le.termite.dto.types.ItemDTO;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public class ItemMapper {

    public static ItemDTO from(Item item) {
        return new ItemDTO(item.getName(), item.getDescription());
    }
}
