package com.twschool.practice;

public class CompareResult {
    private int valueAndPositionCorrectNumber;
    private int valueCorrectButPositionIncorrectNumber;

    public CompareResult() {
    }

    @Override
    public String toString() {
        return valueAndPositionCorrectNumber + "A" + valueCorrectButPositionIncorrectNumber + "B";
    }

    public void increaseValueAndPositionCorrectNumber() {
        this.valueAndPositionCorrectNumber ++;
    }

    public void increaseValueCorrectButPositionIncorrectNumber() {
        this.valueCorrectButPositionIncorrectNumber ++;
    }
}
