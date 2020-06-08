package com.twschool.practice;

import com.twschool.practice.domain.GuessHistory;

import java.util.UUID;

public class GameRecordDTO {
    private String id;
    private String round;
    private String userGuess;
    private int positionCorrectNumber;
    private int valueCorrectNumber;

    public GameRecordDTO(GuessHistory guessHistory, String round) {
        setId(UUID.randomUUID().toString());
        setRound(round);
        setUserGuess(String.join(" ", guessHistory.getInputAnswer().getAnswerNumbers()));
        setValueCorrectNumber(guessHistory.getCompareResult().getValueCorrectButPositionIncorrectNumber());
        setPositionCorrectNumber(guessHistory.getCompareResult().getValueAndPositionCorrectNumber());
    }

    public GameRecordDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }
    
    public String getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }

    public int getPositionCorrectNumber() {
        return positionCorrectNumber;
    }

    public void setPositionCorrectNumber(int positionCorrectNumber) {
        this.positionCorrectNumber = positionCorrectNumber;
    }

    public int getValueCorrectNumber() {
        return valueCorrectNumber;
    }

    public void setValueCorrectNumber(int valueCorrectNumber) {
        this.valueCorrectNumber = valueCorrectNumber;
    }
}
