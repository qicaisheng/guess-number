package com.twschool.practice;

import java.util.stream.Collectors;

public class GuessNumberCommandGame {
    private GuessNumberGame guessNumberGame;

    public GuessNumberCommandGame(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }

    public String guess(String number) {
        Answer answerFromUser = new Answer(number);
        try {
            CompareResult compareResult = guessNumberGame.guess(answerFromUser);
            return compareResult.toString();
        } catch (InputFormatException e) {
            return "Wrong Input，Input again";
        }
    }

    public String getHistories() {
        return this.guessNumberGame.getGuessHistories().stream()
                .map(guessHistory -> "\n" + guessHistory.toString())
                .collect(Collectors.joining());
    }
}
