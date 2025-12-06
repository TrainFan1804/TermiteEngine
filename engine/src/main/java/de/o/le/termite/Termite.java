package de.o.le.termite;

import de.o.le.termite.engine.util.LogService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.3
 */
public class Termite extends Application {

    private static final LogService LOG = new LogService(Termite.class.getName());

    @Override
    public void start(Stage primaryStage) {
        LOG.info("Start GUI");
        primaryStage.setTitle("Game");
        TextArea area = new TextArea();
        area.setEditable(false);
        TextField input = new TextField();
        Button btn = new Button();
        btn.setText("Close");
        btn.setOnAction(event -> {
            primaryStage.close();
            LOG.info("Close GUI");
        });

        Pane root = new VBox();
        root.getChildren().add(area);
        root.getChildren().add(input);
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
