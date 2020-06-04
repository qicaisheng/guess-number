package com.twschool.practice.api;

import com.twschool.practice.domain.CompareResult;

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
    
    public static CompareResultDto buildFrom(CompareResult compareResult) {
        CompareResultDto compareResultDto = new CompareResultDto();
        compareResultDto.setValueAndPositionCorrectNumber(compareResult.getValueAndPositionCorrectNumber());
        compareResultDto.setValueCorrectButPositionIncorrectNumber(compareResult.getValueCorrectButPositionIncorrectNumber());
        
        return compareResultDto;
    }
}
