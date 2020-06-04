package com.twschool.practice.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GuessHistoryTest {

    @Test
    public void should_get_history_string() {
        GuessHistory guessHistory = new GuessHistory(new Answer("2 4 7 8"), new CompareResult(0, 2));

        assertEquals("2 4 7 8        0A2B", guessHistory.toString());
    }
}