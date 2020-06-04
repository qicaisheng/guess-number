package com.twschool.practice;

public class CompareResult {
    private int valueAndPositionCorrectNumber;

    private int valueCorrectButPositionIncorrectNumber;
    public CompareResult() {
    }

    public CompareResult(int valueAndPositionCorrectNumber, int valueCorrectButPositionIncorrectNumber) {
        this.valueAndPositionCorrectNumber = valueAndPositionCorrectNumber;
        this.valueCorrectButPositionIncorrectNumber = valueCorrectButPositionIncorrectNumber;
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

    public int getValueAndPositionCorrectNumber() {
        return valueAndPositionCorrectNumber;
    }

    public int getValueCorrectButPositionIncorrectNumber() {
        return valueCorrectButPositionIncorrectNumber;
    }

    boolean isSucceed() {
        return valueAndPositionCorrectNumber == 4;
    }
}
