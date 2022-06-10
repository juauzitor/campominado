package com.corretinhoscorp;

import javafx.scene.control.Button;

public class GroundButton extends Button { 
    private boolean bomb; 
    private boolean clicked;
    private int nearbybombs;

    public GroundButton(){
        this.bomb = false;
        this.clicked = false;
        this.setText("");
        this.setMinWidth(50);
        this.setMinHeight(50);
    }

    public boolean isBomb(){ // função que retorna se é bomba ou não 
        return bomb;
    }

    public void setBomb() { // função que seta  bomba
        if (bomb == false) {
            this.bomb = true;
        } else {
            this.bomb = false;
        }
    }

    public boolean isClicked() { //função de evento de clique
        return clicked;
    } 

    public void setClicked() { //função que alterna o evento de não clicado para clicado
        if (clicked == false) {
            this.clicked = true;
        } else {
            this.clicked = false;
        }
    }

    public int getNearbyBombs() { // função que retorna o numero inteiro de bombas ao redor
        return nearbybombs;
    }

    public void setNearbyBombs(int nearbybombs) { // seta o numero inteiro de bombas ao redor
        this.nearbybombs = nearbybombs;
    }

    
}
