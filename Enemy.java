package com.company;

/**
 * Created by Administrator on 2016-08-17.
 */
public class Enemy {
    public int x;
    public int y;

    public Enemy(int positionX, int positionY) {
        this.x = positionX;
        this.y = positionY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void changeXPosition(int steps) {
        this.x += steps;
    }

    public void changeYPosition(int steps) {
        this.y += steps;
    }


}

