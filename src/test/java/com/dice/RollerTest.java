package com.dice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;



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

    @Test
    public void rollMultiplesDices() {
        String s = "3D8";
        List<Integer> list = new ArrayList<Integer>();
        list = roller.rollMultiplesDices(s);
        assert list.stream().count() == 3;
    }
}