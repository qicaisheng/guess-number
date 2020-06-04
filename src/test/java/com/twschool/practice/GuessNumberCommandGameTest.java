package com.twschool.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuessNumberCommandGameTest {
    
    private GuessNumberCommandGame guessNumberCommandGame;
    
    @Before
    public void setUp() throws Exception {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1 2 3 4");
        guessNumberCommandGame = new GuessNumberCommandGame(guessNumberGame);
    }

    @Test
    public void should_output_Wrong_input_when_input_1134_given_game_with_answer_1234() {
        String result = guessNumberCommandGame.guess("1 1 3 4");

        Assert.assertEquals("Wrong Input，Input again", result);
    }

    @Test
    public void should_output_Wrong_input_when_input_12_given_game_with_answer_1234() {
        String result = guessNumberCommandGame.guess("1 2");

        Assert.assertEquals("Wrong Input，Input again", result);
    }


}