/*
 * @(#)Player.java
 *
 * v 0.0.0
 *
 * 2019.12.02
 *
 * Copyright 2019. DunDung all rights reserved.
 */

import java.util.Scanner;

public class Player {
    private Scanner aScanner = new Scanner(System.in);
    private Validator aValidator = new Validator();

    public int inputNumber() {
        System.out.print("숫자를 입력해주세요.: ");
        String input = inputText();

        try {
            aValidator.isValidNumbers(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return inputNumber();
        }
    }

    public int inputMenuId() {
        println("게임을 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = inputText();

        try {
            aValidator.isValidMenuId(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return inputMenuId();
        }
    }

    private String inputText() {
        return aScanner.nextLine().trim();
    }

    private void println(String text) {
        System.out.println(text);
    }
}
