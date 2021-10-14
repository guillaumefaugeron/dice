package com.dice;

public class Main {

    public static void main(String[] args) {
        System.out.println("le main");
        Roller roller = new Roller();
        System.out.print(roller.roll(5));
    }
}
