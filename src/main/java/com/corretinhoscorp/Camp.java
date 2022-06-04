package com.corretinhoscorp;

import java.util.Random;

public class Camp {
    TitleButton bombs[][];
    Random r = new Random();
    public Camp(int x, int y){
        bombs = new TitleButton[x][y];
    }

    public void populateArray() {
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                bombs[i][j] = new TitleButton(r.nextBoolean());
            }
        }
    }

    public void printArray() {
        calcNearBombs();
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                System.out.print("|");
                if (bombs[i][j].isBomb() == true) {
                    System.out.print("B");
                } else {
//                    System.out.print("S"+""+bombs[i][j].getNearbyBombs());
                    System.out.print(bombs[i][j].getNearbyBombs());
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }

    public void calcNearBombs() {
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs[i].length; j++) {
                int cont = 0;
                if (i > 0 && bombs[i-1][j].isBomb() == true) {
                    cont++;
                }
                if(i < bombs.length-1 && bombs[i+1][j].isBomb() == true){
                    cont++;
                }
                if(j > 0 && bombs[i][j-1].isBomb() == true){
                    cont++;
                }
                if(j < bombs[i].length-1 && bombs[i][j+1].isBomb() == true){
                    cont++;
                }
                if(i > 0 && j > 0 && bombs[i-1][j-1].isBomb() == true){
                    cont++;
                }
                if(i > 0 && j < bombs[i].length-1 && bombs[i-1][j+1].isBomb() == true){
                    cont++;
                }
                if(i < bombs.length-1 && j > 0 && bombs[i+1][j-1].isBomb() == true){
                    cont++;
                }
                if(i < bombs.length-1 && j < bombs[i].length-1 && bombs[i+1][j+1].isBomb() == true){
                    cont++;
                }
                bombs[i][j].setNearbyBombs(cont);
            }
        }
    }
}
