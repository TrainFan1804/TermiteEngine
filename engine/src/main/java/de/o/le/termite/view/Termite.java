package de.o.le.termite.view;

import de.o.le.termite.backend.Engine;
import de.o.le.termite.util.LogService;
import de.o.le.termite.view.components.ControlBar;
import de.o.le.termite.view.components.PlayArea;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.3
 * @since                               25.12.3
 */
public class Termite extends Application {

    private static final LogService LOG = new LogService(Termite.class.getName());

    private TermiteController controller;

    private PlayArea playArea;
    private Label roomNameLabel;

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

        this.roomNameLabel = new Label(this.controller.getCurrentRoomName());
        this.playArea = new PlayArea();

        Button sendCommand = new Button("Turn");
        sendCommand.setOnAction(
                e -> this.controller.handleCommand(this.playArea.getInput())
        );

        Pane root = new VBox();
        root.getChildren().add(this.roomNameLabel);
        root.getChildren().add(this.playArea);
        root.getChildren().add(sendCommand);
        root.getChildren().add(new ControlBar(e -> {
            primaryStage.close();
            LOG.info("Close GUI");
        }));

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }

    public void updatePlayArea(String content) { this.playArea.updateAreaText(content); }
}
