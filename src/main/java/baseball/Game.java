package baseball;

import java.util.Set;
import java.util.HashSet;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private final int MIN_RANGE = 1;
    private final int MAX_RANGE = 9;
    private final int DIGIT_NUM = 3;
    private final int RADIX = 10;

    Game() {
    }

    public String generateRandomNumber() {
        String result = "";
        Set<Character> randomNumberSet = new HashSet<>();

        int numberLength = 0;
        while (numberLength < DIGIT_NUM) {
            int randomDigit = Randoms.pickNumberInRange(MIN_RANGE,
                    MAX_RANGE);
            char number = Character.forDigit(randomDigit, RADIX);

            if (randomNumberSet.contains(number)) {
                continue;
            }
            numberLength++;
            result += number;
            randomNumberSet.add(number);
        }

        return result;

    }

}
