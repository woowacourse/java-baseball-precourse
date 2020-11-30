package utils;

import java.util.HashSet;
import baseball.Game;

public class ValidateUtils {

    public static boolean validateInput(int input) {
        String inputString = String.valueOf(input);
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < inputString.length(); i++) {
            int num = Integer.valueOf(inputString.substring(i, i + 1));
            if (set.contains(num)) {
                throw new IllegalArgumentException("number duplicate");
            }

            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("number range is 1 ~ 9");
            }
            set.add(num);
        }

        if (inputString.length() != 3) {
            throw new IllegalArgumentException("input only 3 digits");
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
