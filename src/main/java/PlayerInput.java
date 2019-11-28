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
        String input = scan.nextLine().trim();
        if(!Validator.isValidNumbers(input)) {
            Printer.printError();
            return inputNumber();
        }
        return Integer.parseInt(input);
    }

    public static int inputMenuId() {
        Printer.printMenu();
        String input = scan.nextLine().trim();
        if(!Validator.isValidMenuId(input)) {
            Printer.printError();
            return inputMenuId();
        }
        return Integer.parseInt(input);
    }
}
