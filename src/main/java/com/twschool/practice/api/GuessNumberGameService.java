package com.twschool.practice.api;

import com.twschool.practice.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuessNumberGameService {
    
    public CompareResult guess(Answer answer) {
        return getGuessNumberGame().guess(answer);
    }

    public List<GuessHistory> getGuessHistories() {
        return getGuessNumberGame().getGuessHistories();
    }

    public GuessNumberGame getGuessNumberGame() {
        return new GuessNumberGame(new RandomAnswerGenerator());
    }
}
