package com.twschool.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Sql(scripts = "classpath:mysql/teardown.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class GameRecordMapperTest {
    
    @Autowired
    private GameRecordMapper gameRecordMapper;

    @Test
    void should_save_game_record1() {
        GameRecord gameRecord = new GameRecord();
        gameRecord.setId("1");
        gameRecord.setRound("round1");
        gameRecord.setUserGuess("1 2 3 4");
        gameRecord.setPositionCorrectNumber(1);
        gameRecord.setValueCorrectNumber(2);
        
        gameRecordMapper.save(gameRecord);

        List<GameRecord> gameRecordList = gameRecordMapper.findGameRecordsByRound("round1");
        
        assertEquals(1, gameRecordList.size());
        assertNotNull(gameRecordList.get(0));
        assertEquals("1", gameRecordList.get(0).getId());
        assertEquals("round1", gameRecordList.get(0).getRound());
        assertEquals("1 2 3 4", gameRecordList.get(0).getUserGuess());
        assertEquals(1, gameRecordList.get(0).getPositionCorrectNumber());
        assertEquals(2, gameRecordList.get(0).getValueCorrectNumber());
    }

    @Test
    void should_save_game_record2() {
        GameRecord gameRecord = new GameRecord();
        gameRecord.setId("2");
        gameRecord.setRound("round1");
        gameRecord.setUserGuess("1 2 3 4");
        gameRecord.setPositionCorrectNumber(1);
        gameRecord.setValueCorrectNumber(2);

        gameRecordMapper.save(gameRecord);

        List<GameRecord> gameRecordList = gameRecordMapper.findGameRecordsByRound("round1");

        assertEquals(1, gameRecordList.size());
        assertNotNull(gameRecordList.get(0));
        assertEquals("2", gameRecordList.get(0).getId());
        assertEquals("round1", gameRecordList.get(0).getRound());
        assertEquals("1 2 3 4", gameRecordList.get(0).getUserGuess());
        assertEquals(1, gameRecordList.get(0).getPositionCorrectNumber());
        assertEquals(2, gameRecordList.get(0).getValueCorrectNumber());
    }

}