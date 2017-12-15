package com.aiswarya;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        Game game1 = new Game(3, 2);
        game1.takeInput();
        game1.printResult();
    }
}
