package com.twschool.practice;

import java.util.Arrays;

public class GuessHistory {
    private Answer inputAnswer;

    private CompareResult compareResult;

    public GuessHistory(Answer inputAnswer, CompareResult compareResult) {
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

    public CompareResult getCompareResult() {
        return compareResult;
    }
}
