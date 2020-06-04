package com.twschool.practice;

import java.util.stream.Collectors;

public class GuessNumberGameConsole {
    private static final String WRONG_INPUT = "Wrong Input，Input again";
    private static final String NEW_LINE = "\n";
    private GuessNumberGame guessNumberGame;

    public GuessNumberGameConsole(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }

    public String guess(String number) {
        Answer answerFromUser = new Answer(number);
        try {
            CompareResult compareResult = guessNumberGame.guess(answerFromUser);
            return compareResult.toString();
        } catch (InputFormatException e) {
            return WRONG_INPUT;
        }
    }

    public String getHistories() {
        return this.guessNumberGame.getGuessHistories().stream()
                .map(guessHistory -> NEW_LINE + guessHistory.toString())
                .collect(Collectors.joining());
    }
}
