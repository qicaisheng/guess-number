package com.twschool.practice.service;

import com.twschool.practice.GameRecord;
import com.twschool.practice.GameRecordMapper;
import com.twschool.practice.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuessNumberGameService {

    @Autowired
    private GameRecordMapper gameRecordMapper;
    private static final String ROUND = "round1";

    public GuessNumberGameService(GameRecordMapper gameRecordMapper) {
        this.gameRecordMapper = gameRecordMapper;
    }
    
    
    public CompareResult guess(Answer answer) {
        CompareResult guess = getGuessNumberGame().guess(answer);
        GuessHistory guessHistory = new GuessHistory(answer, guess);
        gameRecordMapper.save(new GameRecord(guessHistory, ROUND));
        return guess;
    }

    public List<GuessHistory> getGuessHistories() {
        return getGuessNumberGame().getGuessHistories();
    }

    public GuessNumberGame getGuessNumberGame() {
        return new GuessNumberGame(new RandomAnswerGenerator());
    }
}
