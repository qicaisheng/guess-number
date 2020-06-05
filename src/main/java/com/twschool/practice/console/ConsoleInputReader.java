package com.twschool.practice.console;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {
    
    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}