package baseball;

import utils.RandomUtils;

public class BaseballNumberGenerator {
    private BaseballNumberGenerator() {}

    public static int nextBaseballNumber() {
        int number = nextRandomThreeDigit();
        while (!isBaseballNumber(number)) {
            number = nextRandomThreeDigit();
        }
        return number;
    }

    private static boolean isBaseballNumber(int number) {
        try {
            Validator.ValidateBaseBallNumber(number);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static int nextRandomThreeDigit() {
        String string = "";
        for (int i = 0; i < 3; i++) {
            string = string + nextRandomOneToNine();
        }
        return Integer.parseInt(string);
    }

    private static int nextRandomOneToNine() {
        return RandomUtils.nextInt(1, 9);
    }
}
