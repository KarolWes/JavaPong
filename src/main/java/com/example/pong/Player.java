package com.example.pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player {
    private final int x;
    private int y;
    private int points;
    private final Rectangle skin;
    private final int ySize;
    private final int height = 50, width = 10;
    private final int topGap;
    private int speed = 10;

    public Player(boolean side, int xSize, int ySize, int topGap, int sideGap) {
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
