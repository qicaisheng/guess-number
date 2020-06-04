package com.twschool.practice;

public class GameRecord {
    private String id;
    private String round;
    private String userGuess;
    private int positionCorrectNumber;
    private int valueCorrectNumber;

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
