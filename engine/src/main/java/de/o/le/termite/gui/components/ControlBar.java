package de.o.le.termite.gui.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.13
 */
public class ControlBar extends HBox {

    public ControlBar(EventHandler<ActionEvent> closeAction) {

        Button closeButton = new Button("Quit");
        closeButton.setOnAction(closeAction);
        getChildren().add(closeButton);
    }
}
