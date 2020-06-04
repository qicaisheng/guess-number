package com.twschool.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AnswerGenerator {
    public static Answer generateAnswer() {
        List<String> validNumbers = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        Collections.shuffle(validNumbers);
        List<String> answerNumbers = validNumbers.stream().limit(4).collect(Collectors.toList());
        return new Answer(answerNumbers);
    }
}
