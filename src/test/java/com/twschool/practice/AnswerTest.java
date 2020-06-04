package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class AnswerTest {

    @Test
    public void should_be_false_when_check_format_given_Answer_1134() {
        Answer answer = new Answer("1 1 3 4");
        
        Assert.assertFalse(answer.isValidFormat());
    }

    @Test
    public void should_be_false_when_check_format_given_Answer_12() {
        Answer answer = new Answer("1 2");

        Assert.assertFalse(answer.isValidFormat());
    }

    @Test
    public void should_be_true_when_check_format_given_Answer_1234() {
        Answer answer = new Answer("1 2 3 4");

        Assert.assertTrue(answer.isValidFormat());
    }
}