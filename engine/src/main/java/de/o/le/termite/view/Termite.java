package de.o.le.termite.view;

import de.o.le.termite.backend.Engine;
import de.o.le.termite.util.LogService;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.3
 */
public class Termite extends Application {

    private static final LogService LOG = new LogService(Termite.class.getName());

    private TermiteController controller;

    private TextArea playArea;

    @Override
    public void init() throws Exception {
        List<String> args = getParameters().getRaw();
        Engine engine = new Engine();
        if (!args.isEmpty()) {
            engine = new Engine(args.getFirst());
        }
        this.controller = new TermiteController(engine, this);
    }

    @Override
    public void start(Stage primaryStage) {
        LOG.info("Start GUI");

        primaryStage.setTitle("Game");

        playArea = new TextArea();
        playArea.setEditable(false);
        TextField commandInput = new TextField();

        Button closeBtn = new Button();
        closeBtn.setText("Close");
        closeBtn.setOnAction(event -> {
            primaryStage.close();
            LOG.info("Close GUI");
        });

        Button sendCommand = new Button("Turn");
        sendCommand.setOnAction(e -> this.controller.handleCommand(commandInput.getText()));

        Pane root = new VBox();
        root.getChildren().add(playArea);
        root.getChildren().add(commandInput);
        root.getChildren().add(sendCommand);
        root.getChildren().add(closeBtn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }

    public void updatePlayArea(String content) {
        this.playArea.setText(content);
    }
}
