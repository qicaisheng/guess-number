package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class GuessNumberGameTest {

    @Test
    public void should_output_1A0B_when_input_1567_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1234");
        
        String result = guessNumberGame.guess("1 5 6 7");

        Assert.assertEquals("1A0B", result);
    }
}
