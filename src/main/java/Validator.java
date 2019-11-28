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

    public static boolean isValidNumbers(int digit, String numbers) {
        return numbers.length() == digit && isInteger(numbers) && isNotOverlap(numbers);
    }

    private static boolean isInteger(String numbers) {
        try {
            Integer.valueOf(numbers);
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
