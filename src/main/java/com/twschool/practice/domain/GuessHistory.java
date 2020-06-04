package com.twschool.practice.domain;

public class GuessHistory {
    private Answer inputAnswer;

    private CompareResult compareResult;

    public GuessHistory(Answer inputAnswer, CompareResult compareResult) {
        this.inputAnswer = inputAnswer;
        this.compareResult = compareResult;
    }

    @Override
    public String toString() {
        String inputAnswer = String.join(" ", this.inputAnswer.getAnswerNumbers());
        String result = compareResult.toString();
        String whiteSpaces = "        ";
        return inputAnswer + whiteSpaces + result;
    }

    public CompareResult getCompareResult() {
        return compareResult;
    }

    public Answer getInputAnswer() {
        return inputAnswer;
    }
}
