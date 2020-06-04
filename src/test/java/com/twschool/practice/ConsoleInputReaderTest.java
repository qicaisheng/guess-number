package com.twschool.practice;

import com.twschool.practice.console.ConsoleInputReader;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleInputReaderTest {
    @Test
    public void should_return_input_when_get_input() {
        ConsoleInputReader reader = new ConsoleInputReader();
        String expected = "1 2 3 4";
        InputStream in = new ByteArrayInputStream(expected.getBytes());
        
        System.setIn(in);
        String input = reader.getInput();
        
        assertEquals(expected, input);
    }
}