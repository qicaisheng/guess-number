package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuessNumberGame {
    private static final int MAX_TRY_TIMES = 6;
    private Answer answer;
    private GameStatus status = GameStatus.PENDING;
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
        decreaseTryTimes();
        CompareResult compareResult = this.answer.compareWith(answerFromUser);
        setGameStatus(compareResult);
        gameHistories.add(new GameHistory(answerFromUser, compareResult));
        String histories = gameHistories.stream().map(gameHistory -> "\n" + gameHistory.toString()).collect(Collectors.joining());
        return compareResult.toString() + histories;
    }

    private void setGameStatus(CompareResult compareResult) {
        if (compareResult.isSucceed()) {
            this.status = GameStatus.SUCCEED;
        } else if (getTryTimes() == 0) {
            this.status = GameStatus.FAILED;
        }
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void decreaseTryTimes() {
        this.tryTimes --;
    }

    public int getTryTimes() {
        return tryTimes;
    }
}
