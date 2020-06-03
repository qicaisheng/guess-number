package com.twschool.practice;

import java.util.Arrays;

public class GuessNumberGame {
    private String[] answer;

    public GuessNumberGame(String answer) {
        this.answer = answer.split("");
    }

    public String guess(String number) {
        String[] answerFromUser = number.split(" ");
        int numberA = 0;
        int numberB = 0;
        for (int index = 0; index < this.answer.length; index ++) {
            if (answer[index].equals(answerFromUser[index])) {
                numberA ++;
            } else if (Arrays.asList(answer).contains(answerFromUser[index])) {
                numberB ++;
            }
        }
        
        return numberA + "A" + numberB + "B";
    }
}
