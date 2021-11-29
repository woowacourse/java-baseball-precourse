package util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumbersGenerator {
    private RandomNumbersGenerator() {
    }

    public static List<Integer> generate(int minValue, int maxValue, int countOfNumbers) {
        Set<Integer> randomBalls = new HashSet<>();
        while (randomBalls.size() < countOfNumbers) {
            randomBalls.add(pickNumberInRange(minValue, maxValue + 1));
        }
        return new ArrayList<>(randomBalls);
    }
}
