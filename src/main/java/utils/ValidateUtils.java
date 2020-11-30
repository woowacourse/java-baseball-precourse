package utils;

import java.util.HashSet;

public class ValidateUtils {
    public static boolean validateInput(int input) {
        String inputString = String.valueOf(input);
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("input only 3 digits");
        }

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
        return true;
    }
}
