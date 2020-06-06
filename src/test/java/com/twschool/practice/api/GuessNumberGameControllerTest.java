package com.twschool.practice.api;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.CompareResult;
import com.twschool.practice.domain.GuessHistory;
import com.twschool.practice.service.GuessNumberGameService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GuessNumberGameControllerTest {

    @MockBean
    private GuessNumberGameService guessNumberGameService;
    
    @Autowired
    private MockMvc mockMvc;
    
    @BeforeEach
    void setUp() {
        CompareResult compareResult = new CompareResult(1, 2);
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));
        Mockito.when(guessNumberGameService.guess(Mockito.any())).thenReturn(compareResult);
        Mockito.when(guessNumberGameService.getGuessHistories()).thenReturn(Arrays.asList(new GuessHistory(answer, compareResult)));
    }

    @Test
    void should_return_result_when_guess_number() throws Exception {
        
        this.mockMvc.perform(post("/guess-number/compare-results")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"number\":\"1 2 3 4\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valueAndPositionCorrectNumber").value(1))
                .andExpect(jsonPath("$.valueCorrectButPositionIncorrectNumber").value(2));
    }

    @Test
    void should_return_histories_when_get_histories() throws Exception {
        
        this.mockMvc.perform(get("/guess-number/histories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].answerDto", Matchers.notNullValue()))
                .andExpect(jsonPath("$[0].answerDto.number").value("1234"))
                .andExpect(jsonPath("$[0].compareResultDto.valueAndPositionCorrectNumber").value(1))
                .andExpect(jsonPath("$[0].compareResultDto.valueCorrectButPositionIncorrectNumber").value(2));
    }


}
