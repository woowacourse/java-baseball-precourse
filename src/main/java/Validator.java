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

    public void isValidNumbers(String number) {
        isInteger(number);
        isDigit(number);
        isNotOverlap(number);
    }

    public void isValidMenuId(String menuId) {
        isInteger(menuId);
        isOneOrTwo(menuId);
    }

    private void isInteger(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아니거나 빈 문자열입니다.");
        }
    }

    private void isDigit(String number) {
        if (number.length() != NumberBaseBallGame.DIGIT) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
    }

    private void isNotOverlap(String numbers) {
        Set<Character> overlapCheckSet = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            if (!overlapCheckSet.add(numbers.charAt(i))) {
                throw new IllegalArgumentException("서로 다른 숫자가 아닙니다.");
            }
        }
    }

    private void isOneOrTwo(String menuId) {
        if (!menuId.equals(FIRST_MENU) && !menuId.equals(SECOND_MENU)) {
            throw new IllegalArgumentException("1 또는 2가 아닙니다.");
        }
    }
}
