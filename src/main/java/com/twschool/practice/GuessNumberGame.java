package com.twschool.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GuessNumberGame {
    private Answer answerObject;

    public GuessNumberGame(String answer) {
        this.answerObject = new Answer(answer);
    }

    public String guess(String number) {
        String[] answerFromUser = parseAnswerFromUser(number);
        if (!validateFormatSucceed(answerFromUser)) {
            return "Wrong Input，Input again";
        }
        CompareResult compareResult = compareAnswerWith(answerFromUser);
        return compareResult.toString();
    }

    private String[] parseAnswerFromUser(String number) {
        return number.split(" ");
    }

    private CompareResult compareAnswerWith(String[] answerFromUser) {
        int numberA = 0;
        int numberB = 0;
        for (int index = 0; index < this.answerObject.getAnswer().length; index ++) {
            if (this.answerObject.getAnswer()[index].equals(answerFromUser[index])) {
                numberA ++;
            } else if (Arrays.asList(this.answerObject.getAnswer()).contains(answerFromUser[index])) {
                numberB ++;
            }
        }

        return new CompareResult(numberA, numberB);
    }

    private boolean validateFormatSucceed(String[] answerFromUser) {
        Set<String> answerSetFromUser = new HashSet<>(Arrays.asList(answerFromUser));
        return answerSetFromUser.size() == this.answerObject.getAnswer().length;
    }

}
