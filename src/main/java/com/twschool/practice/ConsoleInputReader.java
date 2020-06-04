package com.twschool.practice;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}