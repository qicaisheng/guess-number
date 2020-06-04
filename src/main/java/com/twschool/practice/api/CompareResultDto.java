package com.twschool.practice.api;

public class CompareResultDto {

    private int valueAndPositionCorrectNumber;

    private int valueCorrectButPositionIncorrectNumber;

    public int getValueAndPositionCorrectNumber() {
        return valueAndPositionCorrectNumber;
    }

    public void setValueAndPositionCorrectNumber(int valueAndPositionCorrectNumber) {
        this.valueAndPositionCorrectNumber = valueAndPositionCorrectNumber;
    }

    public int getValueCorrectButPositionIncorrectNumber() {
        return valueCorrectButPositionIncorrectNumber;
    }

    public void setValueCorrectButPositionIncorrectNumber(int valueCorrectButPositionIncorrectNumber) {
        this.valueCorrectButPositionIncorrectNumber = valueCorrectButPositionIncorrectNumber;
    }
}
