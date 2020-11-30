package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자 야구 게임에 사용되는 유틸성 랜덤 숫자 생성 클래스입니다.
 */
public class BaseballDigitsGenerator {

    public static final int BASEBALL_NUM_MIN = 1;       // 야구 게임 숫자 범위 최소
    public static final int BASEBALL_NUM_MAX = 9;       // 야구 게임 숫자 범위 최대
    public static final int BASEBALL_LEN = 3;           // 야구 게임 숫자 개수

    private BaseballDigitsGenerator() {}

    /** 1부터 9사이의 3개의 랜덤 숫자를 생성하는 함수 */
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
