package com.twschool.practice.service;

import com.twschool.practice.GameRecordDTO;
import com.twschool.practice.GameRecordMapper;
import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.CompareResult;
import com.twschool.practice.domain.GuessHistory;
import com.twschool.practice.domain.GuessNumberGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GuessNumberGameServiceTest {
    
    private GuessNumberGameService guessNumberGameService;
    private GuessNumberGame guessNumberGame;
    
    private GameRecordMapper mockGameRecordMapper;
    
    @BeforeEach
    void setUp() {
        mockGameRecordMapper = Mockito.mock(GameRecordMapper.class);
        guessNumberGameService = Mockito.spy(new GuessNumberGameService(mockGameRecordMapper));
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
    void should_return_save_game_record_when_guess_number() {
        GuessNumberGameService spyGuessNumberGameService = Mockito.spy(new GuessNumberGameService(mockGameRecordMapper));
        Mockito.doReturn(guessNumberGame).when(spyGuessNumberGameService).getGuessNumberGame();
        Mockito.doReturn("round").when(spyGuessNumberGameService).getRound();

        spyGuessNumberGameService.guess(new Answer("1 2 3 4"));

        ArgumentCaptor<GameRecordDTO> argumentCaptor = ArgumentCaptor.forClass(GameRecordDTO.class);

        Mockito.verify(mockGameRecordMapper, Mockito.times(1)).save(argumentCaptor.capture());

        GameRecordDTO gameRecordDto = argumentCaptor.getValue();
        assertAll(("game record asserts"),
                () -> assertNotNull(gameRecordDto),
                () -> assertEquals("round", gameRecordDto.getRound()),
                () -> assertEquals("1 2 3 4", gameRecordDto.getUserGuess()),
                () -> assertEquals(1, gameRecordDto.getPositionCorrectNumber()),
                () -> assertEquals(2, gameRecordDto.getValueCorrectNumber()),
                () -> assertNotNull(gameRecordDto)
        );

    }

    @Test
    void should_return_histories_when_get_histories() {
        guessNumberGameService.getGuessHistories();

        Mockito.verify(guessNumberGame, Mockito.times(1)).getGuessHistories();

    }

    @Test
    void should_start_game_when_first_guess() {
        GuessNumberGameService spyGuessNumberGameService = Mockito.spy(guessNumberGameService);
        
        spyGuessNumberGameService.guess(new Answer("1 2 3 4"));

        Mockito.verify(spyGuessNumberGameService, Mockito.times(1)).startGame();

    }

    @Test
    void should_start_game_one_time_when_guess_twice_with_incorrect_answer() {
        GuessNumberGameService spyGuessNumberGameService = Mockito.spy(guessNumberGameService);

        spyGuessNumberGameService.guess(new Answer("1 2 3 4"));
        spyGuessNumberGameService.guess(new Answer("1 2 3 4"));

        Mockito.verify(spyGuessNumberGameService, Mockito.times(1)).startGame();

    }

    @Test
    void should_exit_game_when_game_end() {
        GuessNumberGameService spyGuessNumberGameService = Mockito.spy(guessNumberGameService);
        
        GuessNumberGame mockGuessNumberGame = Mockito.mock(GuessNumberGame.class);
        Mockito.when(mockGuessNumberGame.isEndGame()).thenReturn(true);
        Mockito.when(mockGuessNumberGame.guess(Mockito.any())).thenReturn(new CompareResult(1, 2));

        Mockito.doReturn(mockGuessNumberGame).when(spyGuessNumberGameService).getGuessNumberGame();
        
        spyGuessNumberGameService.guess(new Answer("1 2 3 4"));

        Mockito.verify(spyGuessNumberGameService, Mockito.times(1)).exitGame();

    }

    @Test
    void should_not_exit_game_when_game_not_end() {
        GuessNumberGameService spyGuessNumberGameService = Mockito.spy(guessNumberGameService);

        spyGuessNumberGameService.guess(new Answer("1 2 3 4"));
        spyGuessNumberGameService.guess(new Answer("1 2 3 4"));

        Mockito.verify(spyGuessNumberGameService, Mockito.times(0)).exitGame();

    }

    @Test
    void should_get_guess_number_game_null_when_exit_game() {
        GuessNumberGameService spyGuessNumberGameService = Mockito.spy(new GuessNumberGameService(mockGameRecordMapper));
        spyGuessNumberGameService.guess(new Answer("1 2 3 4"));

        assertNotNull(spyGuessNumberGameService.getGuessNumberGame());
        
        spyGuessNumberGameService.exitGame();
        assertNull(spyGuessNumberGameService.getGuessNumberGame());
    }

    @Test
    void should_set_game_round_when_start_game() {
        GuessNumberGameService spyGuessNumberGameService = Mockito.spy(new GuessNumberGameService(mockGameRecordMapper));
        
        spyGuessNumberGameService.startGame();

        assertNotNull(spyGuessNumberGameService.getRound());
    }

    @Test
    void should_get_game_null_round_when_exit_game() {
        GuessNumberGameService spyGuessNumberGameService = Mockito.spy(new GuessNumberGameService(mockGameRecordMapper));
        spyGuessNumberGameService.guess(new Answer("1 2 3 4"));

        assertNotNull(spyGuessNumberGameService.getRound());

        spyGuessNumberGameService.exitGame();
        assertNull(spyGuessNumberGameService.getRound());
    }

    @Test
    void should_set_different_round_when_start_game_twice_and_between_exit_game() {
        GuessNumberGameService spyGuessNumberGameService = Mockito.spy(new GuessNumberGameService(mockGameRecordMapper));
        spyGuessNumberGameService.startGame();
        String round1 = spyGuessNumberGameService.getRound();

        spyGuessNumberGameService.startGame();
        String round2 = spyGuessNumberGameService.getRound();
        
        assertNotEquals(round1, round2);
    }

}