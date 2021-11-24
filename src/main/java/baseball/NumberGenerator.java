package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static String generate() {
        StringBuilder number = new StringBuilder();
        buildNumber(number);
        return number.toString();
    }

    private static void buildNumber(StringBuilder number) {
        while (number.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            appendWithoutDuplicate(number, randomNumber);
        }
    }

    private static void appendWithoutDuplicate(StringBuilder str, int number) {
        if (!str.toString().contains(String.valueOf(number))) {
            str.append(number);
        }
    }
}
