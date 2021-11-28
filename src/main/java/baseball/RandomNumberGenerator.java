package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import constant.SystemMessage;

import java.util.LinkedHashSet;

public class RandomNumberGenerator {
    private static final int NUMBER_SIZE = 3;

    public int generateRandomNumber() {
        LinkedHashSet<Integer> randomNumberSet = new LinkedHashSet<>();
        while (randomNumberSet.size() < NUMBER_SIZE) {
            randomNumberSet.add(Randoms.pickNumberInRange(1, 9));
        }
        return makeSetToNumber(randomNumberSet);
    }

    private int makeSetToNumber(LinkedHashSet<Integer> randomNumberSet) {
        int randomNumber = SystemMessage.ZERO;
        for (int number : randomNumberSet) {
            randomNumber = randomNumber * 10 + number;
        }
        return randomNumber;
    }

}
