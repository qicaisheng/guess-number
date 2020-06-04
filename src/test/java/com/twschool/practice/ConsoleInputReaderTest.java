package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ConsoleInputReaderTest {
    @Test
    public void should_return_input_when_get_input() {
        ConsoleInputReader reader = new ConsoleInputReader();
        String expected = "1 2 3 4";
        InputStream in = new ByteArrayInputStream(expected.getBytes());
        
        System.setIn(in);
        String input = reader.getInput();
        
        Assert.assertEquals(expected, input);
    }
}