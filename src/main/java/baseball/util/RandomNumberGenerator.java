package baseball.util;

import baseball.GameNumber;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import static baseball.config.Constant.*;

public class RandomNumberGenerator {
    public static GameNumber generateNumber() {
        LinkedHashSet<Integer> randomGameNumber = new LinkedHashSet<>();

        while (randomGameNumber.size() < NUM_SIZE) {
            randomGameNumber.add(Randoms.pickNumberInRange(MIN_NUM_VALUE, MAX_NUM_VALUE));
        }

        return new GameNumber(new ArrayList<>(randomGameNumber));
    }
}
