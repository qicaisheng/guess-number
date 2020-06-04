package com.twschool.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Answer {

    public static final int ANSWER_NUMBER = 4;
    private List<String> answerNumbers;

    public Answer(String answer) {
        this.answerNumbers = Arrays.asList(answer.split(" "));
    }

    public Answer(List<String> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public List<String> getAnswerNumbers() {
        return answerNumbers;
    }
    
    CompareResult compareWith(Answer answer) {
        List<String> answerFromUser = answer.getAnswerNumbers();
        CompareResult compareResult = new CompareResult();
        for (int index = 0; index < ANSWER_NUMBER; index ++) {
            boolean valueAndPositionCorrect = getAnswerNumbers().get(index).equals(answerFromUser.get(index));
            if (valueAndPositionCorrect) {
                compareResult.increaseValueAndPositionCorrectNumber();
            } else if (contains(answerFromUser.get(index))) {
                compareResult.increaseValueCorrectButPositionIncorrectNumber();
            }
        }

        return compareResult;
    }

    private boolean contains(String value) {
        return getAnswerNumbers().contains(value);
    }

    boolean isValidFormat() {
        Set<String> answerSetFromUser = new HashSet<>(getAnswerNumbers());
        return answerSetFromUser.size() == ANSWER_NUMBER;
    }

}
