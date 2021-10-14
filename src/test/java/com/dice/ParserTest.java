package com.dice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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


}