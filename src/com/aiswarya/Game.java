package com.aiswarya;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ashprakasan on 14/12/17.
 */
public class Game {
    ArrayList<Player> players;
    IScoringStrategy scoringStrategy;
    int numSets;
    int n;
    static Scanner s;

    public Game(int numSets, int n) {
        scoringStrategy = new ScoringStrategy();
        players = new ArrayList<>();
        this.numSets = numSets;
        this.n = n;
        s = new Scanner(System.in);
        System.out.println("Enter player names one by one");
        String name;
        for (int i = 0; i < n; i++) {
            name = s.nextLine();
            players.add(new Player(name));
        }
        System.out.println("Players are- ");
        for (Player each : players) {
            System.out.print(each.getName() + " ");
        }
    }
    void print(ArrayList<Character> inp){
        for(char each:inp){
            System.out.print(each+" ");
        }
        System.out.println("\n");
    }
    void initialisePlayerScoresToZero(){
        for(Player each: players){
            each.resetScore();
        }
    }
    void printScore(){
        for(Player each:players){
            System.out.println(each.getName()+" : "+scoringStrategy.calculateScore(each));
        }
    }
    void printResult() {
        Player winner = players.get(0);
        int maxScore= -1;
        int score;
        System.out.println("*********");
        for (Player each : players) {
            score = scoringStrategy.calculateScore(each);
            if(score>maxScore){
                maxScore = score;
                winner = each;
            }
            System.out.println(each.getName()+" : "+ score);
        }
        System.out.println("The winner is "+winner.getName());
    }

    void takeInput() {
        System.out.println("\nInput -");
        ArrayList<Character> input = new ArrayList<>();
        while (true) {
            input.add(s.nextLine().charAt(0));
            initialisePlayerScoresToZero();
            processInput(input);
            printResult();
        }
    }

    private void processInput(ArrayList<Character> input) {
        int pptr = 0;
        int round = 0;
        int set = 1;
        for (int i = 0; i < input.size(); i++) {
            Player currPlayer = players.get(pptr);
            currPlayer.play(input.get(i));
            if (set != numSets) {
                if (input.get(i) == 'X') {
                    round = 0;
                    if (pptr == players.size() - 1)
                        set++;
                    pptr = (pptr + 1) % n;
                } else {
                    if (round == 1) {
                        round = 0;
                        if (pptr == players.size() - 1)
                            set++;
                        pptr = (pptr + 1) % n;
                    } else {
                        round = 1;
                    }
                }
            } else {
                switch (round) {
                    case 0:
                        if(input.get(i)=='X')
                            round = 1;
                        else
                            round = 2;
                        break;
                    case 1:
                        if (input.get(i) == 'X') {
                            round = 0;
                            if (pptr == players.size() - 1)
                                set++;
                            pptr = (pptr + 1) % n;
                        } else {
                            round = 2;
                        }
                        break;
                    case 2:
                        round = 0;
                        if (pptr == players.size() - 1)
                            set++;
                        pptr = (pptr + 1) % n;
                }
            }
        }
    }
}

