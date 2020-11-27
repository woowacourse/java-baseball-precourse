package utils;

import java.util.HashSet;
import java.util.Set;

public class InputUtils {

    private static final String CONTINUE_GAME = "1";
    private static final String END_GAME = "2";

    private InputUtils() {  // public 생성자 제한
    }

    public static String checkContinueInput(String userInput) {
        if (!userInput.equals(CONTINUE_GAME) && !userInput.equals(END_GAME)) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }

    public static String checkUserBallsInput(String userInput) {
        checkNumber(userInput);
        checkRightLength(userInput);
        checkWithoutDuplicate(userInput);

        return userInput;
    }

    private static void checkNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void checkRightLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkWithoutDuplicate(String userInput) {
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
