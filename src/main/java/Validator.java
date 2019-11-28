/*
 * @(#)Validator.java
 *
 * v 0.0.0
 *
 * 2019.11.28
 *
 * Copyright 2019. DunDung all rights reserved.
 */

public class Validator {
    private static final String FIRST_MENU = "1";
    private static final String SECOND_MENU = "2";

    public static boolean isValidNumbers(String number) {
        return number.length() == NumberBaseBallGame.DIGIT && isInteger(number);
    }

    public static boolean isValidMenuId(String menuId) {
        return isInteger(menuId) && menuId.equals(FIRST_MENU) || menuId.equals(SECOND_MENU);
    }

    private static boolean isInteger(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
