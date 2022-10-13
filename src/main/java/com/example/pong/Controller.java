package com.example.pong;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private Pane mainWindow;
    private Player playerLeft, playerRight;
    public void initialize()
    {
        mainWindow.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        playerLeft = new Player(KeyCode.W, KeyCode.S, false);
        playerRight = new Player(KeyCode.I, KeyCode.K, true);
        mainWindow.getChildren().add(playerLeft.getSkin());
        mainWindow.getChildren().add(playerRight.getSkin());
    }
}