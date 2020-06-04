package com.twschool.practice.api;

import com.twschool.practice.domain.GuessHistory;

public class GuessHistoryDto {

    private AnswerDto answerDto;

    private CompareResultDto compareResultDto;

    public AnswerDto getAnswerDto() {
        return answerDto;
    }

    public void setAnswerDto(AnswerDto answerDto) {
        this.answerDto = answerDto;
    }

    public CompareResultDto getCompareResultDto() {
        return compareResultDto;
    }

    public void setCompareResultDto(CompareResultDto compareResultDto) {
        this.compareResultDto = compareResultDto;
    }
    
    public static GuessHistoryDto buildFrom(GuessHistory guessHistory) {
        GuessHistoryDto guessHistoryDto = new GuessHistoryDto();
        AnswerDto answerDto = new AnswerDto();
        answerDto.setNumber(String.join("", guessHistory.getInputAnswer().getAnswerNumbers()));
        guessHistoryDto.setAnswerDto(answerDto);
        CompareResultDto compareResultDto = new CompareResultDto();
        compareResultDto.setValueAndPositionCorrectNumber(guessHistory.getCompareResult().getValueAndPositionCorrectNumber());
        compareResultDto.setValueCorrectButPositionIncorrectNumber(guessHistory.getCompareResult().getValueCorrectButPositionIncorrectNumber());
        guessHistoryDto.setCompareResultDto(compareResultDto);

        return guessHistoryDto;
    }
}
