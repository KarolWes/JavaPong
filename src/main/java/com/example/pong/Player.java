package com.example.pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Player {
    private final int x;
    private int y;
    private int points;
    private final Rectangle skin;
    private final Text pointText;
    private final int ySize;
    private final int height = 50, width = 10;
    private final int topGap;
    private final int speed = 5;
    private final boolean side;

    public Player(boolean side, int xSize, int ySize, int topGap, int sideGap) {// side == true => left
        this.ySize = ySize;
        this.topGap = topGap;
        this.side = side;
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
        pointText = new Text(String.valueOf(points));
        pointText.setY(topGap-25);
        if(side){
            pointText.setX(xSize/4.0);
        }
        else{
            pointText.setX(3*xSize/4.0);
        }
        pointText.setFill(Color.WHITE);
        pointText.setFont(Font.font(20));
    }


    public int getY() {
        return y;
    }
    public int getHeight(){
        return height;
    }

    public boolean isLeft() {
        return side;
    }

    public void updatePoints(){
        points+=1;
        pointText.setText(String.valueOf(points));
    }

    public Rectangle getSkin() {
        return skin;
    }
    public Text getPointText(){
        return pointText;
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
