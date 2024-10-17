package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class TargetNumberGenerator {
    public String generate() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numbers.add(randomNumber);
        }

        StringBuilder result = new StringBuilder();
        for (int number : numbers) {
            result.append(number);
        }
        return result.toString();
    }
}
