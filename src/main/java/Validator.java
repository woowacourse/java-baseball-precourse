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
    private static final  String FIRST_MENU = "1";
    private static final  String SECOND_MENU = "2";

    public static boolean isValidNumbers(String number) {
        return number.length() == NumberBaseBallGame.DIGIT && isInteger(number) && isNotOverlap(number);
    }

    public static boolean isValidMenu(String menu) {
        return isInteger(menu) && menu.equals(FIRST_MENU) && menu.equals(SECOND_MENU);
    }

    private static boolean isInteger(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isNotOverlap(String numbers) {
        Set<Character> overlapCheckSet = new HashSet<>();
        for (int i=0; i<numbers.length(); i++) {
            if (overlapCheckSet.add(numbers.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
}
