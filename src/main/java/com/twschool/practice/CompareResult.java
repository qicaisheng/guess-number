package com.twschool.practice;

public class CompareResult {
    private final int numberA;
    private final int numberB;

    public CompareResult(int numberA, int numberB) {
        this.numberA = numberA;
        this.numberB = numberB;
    }

    @Override
    public String toString() {
        return numberA + "A" + numberB + "B";
    }
}
