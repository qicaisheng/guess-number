package com.twschool.practice.api;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.CompareResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/guess-number")
public class GuessNumberGameController {
    
    @Autowired
    private GuessNumberGameService guessNumberGameService;
    
    @PostMapping
    public CompareResult guess(@RequestBody AnswerDto answerDto) {
        Answer answer = new Answer(Arrays.asList(answerDto.getNumber().split(" ")));
        return guessNumberGameService.guess(answer);
    }
    
    @GetMapping("/histories")
    public List<GuessHistoryDto> histories() {
        return guessNumberGameService.getGuessHistories().stream().map(GuessHistoryDto::buildFrom).collect(Collectors.toList());
    }
}
