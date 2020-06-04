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
        String inputAnswer = String.join(" ", Arrays.asList(this.inputAnswer.getAnswer()));
        String result = compareResult.toString();
        String whiteSpaces = "        ";
        return inputAnswer + whiteSpaces + result;
    }
}
