package com.twschool.practice;

public class GuessNumberGame {
    private Answer answer;
    private GameStatus status = GameStatus.PENDING;

    public GuessNumberGame(String answer) {
        this.answer = new Answer(answer);
    }

    public String guess(String number) {
        Answer answerFromUser = new Answer(number);
        if (!answerFromUser.isValidFormat()) {
            return "Wrong Input，Input again";
        }
        CompareResult compareResult = this.answer.compareWith(answerFromUser);
        if ("4A0B".equals(compareResult.toString())) {
            this.status = GameStatus.SUCCEED;
        }
        return compareResult.toString();
    }

    public GameStatus getStatus() {
        return this.status;
    }
}
