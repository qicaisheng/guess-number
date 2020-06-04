package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;


public class GuessHistoryTest {

    @Test
    public void should_get_history_string() {
        GuessHistory guessHistory = new GuessHistory(new Answer("2 4 7 8"), new CompareResult(0, 2));

        Assert.assertEquals("2 4 7 8        0A2B", guessHistory.toString());
    }
}