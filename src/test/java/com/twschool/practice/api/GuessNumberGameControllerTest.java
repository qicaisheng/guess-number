package com.twschool.practice.api;

import com.twschool.practice.domain.CompareResult;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;

import javax.annotation.PostConstruct;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GuessNumberGameControllerTest {

    @MockBean
    private GuessNumberGameService guessNumberGameService;

    private String uri;
    
    @LocalServerPort
    private int port;
    
    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }
    @BeforeEach
    void setUp() {
        Mockito.when(guessNumberGameService.guess(Mockito.any())).thenReturn(new CompareResult(1, 2));
    }

    @Test
    void should_return_result_when_guess_number() {

        given()
                .contentType(ContentType.JSON)
                .body(new AnswerRequest("1 2 3 4"))
                .when()
                .post(uri + "/guess-number")
        .then()
                .assertThat()
                .body("valueAndPositionCorrectNumber", equalTo(1))
                .body("valueCorrectButPositionIncorrectNumber", equalTo(2));
        
    }


}
