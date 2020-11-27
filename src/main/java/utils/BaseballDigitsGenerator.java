package utils;

import java.util.ArrayList;
import java.util.List;

public class BaseballDigitsGenerator {

    public static final int BASEBALL_NUM_MIN = 1;       // 야구 게임 숫자 범위 최소
    public static final int BASEBALL_NUM_MAX = 9;       // 야구 게임 숫자 범위 최대
    public static final int BASEBALL_LEN = 3;           // 야구 게임 숫자 개수

    private BaseballDigitsGenerator() {}

    public static List<Integer> generateRandomDigitsList() {
        boolean[] checkDuplicate = new boolean[BASEBALL_NUM_MAX + 1];
        List<Integer> randomDigits = new ArrayList<>();

        while (randomDigits.size() < BASEBALL_LEN) {
            int randomDigit = RandomUtils.nextInt(BASEBALL_NUM_MIN, BASEBALL_NUM_MAX);

            if (!checkDuplicate[randomDigit]) {
                checkDuplicate[randomDigit] = true;
                randomDigits.add(randomDigit);
            }
        }
        return randomDigits;
    }

}
