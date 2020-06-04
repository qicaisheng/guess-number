package com.twschool.practice.api;

public class AnswerRequest {
    private String number;

    public AnswerRequest() {
    }

    public AnswerRequest(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
