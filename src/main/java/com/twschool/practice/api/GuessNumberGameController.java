package com.twschool.practice.api;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.CompareResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/guess-number")
public class GuessNumberGameController {
    
    @Autowired
    private GuessNumberGameService guessNumberGameService;
    
    @PostMapping
    public CompareResult guess(@RequestBody AnswerRequest answerRequest) {
        Answer answer = new Answer(Arrays.asList(answerRequest.getNumber().split(" ")));
        return guessNumberGameService.guess(answer);
    }
}
