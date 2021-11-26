package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class RandomNumberFactory {
    private static final int NUMBER_OF_DIGITS = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public static Set<Integer> generate() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < NUMBER_OF_DIGITS) {
            numbers.add(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
        }
        return numbers;
    }
}
