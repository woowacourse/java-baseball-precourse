package baseball;

import static baseball.StringUtil.*;

import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberFactory {
    public static Set<Integer> generate() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < NUMBER_OF_DIGITS_OF_GAME_NUMBER) {
            numbers.add(Randoms.pickNumberInRange(MIN_GAME_NUMBER, MAX_GAME_NUMBER));
        }
        return numbers;
    }
}
