package com.twschool.practice;

public class GuessNumberGame {
    private Answer answer;

    public GuessNumberGame(String answer) {
        this.answer = new Answer(answer);
    }

    public String guess(String number) {
        if (!new Answer(number).isValidFormat()) {
            return "Wrong Input，Input again";
        }
        CompareResult compareResult = answer.compareWith(new Answer(number));
        return compareResult.toString();
    }

}
