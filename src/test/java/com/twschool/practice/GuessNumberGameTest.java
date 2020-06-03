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

    @Test
    public void should_output_0A2B_when_input_2478_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1234");

        String result = guessNumberGame.guess("2 4 7 8");

        Assert.assertEquals("0A2B", result);
    }

    @Test
    public void should_output_1A2B_when_input_0324_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1234");

        String result = guessNumberGame.guess("0 3 2 4");

        Assert.assertEquals("1A2B", result);
    }

    @Test
    public void should_output_4A0B_when_input_1234_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1234");

        String result = guessNumberGame.guess("1 2 3 4");

        Assert.assertEquals("4A0B", result);
    }

    @Test
    public void should_output_Wrong_input_when_input_1134_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1234");

        String result = guessNumberGame.guess("1 1 3 4");

        Assert.assertEquals("Wrong Input，Input again", result);
    }

    @Test
    public void should_output_Wrong_input_when_input_12_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1234");

        String result = guessNumberGame.guess("1 2");

        Assert.assertEquals("Wrong Input，Input again", result);
    }

}
