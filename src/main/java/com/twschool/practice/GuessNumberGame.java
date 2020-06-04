package com.twschool.practice;

public class GuessNumberGame {
    private Answer answer;

    public GuessNumberGame(String answer) {
        this.answer = new Answer(answer);
    }

    public String guess(String number) {
        String[] answerFromUser = number.split(" ");
        if (!answer.validateFormatSucceed(answerFromUser)) {
            return "Wrong Input，Input again";
        }
        CompareResult compareResult = answer.compareWith(answerFromUser);
        return compareResult.toString();
    }

}
