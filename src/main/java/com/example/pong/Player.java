package com.example.pong;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player {
    private int x, y, points;
    private Rectangle skin;
    private int xSize, ySize;
    private int height = 50, width = 10;
    private int sideGap = 30, topGap;
    private int speed = 10;

    public Player(boolean side, int xSize, int ySize, int topGap) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.topGap = topGap;
        this.y = (ySize - height)/2+topGap;
        if(side){
            this.x = sideGap;
        }
        else{
            this.x = xSize - sideGap - width;
        }
        points = 0;
        skin = new Rectangle(width, height, Color.WHITE);
        skin.setX(x); skin.setY(y);
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

    public void move(boolean up){
        if(up){
            if(y - speed > topGap){
                y-= speed;
            }
        }
        else{
            if(y + height + speed < ySize){
                y+=speed;
            }
        }
        skin.setX(x); skin.setY(y);
    }
}
