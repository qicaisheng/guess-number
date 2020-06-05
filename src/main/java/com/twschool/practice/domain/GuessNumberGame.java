package com.twschool.practice.domain;

import java.util.ArrayList;
import java.util.List;

public class GuessNumberGame {
    private static final int MAX_TRY_TIMES = 6;
    private int tryTimes = MAX_TRY_TIMES;
    private List<GuessHistory> guessHistories = new ArrayList<>();
    private Answer answer;

    public GuessNumberGame(AnswerGenerator answerGenerator) {
        this.answer = answerGenerator.generateAnswer();
    }

    public CompareResult guess(Answer answerFromUser) {
        validateFormat(answerFromUser);
        CompareResult compareResult = this.answer.compareWith(answerFromUser);
        addHistory(answerFromUser, compareResult);
        decreaseTryTimes();
        return compareResult;
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

    private void validateFormat(Answer answerFromUser) {
        if (!answerFromUser.isValidFormat()) {
            throw new InputFormatException();
        }
    }

    private boolean addHistory(Answer answerFromUser, CompareResult compareResult) {
        GuessHistory guessHistory = new GuessHistory(answerFromUser, compareResult);
        return guessHistories.add(guessHistory);
    }

    public boolean isSucceed() {
        return getStatus() == GameStatus.SUCCEED;
    }

    public boolean isFailed() {
        return getStatus() == GameStatus.FAILED;
    }

    public boolean isEndGame() {
        return isSucceed() || isFailed();
    }
}
