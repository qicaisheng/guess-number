package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class GuessNumberGameTest {

    @Test
    public void should_output_1A0B_when_input_1567_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1 2 3 4");
        
        String result = guessNumberGame.guess("1 5 6 7");

        Assert.assertEquals("1A0B", result);
    }

    @Test
    public void should_output_0A2B_when_input_2478_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1 2 3 4");

        String result = guessNumberGame.guess("2 4 7 8");

        Assert.assertEquals("0A2B", result);
    }

    @Test
    public void should_output_1A2B_when_input_0324_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1 2 3 4");

        String result = guessNumberGame.guess("0 3 2 4");

        Assert.assertEquals("1A2B", result);
    }

    @Test
    public void should_output_4A0B_when_input_1234_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1 2 3 4");

        String result = guessNumberGame.guess("1 2 3 4");

        Assert.assertEquals("4A0B", result);
    }

    @Test
    public void should_output_Wrong_input_when_input_1134_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1 2 3 4");

        String result = guessNumberGame.guess("1 1 3 4");

        Assert.assertEquals("Wrong Input，Input again", result);
    }

    @Test
    public void should_output_Wrong_input_when_input_12_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1 2 3 4");

        String result = guessNumberGame.guess("1 2");

        Assert.assertEquals("Wrong Input，Input again", result);
    }

    @Test
    public void should_be_init_pending_status_given_game() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1 2 3 4");
        
        Assert.assertEquals(GameStatus.PENDING, guessNumberGame.getStatus());
    }


    @Test
    public void should_be_succeed_when_input_1234_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1 2 3 4");

        guessNumberGame.guess("1 2 3 4");
        
        Assert.assertEquals(GameStatus.SUCCEED, guessNumberGame.getStatus());
    }

    @Test
    public void should_decrease_try_times_when_input_1534_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1 2 3 4");
        
        guessNumberGame.guess("1 5 3 4");

        Assert.assertEquals(5, guessNumberGame.getTryTimes());
    }

    @Test
    public void should_be_failed_when_input_1534_given_game_with_answer_1234_and_try_times_1() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1 2 3 4");
        guessNumberGame.guess("1 5 3 4");
        guessNumberGame.guess("1 5 3 4");
        guessNumberGame.guess("1 5 3 4");
        guessNumberGame.guess("1 5 3 4");
        guessNumberGame.guess("1 5 3 4");
        
        guessNumberGame.guess("1 5 3 4");

        Assert.assertEquals(GameStatus.FAILED, guessNumberGame.getStatus());
    }

    @Test
    public void should_output_result_and_history_when_input_2478_given_game_with_answer_1234() {
        GuessNumberGame guessNumberGame = new GuessNumberGame("1 2 3 4");
        guessNumberGame.guess("1 5 6 7");
        
        String result = guessNumberGame.guess("2 4 7 8");

        Assert.assertEquals("0A2B", result);
        Assert.assertEquals("\n1 5 6 7        1A0B\n2 4 7 8        0A2B", guessNumberGame.getGameHistoriesString());
    }

    @Test
    public void should_get_pending_status_from_history_given_2_histories_and_last_history_is_not_succeed() {
        GuessNumberGame guessNumberGame = Mockito.spy(new GuessNumberGame("1 2 3 4"));

        List<GameHistory> gameHistories = new ArrayList<>();
        gameHistories.add(new GameHistory(new Answer("1 5 6 7"), new CompareResult(1, 0)));
        gameHistories.add(new GameHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        Mockito.when(guessNumberGame.getGameHistories()).thenReturn(gameHistories);
        
        Assert.assertEquals(GameStatus.PENDING, guessNumberGame.getStatus());
    }

    @Test
    public void should_get_failed_status_from_history_given_6_histories_and_last_history_is_not_succeed() {
        GuessNumberGame guessNumberGame = Mockito.spy(new GuessNumberGame("1 2 3 4"));

        List<GameHistory> gameHistories = new ArrayList<>();
        gameHistories.add(new GameHistory(new Answer("1 5 6 7"), new CompareResult(1, 0)));
        gameHistories.add(new GameHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        gameHistories.add(new GameHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        gameHistories.add(new GameHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        gameHistories.add(new GameHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        gameHistories.add(new GameHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        Mockito.when(guessNumberGame.getGameHistories()).thenReturn(gameHistories);

        Assert.assertEquals(GameStatus.FAILED, guessNumberGame.getStatus());
    }

    @Test
    public void should_get_succeed_status_from_history_given_last_history_is_succeed() {
        GuessNumberGame guessNumberGame = Mockito.spy(new GuessNumberGame("1 2 3 4"));

        List<GameHistory> gameHistories = new ArrayList<>();
        gameHistories.add(new GameHistory(new Answer("1 5 6 7"), new CompareResult(1, 0)));
        gameHistories.add(new GameHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        gameHistories.add(new GameHistory(new Answer("1 2 3 4"), new CompareResult(4, 0)));
        Mockito.when(guessNumberGame.getGameHistories()).thenReturn(gameHistories);

        Assert.assertEquals(GameStatus.SUCCEED, guessNumberGame.getStatus());
    }
}
