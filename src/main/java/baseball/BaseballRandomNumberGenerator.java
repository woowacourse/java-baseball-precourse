package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballRandomNumberGenerator {

    public static final int BASEBALL_NUMBER_MIN_VALUE = 1;
    public static final int BASEBALL_NUMBER_MAX_VALUE = 9;
    public static final int BASEBALL_NUMBER_LENGTH = 3;

    public List<Integer> generateRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < BASEBALL_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_NUMBER_MIN_VALUE, BASEBALL_NUMBER_MAX_VALUE);

            if (!checkDuplicate(randomNumbers, randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public boolean checkDuplicate(List<Integer> randomNumbers, int randomNumber) {
        return randomNumbers.contains(randomNumber);
    }
}
