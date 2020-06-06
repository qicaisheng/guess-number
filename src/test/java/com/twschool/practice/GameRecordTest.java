package com.twschool.practice;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.CompareResult;
import com.twschool.practice.domain.GuessHistory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRecordTest {

    @Test
    void should_construct_game_record_from_guess_history_and_round() {
        GuessHistory guessHistory = new GuessHistory(new Answer("1 2 3 4"), new CompareResult(1, 2));
        
        GameRecord gameRecord = new GameRecord(guessHistory, "round1");
        
        assertAll(("game record asserts"),
                () -> assertNotNull(gameRecord),
                () -> assertEquals("round1", gameRecord.getRound()),
                () -> assertEquals("1 2 3 4", gameRecord.getUserGuess()),
                () -> assertEquals(1, gameRecord.getPositionCorrectNumber()),
                () -> assertEquals(2, gameRecord.getValueCorrectNumber()),
                () -> assertNotNull(gameRecord)
        );
    }
}