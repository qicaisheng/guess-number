package com.twschool.practice.console;

public class ConsoleOutputWriter implements OutputWriter {
    
    @Override
    public void output(String message) {
        System.out.println(message);
    }
}
