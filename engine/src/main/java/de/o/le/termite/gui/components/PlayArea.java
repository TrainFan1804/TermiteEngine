package de.o.le.termite.gui.components;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.13
 */
public class PlayArea extends VBox {

    private TextField input;
    private GameArea game;

    public PlayArea() {

        this.input = new TextField();
        this.game = new GameArea();

        getChildren().addAll(this.game, this.input);
    }

    public String getInput() { return this.input.getText(); }

    public void updateAreaText(String text) {
        this.updateAreaText(text, Color.BLACK);
    }

    public void updateAreaText(String text, Color textColor) {
        this.game.addText(text, textColor);
    }

    public void clearInput() { this.input.clear(); }
}
