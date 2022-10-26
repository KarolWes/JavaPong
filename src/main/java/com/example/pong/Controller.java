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
    //private Line topLine, middleLine;
    private Ball ball;

    private int leftDir = 0, rightDir = 0;
    public void initialize()
    {
        mainWindow.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        int xSize = 600, ySize = 650;
        int topGap = 50, sideGap=30;
        playerLeft = new Player(true, xSize, ySize, topGap, sideGap);
        playerRight = new Player(false, xSize, ySize, topGap, sideGap);
        ball = new Ball(xSize, ySize, topGap,sideGap);
//        topLine = new Line(100, topGap, xSize, topGap);
//        topLine.setFill(Color.WHITE);
//        topLine.setStrokeWidth(5);
        mainWindow.getChildren().add(playerLeft.getSkin());
        mainWindow.getChildren().add(playerLeft.getPointText());
        mainWindow.getChildren().add(playerRight.getSkin());
        mainWindow.getChildren().add(playerRight.getPointText());
        mainWindow.getChildren().add(ball.getSkin());
        //mainWindow.getChildren().add(topLine);

        timer.start();
    }

    public AnimationTimer timer = new AnimationTimer() {

        @Override
        public void handle(long l) {
            //System.out.println("left: " + leftDir + " right: " + rightDir);
            playerMove();
            ballMove();
        }
    };

    private void ballMove() {
        ball.move();
        int out = ball.out();
        if(out != 0){
            if(out == -1){
                if(ball.bounce(playerLeft)){
                    playerRight.updatePoints();
                    ball.reset(true);
                }
            }
            if(out == 1){
                if(ball.bounce(playerRight)){
                    playerLeft.updatePoints();
                    ball.reset(false);
                }
            }

        }

    }

    private void playerMove() {
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

    public EventHandler<KeyEvent> handleKeyPressed = keyEvent -> {
        switch (keyEvent.getCode()) {
            case W -> leftDir = -1;
            case S -> leftDir = 1;
            case I -> rightDir = -1;
            case K -> rightDir = 1;
        }
    };


    public EventHandler<KeyEvent> handleKeyReleased = keyEvent -> {
        switch (keyEvent.getCode()) {
            case W, S:
                leftDir = 0;
            case I, K:
                rightDir = 0;
            default:
                break;
        }
    };

}