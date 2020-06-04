package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;


public class GameHistoryTest {

    @Test
    public void should_get_history_string() {
        GameHistory gameHistory = new GameHistory(new Answer("2 4 7 8"), new CompareResult(0, 2));

        Assert.assertEquals("2 4 7 8        0A2B", gameHistory.toString());
    }
}