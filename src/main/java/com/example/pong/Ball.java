package com.example.pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {
    private double x, y;
    private final int xSize, ySize, topGap, sideGap;
    private double dir;

    private final int speed =5;
    private final int radius = 5;
    private final Circle skin;

    public Ball(int xSize, int ySize, int topGap, int sideGap) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.topGap = topGap;
        this.sideGap = sideGap;
        this.x = (xSize-radius)/2.0;
        this.y = (ySize - radius)/2.0+topGap;
        this.dir = MainApplication.rand.nextFloat()*Math.PI/2+Math.PI/4;

        skin = new Circle(x, y, radius, Color.WHITE);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDir() {
        return dir;
    }

    public Circle getSkin() {
        return skin;
    }
    public void move(){
        x+=speed*Math.sin(dir);
        y+=speed*Math.cos(dir);
        skin.setCenterX(x);
        skin.setCenterY(y);
    }
    public void bounce(){

    }
    public boolean out(){
        return true;
    }
}
