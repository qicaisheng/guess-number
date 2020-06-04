package com.twschool.practice;

public class GuessNumberGame {
    private static final int MAX_TRY_TIMES = 6;
    private Answer answer;
    private GameStatus status = GameStatus.PENDING;
    private int tryTimes = MAX_TRY_TIMES;

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
        if (compareResult.isSucceed()) {
            this.status = GameStatus.SUCCEED;
        }
        return compareResult.toString();
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
