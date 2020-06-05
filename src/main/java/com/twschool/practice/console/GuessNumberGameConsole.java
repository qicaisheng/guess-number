package com.twschool.practice.console;

import com.twschool.practice.domain.*;

import java.util.stream.Collectors;

public class GuessNumberGameConsole {
    private static final String WELCOME_MESSAGE = "Welcome to Guess Number!\nGame Start!\n";
    private static final String WRONG_INPUT = "Wrong Input，Input again";
    private static final String WINNING_MESSAGE = "Congratulation! You win!";
    private static final String INPUT_TIPS = "Please guess:";
    private static final String NEW_LINE = "\n";
    private static final String LOSE_MESSAGE = "You failed!";
    private static final String GUESS_RESULT_FORMAT = "Result: %s";
    private static final String GUESS_HISTORIES_FORMAT = "Histories: %s";
    private GuessNumberGame guessNumberGame;
    private InputReader inputReader;
    private OutputWriter outputWriter;

    public GuessNumberGameConsole() {
        new GuessNumberGameConsole(new GuessNumberGame(new RandomAnswerGenerator()));
    }

    public GuessNumberGameConsole(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
        this.inputReader = new ConsoleInputReader();
        this.outputWriter = new ConsoleOutputWriter();
    }

    public void start() {
        welcome();
        guessUntilEndGame();
        notifyEndGame();
    }

    private void welcome() {
        outputWriter.output(WELCOME_MESSAGE);
    }

    private void guessUntilEndGame() {
        while (!this.guessNumberGame.isEndGame()) {
            outputWriter.output(INPUT_TIPS);
            String guessResult = guess(inputReader.getInput());
            outputWriter.output(String.format(GUESS_RESULT_FORMAT, guessResult));
            outputWriter.output(String.format(GUESS_HISTORIES_FORMAT, getHistories()));
        }
    }

    private void notifyEndGame() {
        if (this.guessNumberGame.isSucceed()) {
            outputWriter.output(WINNING_MESSAGE);
        } else if (this.guessNumberGame.isFailed()) {
            outputWriter.output(LOSE_MESSAGE);
        }
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
