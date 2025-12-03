package de.o.le.termite;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Termite extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game");
        TextArea area = new TextArea();
        area.setEditable(false);
        TextField input = new TextField();
        Button btn = new Button();
        btn.setText("Close");
        btn.setOnAction(event -> primaryStage.close());

        Pane root = new VBox();
        root.getChildren().add(area);
        root.getChildren().add(input);
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
