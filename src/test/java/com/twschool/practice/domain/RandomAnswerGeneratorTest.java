package com.twschool.practice.domain;

import org.junit.Assert;
import org.junit.Test;

public class RandomAnswerGeneratorTest {

    @Test
    public void should_generate_answer_with_valid_format() {
        AnswerGenerator answerGenerator = new RandomAnswerGenerator();
        
        Answer answer = answerGenerator.generateAnswer();

        Assert.assertTrue(answer.isValidFormat());
    }
}
