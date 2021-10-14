package com.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Roller {
    Random random = new Random();
    Parser parser = new Parser();

    //lance un dé
    public int roll(int facesNumber){
        return random.ints(1,facesNumber+1).findFirst().getAsInt();
    }

    //lance un dé a partir d'une string
    public int rollWithString(String s) throws CustomException {
        return roll(parser.parse(s));
    }


    public List<Integer> rollMultiplesDices(String s) {
        List<Integer> list = new ArrayList<Integer>();
        try {
            Map<String, Integer> stringIntegerMap = parser.parseList(s);
            int numberOfDices = stringIntegerMap.get("numberOfDice");
            int numberOfFaces = stringIntegerMap.get("numberOfFaces");
            int bonus = stringIntegerMap.get("bonus");
            stringIntegerMap.containsKey("bonus");
            for(Integer i=0; i < numberOfDices; i++) {
                list.add(roll(numberOfFaces + bonus));
            }

            return list;
        } catch (CustomException e) {
            e.printStackTrace();
        }

        return list;
    }
}
