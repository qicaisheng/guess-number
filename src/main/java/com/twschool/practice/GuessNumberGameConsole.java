package com.twschool.practice;

import java.util.stream.Collectors;

public class GuessNumberGameConsole {
    private static final String WELCOME_MESSAGE = "Welcome to Guess Number!\nGame Start!\n";
    private static final String WRONG_INPUT = "Wrong Input，Input again";
    private static final String WINNING_MESSAGE = "Congratulation! You win!";
    private static final String INPUT_TIPS = "Please guess:";
    private static final String NEW_LINE = "\n";
    private static final String LOSE_MESSAGE = "You failed!";
    public static final String GUESS_RESULT_FORMAT = "Result: %s";
    public static final String GUESS_HISTORIES_FORMAT = "Histories: %s";
    private GuessNumberGame guessNumberGame;
    private ConsoleInputReader consoleInputReader;

    public GuessNumberGameConsole() {
        this.guessNumberGame = new GuessNumberGame(new AnswerGeneratorImpl());
        this.consoleInputReader = new ConsoleInputReader();
    }

    public GuessNumberGameConsole(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
        this.consoleInputReader = new ConsoleInputReader();
    }

    public void start() {
        System.out.println(WELCOME_MESSAGE);

        while (this.guessNumberGame.getStatus() == GameStatus.PENDING) {
            System.out.println(INPUT_TIPS);
            String guessResult = guess(consoleInputReader.getInput());
            System.out.println(String.format(GUESS_RESULT_FORMAT, guessResult));
            System.out.println(String.format(GUESS_HISTORIES_FORMAT, getHistories()));
        }
        if (this.guessNumberGame.getStatus() == GameStatus.SUCCEED) {
            System.out.println(WINNING_MESSAGE);
        } else if (this.guessNumberGame.getStatus() == GameStatus.SUCCEED) {
            System.out.println(LOSE_MESSAGE);
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
