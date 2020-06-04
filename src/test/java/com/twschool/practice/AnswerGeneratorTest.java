package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class AnswerGeneratorTest {

    @Test
    public void should_generate_answer_with_valid_format() {
        Answer answer = AnswerGenerator.generateAnswer();

        Assert.assertTrue(answer.isValidFormat());
    }
}
