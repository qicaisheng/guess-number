package com.twschool.practice;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.AnswerGeneratorImpl;
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
