package com.example.pong;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private Pane mainWindow;
    private Player playerLeft, playerRight;
    private int xSize = 600, ySize = 650;
    private int topGap = 50;
    private int leftDir = 0, rightDir = 0;
    public void initialize()
    {
        mainWindow.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        playerLeft = new Player(true, xSize, ySize, topGap);
        playerRight = new Player(false, xSize, ySize, topGap);
        mainWindow.getChildren().add(playerLeft.getSkin());
        mainWindow.getChildren().add(playerRight.getSkin());
        timer.start();
    }

    public AnimationTimer timer = new AnimationTimer() {

        @Override
        public void handle(long l) {
            //System.out.println("left: " + leftDir + " right: " + rightDir);
            if(leftDir == -1){
                playerLeft.move(true);
            }
            else if(leftDir == 1){
                playerLeft.move(false);
            }
            if(rightDir == -1){
                playerRight.move(true);
            }
            else if(rightDir == 1){
                playerRight.move(false);
            }
        }
    };

    public EventHandler<KeyEvent> handleKeyPressed = new EventHandler<>() {
        @Override
        public void handle(KeyEvent keyEvent) {
            switch (keyEvent.getCode()) {
                case W:
                    leftDir = -1;
                    break;
                case S:
                    leftDir = 1;
                    break;
                case I:
                    rightDir = -1;
                    break;
                case K:
                    rightDir = 1;
                    break;
            }
        }
    };


    public EventHandler<KeyEvent> handleKeyReleased = new EventHandler<>() {
        @Override
        public void handle(KeyEvent keyEvent) {
            switch (keyEvent.getCode()) {
                case W, S:
                    leftDir = 0;
                case I, K:
                    rightDir = 0;
                default:
                    break;
            }
        }
    };

}