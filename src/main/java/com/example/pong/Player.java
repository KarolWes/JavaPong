package com.example.pong;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player {
    private KeyCode upKey, downKey;
    private int x, y, points;
    private Rectangle skin;

    public Player(KeyCode upKey, KeyCode downKey, boolean side) {
        this.upKey = upKey;
        this.downKey = downKey;
        this.y = 250;
        if(side){
            this.x = 30;
        }
        else{
            this.x = 560;
        }
        points = 0;
        skin = new Rectangle(10, 50, Color.WHITE);
        skin.setX(x); skin.setY(y);
    }

    public KeyCode getUpKey() {
        return upKey;
    }

    public KeyCode getDownKey() {
        return downKey;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPoints() {
        return points;
    }

    public Rectangle getSkin() {
        return skin;
    }
}
