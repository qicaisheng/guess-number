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
        int numberA = 0;
        int numberB = 0;
        for (int index = 0; index < getAnswer().length; index ++) {
            if (getAnswer()[index].equals(answerFromUser[index])) {
                numberA ++;
            } else if (Arrays.asList(getAnswer()).contains(answerFromUser[index])) {
                numberB ++;
            }
        }

        return new CompareResult(numberA, numberB);
    }

    static boolean validateFormatSucceed(Answer answer) {
        String[] answerFromUser = answer.getAnswer();
        Set<String> answerSetFromUser = new HashSet<>(Arrays.asList(answerFromUser));
        return answerSetFromUser.size() == ANSWER_NUMBER;
    }
}
