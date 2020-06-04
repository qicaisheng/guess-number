package com.twschool.practice.service;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.CompareResult;
import com.twschool.practice.domain.GuessHistory;
import com.twschool.practice.domain.GuessNumberGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

class GuessNumberGameServiceTest {
    
    private GuessNumberGameService guessNumberGameService;
    private GuessNumberGame guessNumberGame;
    
    @BeforeEach
    void setUp() {
        guessNumberGameService = Mockito.spy(new GuessNumberGameService());
        guessNumberGame = Mockito.mock(GuessNumberGame.class);
        Mockito.when(guessNumberGame.guess(Mockito.any())).thenReturn(new CompareResult(1, 2));
        Mockito.when(guessNumberGame.getGuessHistories()).thenReturn(Arrays.asList(new GuessHistory(new Answer("1 4 5 8"), new CompareResult(1, 3))));

        Mockito.doReturn(guessNumberGame).when(guessNumberGameService).getGuessNumberGame();
    }

    @Test
    void should_return_compare_result_when_guess_number() {
        guessNumberGameService.guess(new Answer("1 2 3 4"));
        
        Mockito.verify(guessNumberGame, Mockito.times(1)).guess(Mockito.any());
        
    }

    @Test
    void should_return_histories_when_get_histories() {
        guessNumberGameService.getGuessHistories();

        Mockito.verify(guessNumberGame, Mockito.times(1)).getGuessHistories();

    }
}