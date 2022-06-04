package com.corretinhoscorp;

import javafx.scene.control.Button;

public class TitleButton extends Button {
    private boolean bomb;
    private boolean clicked;
    private int nearbybombs;

    public TitleButton(boolean bomb){
        this.bomb = bomb;
        this.setText("");
        this.setMinWidth(50);
        this.setMinHeight(50);
    }

    public boolean isBomb(){
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

    public void setNearbyBombs(int nearbybombs) {
        this.nearbybombs = nearbybombs;
    }
}
