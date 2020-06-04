package com.twschool.practice.api;

public class AnswerDto {
    private String number;

    public AnswerDto() {
    }

    public AnswerDto(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
