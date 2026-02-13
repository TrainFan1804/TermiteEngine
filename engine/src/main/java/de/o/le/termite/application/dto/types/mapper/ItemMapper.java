package de.o.le.termite.application.dto.types.mapper;

import de.o.le.termite.core.model.item.Item;
import de.o.le.termite.application.dto.types.ItemDTO;

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
