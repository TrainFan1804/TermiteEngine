package de.o.le.termite.view.components;

import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.13
 */
public class GameArea extends ScrollPane {

    private static final int MAX_LINES = 1000;

    private TextFlow textFlow;

    public GameArea() {

        setFitToWidth(true);
        setPrefSize(600, 300);
        setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        this.textFlow = new TextFlow();
        this.textFlow.setLineSpacing(2);
        this.textFlow.heightProperty().addListener((observable, oldVal, newVal) -> {
            setVvalue(1.0);
        });
        setContent(textFlow);
    }

    public void addText(String text, Color textColor) {

        Text t = new Text(text+ "\n");
        t.setFill(textColor);
        this.textFlow.getChildren().add(t);
        trimText();
    }

    private void trimText() {
        if (this.textFlow.getChildren().size() >= MAX_LINES + 1) {
            this.textFlow.getChildren().removeFirst();
        }
    }
}
