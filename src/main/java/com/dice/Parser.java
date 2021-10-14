package com.dice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Parser {
    public Integer parse(String command) throws CustomException {
        if (command.equals("0")) {
            throw new CustomException("Impossible de simuler un dé à 0 faces");
        } else {
            int i = Integer.parseInt(command);
            if (i > 0) {
                return Integer.getInteger(String.valueOf(i));
            } else {
                throw new CustomException("Impossible de simuler avec un nombre négatif de dé ou de faces");
            }
        }

    }

    public Map<String, Integer> parseList(String stringList) throws CustomException {
        List<String> strings = Arrays.asList(stringList.split("D"));

        // Nombre avant le D
        Integer numberOfDice = parse(strings.get(0));

        // Ce qui se trouve après le "D"
        List<String> secondPart = Arrays.asList(strings.get(1).split("\\+"));
        // Nombre juste après le "D"
        Integer numberOfFaces = parse(secondPart.get(0));
        Integer bonus = 0;
        //on recup le bonus apres le +
        if (secondPart.size() == 2) {
            bonus = parse(secondPart.get(1));
        }


        //On bourre tout dans une map pour le passer a roller
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("numberOfDice", numberOfDice);
        stringIntegerMap.put("numberOfFaces", numberOfFaces);
        stringIntegerMap.put("bonus", bonus);

        return stringIntegerMap;
    }
}
