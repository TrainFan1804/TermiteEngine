package de.o.le.termite.dto.trans;

import de.o.le.termite.dto.types.ItemDTO;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public record TransInventoryContext(
        List<ItemDTO> inv
) implements TransContext {

    @Override
    public void accept(TransContextVisitor visitor) {
        visitor.visit(this);
    }
}
