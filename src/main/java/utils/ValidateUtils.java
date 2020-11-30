package utils;

import java.util.HashSet;
import baseball.Game;

public class ValidateUtils {

    public static boolean validateInput(String input) {
        HashSet<Integer> set = new HashSet<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException("input only 3 digits");
        }

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("input only digits");
            }

            int num = Integer.valueOf(input.substring(i, i + 1));

            if (set.contains(num)) {
                throw new IllegalArgumentException("number duplicate");
            }

            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("number range is 1 ~ 9");
            }

            set.add(num);
        }

        return true;
    }

    public static boolean validateInputForRestart(int input) {
        if (input != Game.INPUT_RESTART && input != Game.INPUT_STOP) {
            throw new IllegalArgumentException("input only 1 or 2");
        }
        return true;
    }
}
