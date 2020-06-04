package com.twschool.practice;

import java.util.Arrays;

public class GameHistory {
    private Answer inputAnswer;
    private CompareResult compareResult;

    public GameHistory(Answer inputAnswer, CompareResult compareResult) {
        this.inputAnswer = inputAnswer;
        this.compareResult = compareResult;
    }

    @Override
    public String toString() {
        return String.join(" ", Arrays.asList(inputAnswer.getAnswer())) + "        " + compareResult.toString();
    }
}
