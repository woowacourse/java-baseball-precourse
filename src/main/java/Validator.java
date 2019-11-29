/*
 * @(#)Validator.java
 *
 * v 0.0.0
 *
 * 2019.11.28
 *
 * Copyright 2019. DunDung all rights reserved.
 */

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final String FIRST_MENU = "1";
    private static final String SECOND_MENU = "2";

    public static void isValidNumbers(String number) {
        isInteger(number);
        isDigit(number);
        isNotOverlap(number);
    }

    public static void isValidMenuId(String menuId) {
        isInteger(menuId);
        isOneOrTwo(menuId);
    }

    private static void isDigit(String number) {
        if (number.length() != NumberBaseBallGame.DIGIT) {
            throw new IllegalArgumentException("3자리를 입력해주세요.");
        }
    }

    private static void isInteger(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static void isNotOverlap(String numbers) {
        Set<Character> overlapCheckSet = new HashSet<>();
        for (int i=0; i<numbers.length(); i++) {
            if (overlapCheckSet.add(numbers.charAt(i)) == false) {
                throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
            }
        }
    }

    private static void isOneOrTwo(String menuId) {
        if (!menuId.equals(FIRST_MENU) && !menuId.equals(SECOND_MENU)) {
           throw new IllegalArgumentException("1또는 2만 입력해주세요.");
        }
    }
}
