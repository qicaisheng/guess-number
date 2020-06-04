package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class GuessNumberGame {
    private static final int MAX_TRY_TIMES = 6;
    private Answer answer;
    private int tryTimes = MAX_TRY_TIMES;

    private List<GuessHistory> guessHistories = new ArrayList<>();

    public GuessNumberGame(String answer) {
        this.answer = new Answer(answer);
    }
    
    public CompareResult guess(Answer answerFromUser) {
        validateFormat(answerFromUser);
        decreaseTryTimes();
        CompareResult compareResult = this.answer.compareWith(answerFromUser);
        guessHistories.add(new GuessHistory(answerFromUser, compareResult));
        return compareResult;
    }

    private void validateFormat(Answer answerFromUser) {
        if (!answerFromUser.isValidFormat()) {
            throw new InputFormatException();
        }
    }

    public List<GuessHistory> getGuessHistories() {
        return guessHistories;
    }

    public GameStatus getStatus() {
        List<GuessHistory> gameHistories = getGuessHistories();
        if (gameHistories.isEmpty()) {
            return GameStatus.PENDING;
        }
        if (gameHistories.get(gameHistories.size() - 1).getCompareResult().isSucceed()) {
            return GameStatus.SUCCEED;
        } else if (gameHistories.size() == MAX_TRY_TIMES) {
            return GameStatus.FAILED;
        }
        return GameStatus.PENDING;
    }

    public void decreaseTryTimes() {
        this.tryTimes --;
    }

    public int getTryTimes() {
        return tryTimes;
    }
}
