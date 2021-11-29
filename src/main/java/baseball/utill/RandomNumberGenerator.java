package baseball.utill;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private static final int NUMBER_COUNT = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public List<Integer> generateRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();

        while (randomNumber.size() != NUMBER_COUNT) {
            int tempNum = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);

            if (!randomNumber.contains(tempNum)) {
                randomNumber.add(tempNum);
            }
        }

        return randomNumber;
    }
}
