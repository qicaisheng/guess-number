package com.twschool.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GuessNumberGame {
    private String[] answer;

    public GuessNumberGame(String answer) {
        this.answer = answer.split("");
    }

    public String guess(String number) {
        String[] answerFromUser = number.split(" ");
        if (!validateFormatSucceed(answerFromUser)) {
            return "Wrong Input，Input again";
        }
        CompareResult compareResult = compareAnswerWith(answerFromUser);
        return compareResult.toString();
    }

    private CompareResult compareAnswerWith(String[] answerFromUser) {
        int numberA = 0;
        int numberB = 0;
        for (int index = 0; index < this.answer.length; index ++) {
            if (answer[index].equals(answerFromUser[index])) {
                numberA ++;
            } else if (Arrays.asList(answer).contains(answerFromUser[index])) {
                numberB ++;
            }
        }

        return new CompareResult(numberA, numberB);
    }

    private boolean validateFormatSucceed(String[] answerFromUser) {
        Set<String> answerSetFromUser = new HashSet<>(Arrays.asList(answerFromUser));
        return answerSetFromUser.size() == answer.length;
    }
}
