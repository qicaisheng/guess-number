package com.twschool.practice.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomAnswerGeneratorTest {

    @Test
    public void should_generate_answer_with_valid_format() {
        AnswerGenerator answerGenerator = new RandomAnswerGenerator();
        
        Answer answer = answerGenerator.generateAnswer();

        assertTrue(answer.isValidFormat());
    }
}
