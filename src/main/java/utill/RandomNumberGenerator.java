package utill;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public static final int NUMBER_COUNT = 3;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;

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
