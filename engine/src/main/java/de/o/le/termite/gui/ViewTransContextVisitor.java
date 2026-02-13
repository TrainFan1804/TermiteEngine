package de.o.le.termite.gui;

import de.o.le.termite.application.dto.trans.TransContextVisitor;
import de.o.le.termite.application.dto.trans.TransInventoryContext;
import de.o.le.termite.application.dto.trans.TransRoomActionsContext;
import de.o.le.termite.application.dto.trans.TransRoomContext;
import de.o.le.termite.application.dto.types.ItemDTO;
import de.o.le.termite.application.dto.types.RoomActionsDTO;

/**
 * This class was implemented to ensure that the various DTOs are placed in
 * the correct position in the GUI.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public class ViewTransContextVisitor implements TransContextVisitor {

    private Termite view;

    public ViewTransContextVisitor(Termite view) {
        this.view = view;
    }

    @Override
    public void visit(TransRoomContext context) {
        view.showRoom(context.room().roomName());
    }

    @Override
    public void visit(TransInventoryContext context) {
        for (ItemDTO items : context.inv()) {
            view.showMessage(items.toString());
        }
    }

    @Override
    public void visit(TransRoomActionsContext context) {
        for (RoomActionsDTO actions : context.actions()) {
            view.showMessage(actions.toString());
        }
    }
}
