package com.twschool.practice;

import java.util.Arrays;

public class Answer {

    private String[] answer;

    public Answer(String answer) {
        this.answer = answer.split("");
    }

    public String[] getAnswer() {
        return answer;
    }

    CompareResult compareAnswerWith(String[] answerFromUser) {
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
}
