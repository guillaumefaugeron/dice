package com.dice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {
    private Parser parser;

    @BeforeEach
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void parseAnIntAsTheNumberOfFaces() throws CustomException {
        String input = "3";
        int faces = parser.parse(input);
        assertEquals(3, faces);
    }

    @Test
    public void parseAnotherIntAsTheNumberOfFaces() throws CustomException {
        String input = "6";
        int faces = parser.parse(input);
        assertEquals(6, faces);
    }
    @Test
    public void shouldNotBeAbleToSimulateAZeroFaceDice() {
        String input = "0";
        assertThrows( CustomException.class,() -> parser.parse(input));
    }


    @Test
    public void shouldNotBeAbleToSimulateANegativeFaceDice() {
        String input = "-5";
        assertThrows( CustomException.class,() -> parser.parse(input));
    }


    @Test
    public void shouldBeAbleToSimulateMultiplesDices() throws CustomException {
        String s = "3D8";
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap = parser.parseList(s);
        int numberOfDices = stringIntegerMap.get("numberOfDice");
        int numberOfFaces = stringIntegerMap.get("numberOfFaces");

        assertEquals(3, numberOfDices);
        assertEquals(8, numberOfFaces);
    }

}