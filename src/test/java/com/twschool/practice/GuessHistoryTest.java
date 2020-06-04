package com.twschool.practice;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.CompareResult;
import com.twschool.practice.domain.GuessHistory;
import org.junit.Assert;
import org.junit.Test;


public class GuessHistoryTest {

    @Test
    public void should_get_history_string() {
        GuessHistory guessHistory = new GuessHistory(new Answer("2 4 7 8"), new CompareResult(0, 2));

        Assert.assertEquals("2 4 7 8        0A2B", guessHistory.toString());
    }
}