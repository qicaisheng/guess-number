package com.twschool.practice.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessNumberGameTest {
    
    private GuessNumberGame guessNumberGame;

    @BeforeEach
    public void setUp() throws Exception {
        RandomAnswerGenerator answerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(answerGenerator.generateAnswer()).thenReturn(new Answer("1 2 3 4"));
        guessNumberGame = new GuessNumberGame(answerGenerator);
    }

    @Test
    public void should_output_1A0B_when_input_1567_given_game_with_answer_1234() {
        String result = guessNumberGame.guess(new Answer("1 5 6 7")).toString();

        assertEquals("1A0B", result);
    }

    @Test
    public void should_output_0A2B_when_input_2478_given_game_with_answer_1234() {
        String result = guessNumberGame.guess(new Answer("2 4 7 8")).toString();

        assertEquals("0A2B", result);
    }

    @Test
    public void should_output_1A2B_when_input_0324_given_game_with_answer_1234() {
        String result = guessNumberGame.guess(new Answer("0 3 2 4")).toString();

        assertEquals("1A2B", result);
    }

    @Test
    public void should_output_4A0B_when_input_1234_given_game_with_answer_1234() {
        String result = guessNumberGame.guess(new Answer("1 2 3 4")).toString();

        assertEquals("4A0B", result);
    }
    
    @Test
    public void should_be_init_pending_status_given_game() {
        assertEquals(GameStatus.PENDING, guessNumberGame.getStatus());
    }


    @Test
    public void should_be_succeed_when_input_1234_given_game_with_answer_1234() {
        guessNumberGame.guess(new Answer("1 2 3 4"));
        
        assertEquals(GameStatus.SUCCEED, guessNumberGame.getStatus());
    }

    @Test
    public void should_decrease_try_times_when_input_1534_given_game_with_answer_1234() {
        guessNumberGame.guess(new Answer("1 5 3 4"));

        assertEquals(5, guessNumberGame.getTryTimes());
    }

    @Test
    public void should_be_failed_when_input_1534_given_game_with_answer_1234_and_try_times_1() {
        guessNumberGame.guess(new Answer("1 5 3 4"));
        guessNumberGame.guess(new Answer("1 5 3 4"));
        guessNumberGame.guess(new Answer("1 5 3 4"));
        guessNumberGame.guess(new Answer("1 5 3 4"));
        guessNumberGame.guess(new Answer("1 5 3 4"));

        guessNumberGame.guess(new Answer("1 5 3 4"));

        assertEquals(GameStatus.FAILED, guessNumberGame.getStatus());
    }

    @Test
    public void should_get_history_when_input_2478_given_game_with_answer_1234() {
        guessNumberGame.guess(new Answer("1 5 6 7"));
        
        guessNumberGame.guess(new Answer("2 4 7 8"));

        List<GuessHistory> guessHistories = guessNumberGame.getGuessHistories();
        assertEquals(2, guessHistories.size());
        assertEquals("0A2B", guessHistories.get(1).getCompareResult().toString());
    }

    @Test
    public void should_get_pending_status_from_history_given_2_histories_and_last_history_is_not_succeed() {
        GuessNumberGame spyGuessNumberGame = Mockito.spy(guessNumberGame);

        List<GuessHistory> gameHistories = new ArrayList<>();
        gameHistories.add(new GuessHistory(new Answer("1 5 6 7"), new CompareResult(1, 0)));
        gameHistories.add(new GuessHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        Mockito.when(spyGuessNumberGame.getGuessHistories()).thenReturn(gameHistories);
        
        assertEquals(GameStatus.PENDING, spyGuessNumberGame.getStatus());
    }

    @Test
    public void should_get_failed_status_from_history_given_6_histories_and_last_history_is_not_succeed() {
        GuessNumberGame spyGuessNumberGame = Mockito.spy(guessNumberGame);

        List<GuessHistory> gameHistories = new ArrayList<>();
        gameHistories.add(new GuessHistory(new Answer("1 5 6 7"), new CompareResult(1, 0)));
        gameHistories.add(new GuessHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        gameHistories.add(new GuessHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        gameHistories.add(new GuessHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        gameHistories.add(new GuessHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        gameHistories.add(new GuessHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        Mockito.when(spyGuessNumberGame.getGuessHistories()).thenReturn(gameHistories);

        assertEquals(GameStatus.FAILED, spyGuessNumberGame.getStatus());
    }

    @Test
    public void should_get_succeed_status_from_history_given_last_history_is_succeed() {
        GuessNumberGame spyGuessNumberGame = Mockito.spy(guessNumberGame);

        List<GuessHistory> gameHistories = new ArrayList<>();
        gameHistories.add(new GuessHistory(new Answer("1 5 6 7"), new CompareResult(1, 0)));
        gameHistories.add(new GuessHistory(new Answer("2 4 7 8"), new CompareResult(0, 2)));
        gameHistories.add(new GuessHistory(new Answer("1 2 3 4"), new CompareResult(4, 0)));
        Mockito.when(spyGuessNumberGame.getGuessHistories()).thenReturn(gameHistories);

        assertEquals(GameStatus.SUCCEED, spyGuessNumberGame.getStatus());
    }

    @Test
    void should_return_succeed_when_status_is_succeed() {
        GuessNumberGame spyGuessNumberGame = Mockito.spy(guessNumberGame);
        Mockito.when(spyGuessNumberGame.getStatus()).thenReturn(GameStatus.SUCCEED);

        boolean succeed = spyGuessNumberGame.isSucceed();
        
        assertTrue(succeed);
    }

    @Test
    void should_return_failed_when_status_is_failed() {
        GuessNumberGame spyGuessNumberGame = Mockito.spy(guessNumberGame);
        Mockito.when(spyGuessNumberGame.getStatus()).thenReturn(GameStatus.FAILED);

        boolean failed = spyGuessNumberGame.isFailed();

        assertTrue(failed);

    }

    @Test
    void should_return_game_ended_when_status_is_failed_or_succeed() {
        GuessNumberGame spyGuessNumberGame = Mockito.spy(guessNumberGame);

        Mockito.when(spyGuessNumberGame.getStatus()).thenReturn(GameStatus.SUCCEED);
        assertTrue(spyGuessNumberGame.isEndGame());

        Mockito.when(spyGuessNumberGame.getStatus()).thenReturn(GameStatus.FAILED);
        assertTrue(spyGuessNumberGame.isEndGame());

    }

}
