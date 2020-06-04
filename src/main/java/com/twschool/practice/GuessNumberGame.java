package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuessNumberGame {
    private static final int MAX_TRY_TIMES = 6;
    private Answer answer;
    private int tryTimes = MAX_TRY_TIMES;

    private List<GameHistory> gameHistories = new ArrayList<>();

    public GuessNumberGame(String answer) {
        this.answer = new Answer(answer);
    }

    public String guess(String number) {
        Answer answerFromUser = new Answer(number);
        if (!answerFromUser.isValidFormat()) {
            return "Wrong Input，Input again";
        }
        CompareResult compareResult = guess(answerFromUser);
        return compareResult.toString();
    }

    private CompareResult guess(Answer answerFromUser) {
        decreaseTryTimes();
        CompareResult compareResult = this.answer.compareWith(answerFromUser);
        gameHistories.add(new GameHistory(answerFromUser, compareResult));
        return compareResult;
    }

    public List<GameHistory> getGameHistories() {
        return gameHistories;
    }

    public String getGameHistoriesString() {
        return gameHistories.stream().map(gameHistory -> "\n" + gameHistory.toString()).collect(Collectors.joining());
    }

    public GameStatus getStatus() {
        List<GameHistory> gameHistories = getGameHistories();
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
