package utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputUtils {
    public static String checkUserInput(String userInput) {
        isNumber(userInput);
        isRightLength(userInput);
        isWithoutDuplicate(userInput);

        return userInput;
    }

    private static void isNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isRightLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void isWithoutDuplicate(String userInput) {
        Set<Integer> numberSet = new HashSet<Integer>();
        String[] strList = userInput.split("");

        for (int i = 0; i < strList.length; i++) {
            int number = Integer.parseInt(strList[i]);
            if (number == 0 || numberSet.contains(number)) {
                throw new IllegalArgumentException();
            }
            numberSet.add(number);
        }
    }
}
