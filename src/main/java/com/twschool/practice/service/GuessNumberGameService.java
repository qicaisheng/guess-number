package com.twschool.practice.service;

import com.twschool.practice.GameRecord;
import com.twschool.practice.GameRecordMapper;
import com.twschool.practice.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GuessNumberGameService {

    @Autowired
    private GameRecordMapper gameRecordMapper;
    private static final String ROUND = "round1";
    private GuessNumberGame guessNumberGame;
    private String round;

    public GuessNumberGameService(GameRecordMapper gameRecordMapper) {
        this.gameRecordMapper = gameRecordMapper;
    }
    
    
    public CompareResult guess(Answer answer) {
        if (this.getGuessNumberGame() == null) {
            startGame();
        }
        
        CompareResult guess = getGuessNumberGame().guess(answer);
        GuessHistory guessHistory = new GuessHistory(answer, guess);
        gameRecordMapper.save(new GameRecord(guessHistory, ROUND));
        
        if (this.getGuessNumberGame().isEndGame()) {
            exitGame();
        }
        return guess;
    }

    public List<GuessHistory> getGuessHistories() {
        return getGuessNumberGame().getGuessHistories();
    }

    public GuessNumberGame getGuessNumberGame() {
        return this.guessNumberGame;
    }

    public void startGame() {
        this.guessNumberGame = new GuessNumberGame(new RandomAnswerGenerator());
        this.round = UUID.randomUUID().toString();
    }

    public void exitGame() {
        this.guessNumberGame = null;
        this.round = null;
    }

    public String getRound() {
        return round;
    }
}
