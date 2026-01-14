package de.o.le.termite.dto.datamapper;

import de.o.le.termite.backend.data.Inventory;
import de.o.le.termite.backend.data.item.Item;
import de.o.le.termite.dto.StringStringDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public class InventoryMapper {

    public static List<StringStringDescription> asDisplayList(Inventory inv) {

        List<StringStringDescription> itemsAsDTO = new ArrayList<>();
        for (Item item : inv.getInventory()) {
            itemsAsDTO.add(new StringStringDescription(item.getName(), item.getDescription()));
        }
        return itemsAsDTO;
    }
}
