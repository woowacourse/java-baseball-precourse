package baseball;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {
    private static final int MIN = 1;
    private static final int MAX = 9;

    public static String randomNumberGenerate(final int digit) {
        Set<String> duplicateChecker = new HashSet<>();
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException("자릿수가 올바르지 않습니다.");
        }
        while (duplicateChecker.size() < digit) {
            duplicateChecker.add(String.valueOf(RandomUtils.nextInt(MIN, MAX)));
        }
        return String.join("", duplicateChecker);
    }
}
