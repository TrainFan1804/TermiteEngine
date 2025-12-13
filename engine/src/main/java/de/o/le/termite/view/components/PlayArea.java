package de.o.le.termite.view.components;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.13
 */
public class PlayArea extends VBox {

    private TextArea area;
    private TextField input;

    public PlayArea() {

        this.area = new TextArea();
        this.area.setEditable(false);

        this.input = new TextField();

        getChildren().addAll(this.area, this.input);
    }

    public String getInput() { return this.input.getText(); }

    public void updateAreaText(String text) { this.area.setText(text); }
}
