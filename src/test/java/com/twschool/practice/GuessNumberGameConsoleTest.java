package com.twschool.practice;

import com.twschool.practice.console.GuessNumberGameConsole;
import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.GuessNumberGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessNumberGameConsoleTest {
    
    private GuessNumberGameConsole guessNumberGameConsole;
    
    @BeforeEach
    public void setUp() throws Exception {
        GuessNumberGame guessNumberGame = new GuessNumberGame(() -> new Answer("1 2 3 4"));
        guessNumberGameConsole = new GuessNumberGameConsole(guessNumberGame);
    }

    @Test
    public void should_output_Wrong_input_when_input_1134_given_game_with_answer_1234() {
        String result = guessNumberGameConsole.guess("1 1 3 4");

        assertEquals("Wrong Input，Input again", result);
    }

    @Test
    public void should_output_Wrong_input_when_input_12_given_game_with_answer_1234() {
        String result = guessNumberGameConsole.guess("1 2");

        assertEquals("Wrong Input，Input again", result);
    }

    @Test
    public void should_output_4A0B_when_input_1234_given_game_with_answer_1234() {
        String result = guessNumberGameConsole.guess("1 2 3 4");

        assertEquals("4A0B", result);
    }

    @Test
    public void should_output_history_when_input_2478_given_game_with_answer_1234() {
        guessNumberGameConsole.guess("1 5 6 7");
        guessNumberGameConsole.guess("2 4 7 8");
        
        String histories = guessNumberGameConsole.getHistories();
        
        assertEquals("\n1 5 6 7        1A0B\n2 4 7 8        0A2B", histories);
    }


}