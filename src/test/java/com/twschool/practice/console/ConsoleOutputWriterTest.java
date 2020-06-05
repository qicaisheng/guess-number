package com.twschool.practice.console;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConsoleOutputWriterTest {
    @Test
    public void should_output_to_console_when_output() {
        ConsoleOutputWriter writer = new ConsoleOutputWriter();
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        writer.output("Welcome to Guess Number!\nGame Start!");

        verify(out).println(Mockito.eq("Welcome to Guess Number!\nGame Start!"));
    }
}