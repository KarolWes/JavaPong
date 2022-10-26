package com.example.pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {
    private double x, y;
    private final int xSize, ySize, topGap, sideGap;
    private double dir;

    private final int speed =2;
    private final int radius = 5;
    private final Circle skin;

    public Ball(int xSize, int ySize, int topGap, int sideGap) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.topGap = topGap;
        this.sideGap = sideGap;
        this.x = (xSize-radius)/2.0;
        this.y = (ySize - radius)/2.0+topGap;
        this.dir = Math.PI - (MainApplication.rand.nextFloat()*Math.PI/2+Math.PI/4); // 0 => down, anticlockwise
        skin = new Circle(x, y, radius, Color.WHITE);
    }

    public Circle getSkin() {
        return skin;
    }
    public void move(){
        x+=speed*Math.sin(dir);
        y+=speed*Math.cos(dir);
        if(checkTopBottom()){
            dir = Math.PI - dir;
        }
        skin.setCenterX(x);
        skin.setCenterY(y);
    }
    public void reset(boolean winningSide){ // side == true => left
        x = (xSize-radius)/2.0;
        y = (ySize - radius)/2.0+topGap;
        if(winningSide){
            dir = Math.PI - (MainApplication.rand.nextFloat()*Math.PI/2+Math.PI/4);
        }
        else{
            dir = (Math.PI - (MainApplication.rand.nextFloat()*Math.PI/2+Math.PI/4))*(-1);
        }

        skin.setCenterX(x);
        skin.setCenterY(y);
    }
    public boolean bounce(Player p){
        int pTop = p.getY();
        int pBottom = p.getY() + p.getHeight();
        int pCenter = (int) (p.getY() + 0.5*p.getHeight());
        if(y >= pTop && y <= pBottom){
            double proportion = (Math.abs(y-pCenter))/(0.5*p.getHeight());
            boolean up = y < pCenter;
            dir *= -1;
            if(p.isLeft()){
                if(up){
                    dir -= proportion*Math.PI/3;
                }
                else{
                    dir += proportion*Math.PI/3;
                }
            }
            else{
                if(up){
                    dir += proportion*Math.PI/3;
                }
                else{
                    dir -= proportion*Math.PI/3;
                }
            }

            return false;
        }
        else{return true;}
    }
    public int out(){
        if(x - radius < sideGap){
            //left
            return -1;
        }
        else if(x + radius > xSize - sideGap){
            //right
            return 1;
        }
        else{
            return 0; // none
        }
    }
    private boolean checkTopBottom(){
        if(y-radius <= topGap || y+radius >= ySize){
            return true;
        }
        else{
            return false;
        }
    }
}
