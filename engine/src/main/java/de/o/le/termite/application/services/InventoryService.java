package de.o.le.termite.application.services;

import de.o.le.termite.core.model.Inventory;
import de.o.le.termite.core.model.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public class InventoryService {

    public static List<String> asStringList(Inventory inv) {

        List<String> list = new ArrayList<>();
        for (Item item : inv.get()) {
            list.add(item.getItemId());
        }
        return list;
    }
}
