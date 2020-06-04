package com.twschool.practice;

public class Answer {

    private String[] answer;

    public Answer(String answer) {
        this.answer = answer.split("");
    }

    public String[] getAnswer() {
        return answer;
    }
}
