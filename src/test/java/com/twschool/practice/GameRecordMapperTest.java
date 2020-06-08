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
        GameRecordDTO gameRecordDto = new GameRecordDTO();
        gameRecordDto.setId("1");
        gameRecordDto.setRound("round1");
        gameRecordDto.setUserGuess("1 2 3 4");
        gameRecordDto.setPositionCorrectNumber(1);
        gameRecordDto.setValueCorrectNumber(2);
        
        gameRecordMapper.save(gameRecordDto);

        List<GameRecordDTO> gameRecordDTOList = gameRecordMapper.findGameRecordsByRound("round1");
        
        assertEquals(1, gameRecordDTOList.size());
        assertNotNull(gameRecordDTOList.get(0));
        assertEquals("1", gameRecordDTOList.get(0).getId());
        assertEquals("round1", gameRecordDTOList.get(0).getRound());
        assertEquals("1 2 3 4", gameRecordDTOList.get(0).getUserGuess());
        assertEquals(1, gameRecordDTOList.get(0).getPositionCorrectNumber());
        assertEquals(2, gameRecordDTOList.get(0).getValueCorrectNumber());
    }

    @Test
    void should_save_game_record2() {
        GameRecordDTO gameRecordDto = new GameRecordDTO();
        gameRecordDto.setId("2");
        gameRecordDto.setRound("round1");
        gameRecordDto.setUserGuess("1 2 3 4");
        gameRecordDto.setPositionCorrectNumber(1);
        gameRecordDto.setValueCorrectNumber(2);

        gameRecordMapper.save(gameRecordDto);

        List<GameRecordDTO> gameRecordDTOList = gameRecordMapper.findGameRecordsByRound("round1");

        assertEquals(1, gameRecordDTOList.size());
        assertNotNull(gameRecordDTOList.get(0));
        assertEquals("2", gameRecordDTOList.get(0).getId());
        assertEquals("round1", gameRecordDTOList.get(0).getRound());
        assertEquals("1 2 3 4", gameRecordDTOList.get(0).getUserGuess());
        assertEquals(1, gameRecordDTOList.get(0).getPositionCorrectNumber());
        assertEquals(2, gameRecordDTOList.get(0).getValueCorrectNumber());
    }

}