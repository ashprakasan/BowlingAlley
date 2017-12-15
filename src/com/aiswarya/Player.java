package com.aiswarya;

import java.util.ArrayList;

/**
 * Created by ashprakasan on 14/12/17.
 */
public class Player {
    String name;
    ArrayList<Character> score;

//    public Player(){
//        this("Name PlaceHolder");
//    }
    public Player(String name) {
        this.name = name;
        score = new ArrayList<>();
    }

     String getName() {
        return name;
    }

     ArrayList<Character> getScore() {
        return score;
    }

    void play(char x){
        score.add(x);
    }
    void resetScore(){
        score = new ArrayList<>();
    }
}
