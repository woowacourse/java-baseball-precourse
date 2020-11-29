/*
 * Class:   BaseBallUtils.java
 *
 * Version: 1.0.0
 *
 * Date:    2020-11-26
 *
 * Author:  Dong Gun Lee
 *
 */

package utils;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BaseBallUtils {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final String NOT_THREE_NUMBERS_MESSAGE = "3자리의 수가 아닙니다.";
    private static final String NOT_ONE_TO_ZERO_MESSAGE = "1에서 9사이의 숫자가 아닙니다.";
    private static final String DUPLICATED_MESSAGE = "숫자가 중복되었습니다.";
    private static final String INVALID_VALUE_MESSAGE = "입력된 수가 1 혹은 2가 아닙니다.";
    private static final String INVALID_CODE_EXCEPTION = "한 자리의 숫자만 입력해주세요.";

    private BaseBallUtils() {
    }

    public static void isBallsRight(List<Integer> inputBalls) {
        if (!isThree(inputBalls)) {
            throw new IllegalArgumentException(NOT_THREE_NUMBERS_MESSAGE);
        }
        if (!isNum(inputBalls)) {
            throw new IllegalArgumentException(NOT_ONE_TO_ZERO_MESSAGE);
        }
        if (!isDuplicated(inputBalls)) {
            throw new IllegalArgumentException(DUPLICATED_MESSAGE);
        }
    }

    public static int isCodeRight(Scanner scanner) {
        int code;

        try {
            code = scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_CODE_EXCEPTION);
        }

        if (!(code == 1 || code == 2)) {
            throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
        }

        return code;
    }

    private static Boolean isNum(List<Integer> inputBalls) {
        for (int i = 0; i < inputBalls.size(); i++) {
            if ((inputBalls.get(i) < MIN_NUM) || (inputBalls.get(i) > MAX_NUM)){
                return false;
            }
        }

        return true;
    }

    private static Boolean isThree(List<Integer> inputBalls) {
        if (inputBalls.size() != 3) {
            return false;
        }

        return true;
    }

    private static Boolean isDuplicated(List<Integer> inputBalls) {
        Set<Integer> setBalls = new HashSet(inputBalls);

        if (setBalls.size() < 3) {
            return false;
        }

        return true;
    }
}
