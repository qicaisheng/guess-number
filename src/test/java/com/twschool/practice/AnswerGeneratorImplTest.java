package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class AnswerGeneratorImplTest {

    @Test
    public void should_generate_answer_with_valid_format() {
        AnswerGenerator answerGenerator = new AnswerGeneratorImpl();
        
        Answer answer = answerGenerator.generateAnswer();

        Assert.assertTrue(answer.isValidFormat());
    }
}
