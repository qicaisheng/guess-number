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
        CompareResult compareResult = answerObject.compareAnswerWith(answerFromUser);
        return compareResult.toString();
    }

    private String[] parseAnswerFromUser(String number) {
        return number.split(" ");
    }

    private boolean validateFormatSucceed(String[] answerFromUser) {
        Set<String> answerSetFromUser = new HashSet<>(Arrays.asList(answerFromUser));
        return answerSetFromUser.size() == this.answerObject.getAnswer().length;
    }

}
