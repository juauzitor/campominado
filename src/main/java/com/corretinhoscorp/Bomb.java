package com.corretinhoscorp;

public class Bomb {
    private boolean bomb;
    private boolean clicked;
    private int nearbybombs;

    public Bomb(boolean bomb){
        this.bomb = bomb;
    }

    public boolean isBomb() {
        return bomb;        
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked() {
        if (clicked == false) {
            this.clicked = true;
        } else {
            this.clicked = false;
        }
    }

    public int getNearbyBombs() {
        return nearbybombs;
    }

    public void setNearbyBombs() {
        this.nearbybombs = nearbybombs;
    }
}
