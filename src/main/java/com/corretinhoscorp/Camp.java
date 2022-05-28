package com.corretinhoscorp;

import java.util.Random;

public class Camp {
    Bomb bombs[][];
    Random r = new Random();
    public Camp(int x, int y){
        bombs = new Bomb[x][y];
    }

    public void populateArray() {
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                bombs[i][j] = new Bomb(r.nextBoolean());
            }
        }
    }

    public void printArray() {
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                System.out.print("|");
                if (bombs[i][j].isBomb() == true) {
                    System.out.print("B");
                } else {
                    System.out.print("S");
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}
