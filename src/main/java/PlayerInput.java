/*
 * @(#)PlayerInput.java
 *
 * v 0.0.0
 *
 * 2019.11.28
 *
 * Copyright 2019. DunDung all rights reserved.
 */

import java.util.Scanner;

public class PlayerInput {
    private static Scanner scan = new Scanner(System.in);

    public static int inputNumber() {
        Printer.printInputNumber();
        String input = input();
        try {
            Validator.isValidNumbers(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            Printer.printError(e);
            return inputNumber();
        }
    }

    public static int inputMenuId() {
        Printer.printMenu();
        String input = input();
        try {
            Validator.isValidMenuId(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            Printer.printError(e);
            return inputMenuId();
        }
    }

    private static String input() {
        return scan.nextLine().trim();
    }
}
