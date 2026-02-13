package de.o.le.termite.gui;

import de.o.le.termite.Engine;
import de.o.le.termite.core.model.room.Room;
import de.o.le.termite.util.LogService;
import de.o.le.termite.gui.components.ControlBar;
import de.o.le.termite.gui.components.PlayArea;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.4
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

        this.roomNameLabel = new Label();
        this.playArea = new PlayArea();

        Button sendCommand = new Button("Turn");
        sendCommand.setOnAction(
                e -> {
                    this.controller.handleCommand(this.playArea.getInput());
                    this.playArea.clearInput();
                }
        );

        Pane root = new VBox();
        root.getChildren().add(this.roomNameLabel);
        root.getChildren().add(this.playArea);
        root.getChildren().add(sendCommand);
        root.getChildren().add(new ControlBar(e -> {
            primaryStage.close();
            LOG.info("Close GUI");
        }));

        Scene scene = new Scene(root, 600, 500);
        scene.getAccelerators().put(
                new KeyCodeCombination(KeyCode.ENTER),
                sendCommand::fire
        );

        primaryStage.setScene(scene);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
        this.controller.onGameStart();
    }

    public void showMessage(String msg) { this.playArea.updateAreaText(msg); }

    public void showError(String msg) { this.playArea.updateAreaText(msg, Color.RED);}

    public void showRoom(Room room) { this.roomNameLabel.setText(room.getName()); }

    public void showRoom(String roomName) { this.roomNameLabel.setText(roomName); }
}
