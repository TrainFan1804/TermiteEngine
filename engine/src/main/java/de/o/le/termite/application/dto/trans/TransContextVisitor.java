package de.o.le.termite.application.dto.trans;

/**
 * This pattern is designed according to the GoF visitor pattern.
 * <p>
 *     See {@link de.o.le.termite.gui.ViewTransContextVisitor} for a specific
 *     implementation of this interface.
 * </p>
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public interface TransContextVisitor {

    void visit(TransRoomContext context);

    void visit(TransInventoryContext context);

    void visit(TransRoomActionsContext context);
}
