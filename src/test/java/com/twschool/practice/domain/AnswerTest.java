package com.twschool.practice.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnswerTest {

    @Test
    public void should_be_false_when_check_format_given_Answer_1134() {
        Answer answer = new Answer("1 1 3 4");
        
        assertFalse(answer.isValidFormat());
    }

    @Test
    public void should_be_false_when_check_format_given_Answer_12() {
        Answer answer = new Answer("1 2");

        assertFalse(answer.isValidFormat());
    }

    @Test
    public void should_be_true_when_check_format_given_Answer_1234() {
        Answer answer = new Answer("1 2 3 4");

        assertTrue(answer.isValidFormat());
    }

    @Test
    public void should_return_compare_result_when_compare_with_answer_0324_given_answer_1234() {
        Answer answer = new Answer("1 2 3 4");

        CompareResult compareResult = answer.compareWith(new Answer("0 3 2 4"));
        
        assertNotNull(compareResult);
        assertEquals(1, compareResult.getValueAndPositionCorrectNumber());
        assertEquals(2, compareResult.getValueCorrectButPositionIncorrectNumber());
    }

}