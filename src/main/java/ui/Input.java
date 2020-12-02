package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static String receiveNumberInput(Scanner scanner) {
        Output.printRequestNumberInput();
        return scanner.nextLine();
    }

    public static String receiveRestartGameInput(Scanner scanner) {
        Output.printRequestRestartGameInput();
        return scanner.nextLine();
    }
}