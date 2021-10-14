package com.dice;

import java.util.Random;

public class Roller {
    Random random = new Random();
    Parser parser = new Parser();

    public int roll(int facesNumber){
        return random.ints(1,facesNumber+1).findFirst().getAsInt();
    }
    public int rollWithString(String s) throws CustomException {
        return roll(parser.parse(s));
    }
}
