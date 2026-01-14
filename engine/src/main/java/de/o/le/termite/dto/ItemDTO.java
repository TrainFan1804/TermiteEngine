package de.o.le.termite.dto;

/**
 * This DTO represent the {@link de.o.le.termite.backend.data.item.Item} data object.
 * Use {@link de.o.le.termite.dto.mapper.ItemMapper} for object creation.
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
