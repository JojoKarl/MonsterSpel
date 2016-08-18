package com.company;


public class Player {
    public int x;
    public int y;

    public Player(int positionX, int positionY) {
        this.x = positionX;
        this.y = positionY;
    }

    public int getXposition() {
        return x;
    }

    public int getYposition() {
        return y;
    }

    public void changeXPosition(int steps) {
        this.x += steps;
    }

    public void changeYPosition(int steps) {
        this.y += steps;
    }
}



