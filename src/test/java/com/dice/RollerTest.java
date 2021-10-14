package com.dice;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;


@ExtendWith(MockitoExtension.class)
public class RollerTest {
    private Roller roller;

    @Mock
    private static Parser parser;

    @BeforeEach
    public void setUp() {
        roller = new Roller();
    }

    @Test
    public void rollDice() throws CustomException {
        //given
        int rolledDice = roller.rollWithString("5");

        //when
        lenient().when(parser.parse(any())).thenReturn(5);

        //then
        assert  1 <= rolledDice & rolledDice <= 5;
    }
}