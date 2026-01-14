package de.o.le.termite.dto.types.mapper;

import de.o.le.termite.backend.data.Inventory;
import de.o.le.termite.backend.data.item.Item;
import de.o.le.termite.dto.types.ItemDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               26.01.14
 */
public class InventoryMapper {

    // TODO replace List<ItemDTO> with InventoryDTO (not implemented yet)
    public static List<ItemDTO> asDisplayList(Inventory inv) {

        List<ItemDTO> itemsAsDTO = new ArrayList<>();
        for (Item item : inv.get()) {
            itemsAsDTO.add(ItemMapper.from(item));
        }
        return itemsAsDTO;
    }
}
