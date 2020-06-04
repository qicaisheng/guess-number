package com.twschool.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Answer {

    public static final int ANSWER_NUMBER = 4;
    private String[] answer;

    public Answer(String answer) {
        this.answer = answer.split(" ");
    }

    public String[] getAnswer() {
        return answer;
    }

    CompareResult compareWith(Answer answer) {
        String[] answerFromUser = answer.getAnswer();
        int valueAndPositionCorrectNumber = 0;
        int valueCorrectButPositionIncorrectNumber = 0;
        for (int index = 0; index < ANSWER_NUMBER; index ++) {
            boolean valueAndPositionCorrect = getAnswer()[index].equals(answerFromUser[index]);
            if (valueAndPositionCorrect) {
                valueAndPositionCorrectNumber ++;
            } else if (contains(answerFromUser[index])) {
                valueCorrectButPositionIncorrectNumber ++;
            }
        }

        return new CompareResult(valueAndPositionCorrectNumber, valueCorrectButPositionIncorrectNumber);
    }

    private boolean contains(String value) {
        return Arrays.asList(getAnswer()).contains(value);
    }

    boolean isValidFormat() {
        Set<String> answerSetFromUser = new HashSet<>(Arrays.asList(getAnswer()));
        return answerSetFromUser.size() == ANSWER_NUMBER;
    }
}
