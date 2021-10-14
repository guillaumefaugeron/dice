package com.dice;

public class Main {

    public static void main(String[] args) throws CustomException {
        Parser parser = new Parser();
        System.out.print(parser.parseList("3D8+152"));
    }
}
