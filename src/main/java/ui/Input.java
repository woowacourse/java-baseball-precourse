package ui;

import java.util.Scanner;

public class Input {
    public static String receiveNumberInput(Scanner scanner) {
        Output.printRequestNumberInput();
        return scanner.nextLine();
    }

    public static int receiveRestartGameInput(Scanner scanner) {
        Output.printRequestRestartGameInput();
        return scanner.nextInt();
    }
}