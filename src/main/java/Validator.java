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

    public static boolean isValidNumbers(String number) {
        return number.length() == NumberBaseBallGame.DIGIT && isInteger(number) && isNotOverlap(number);
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
