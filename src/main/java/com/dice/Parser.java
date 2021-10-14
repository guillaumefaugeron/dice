package com.dice;

class Parser {
    public int parse(String command) throws CustomException {
        if(command.equals("0")){
            throw new CustomException("Impossible de simuler un dé à 0 faces");
        } else {
            return Integer.parseInt(command);
        }

    }
}
