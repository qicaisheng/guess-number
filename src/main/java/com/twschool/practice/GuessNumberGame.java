package com.twschool.practice;

public class GuessNumberGame {
    private Answer answer;

    public GuessNumberGame(String answer) {
        this.answer = new Answer(answer);
    }

    public String guess(String number) {
        Answer answerFromUser = new Answer(number);
        if (!answerFromUser.isValidFormat()) {
            return "Wrong Input，Input again";
        }
        CompareResult compareResult = this.answer.compareWith(answerFromUser);
        return compareResult.toString();
    }

}
