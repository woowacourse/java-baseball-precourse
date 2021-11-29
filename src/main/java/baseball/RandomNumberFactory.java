package baseball;

import static baseball.StringUtil.END_NUMBER;
import static baseball.StringUtil.NUMBER_OF_DIGITS_OF_NUMBER;
import static baseball.StringUtil.START_NUMBER;

import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberFactory {
    public static Set<Integer> generate() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < NUMBER_OF_DIGITS_OF_NUMBER) {
            numbers.add(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
        }
        return numbers;
    }
}
