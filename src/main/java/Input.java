/*
 * @(#)Input.java
 *
 * v 0.0.0
 *
 * 2019.11.28
 *
 * Copyright 2019. DunDung all rights reserved.
 */

import java.util.Scanner;

public class Input {
    private Scanner aScanner = new Scanner(System.in);
    private Printer aPrinter = new Printer();
    private Validator aValidator = new Validator();

    public int inputNumber() {
        aPrinter.printInputNumber();
        String input = inputText();
        try {
            aValidator.isValidNumbers(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            aPrinter.printException(e);
            return inputNumber();
        }
    }

    public int inputMenuId() {
        aPrinter.printMenu();
        String input = inputText();
        try {
            aValidator.isValidMenuId(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            aPrinter.printException(e);
            return inputMenuId();
        }
    }

    private String inputText() {
        return aScanner.nextLine().trim();
    }
}
