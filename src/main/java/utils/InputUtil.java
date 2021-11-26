package utils;

import constant.Constant;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;

public class InputUtil {

    public static List<Integer> getPlayerAnswer() {
        String answerStr = Console.readLine();

        checkInputLength(answerStr);

        List<Integer> inputList = new ArrayList<>();
        for (int i = INITIAL_VALUE; i < NUM_LENGTH; i++) {
            int digit = Integer.parseInt(String.valueOf(answerStr.charAt(i)));
            checkInvalidDigit(digit);
            inputList.add(digit);
        }

        checkDuplicate(inputList);

        return inputList;
    }

    private static void checkInputLength(String answerStr) {
        if (answerStr.length() > NUM_LENGTH) {
            throw new IllegalArgumentException(Constant.INPUT_ERROR_LENGTH);
        }
    }

    private static void checkInvalidDigit(int digit) {
        if (digit < MIN_NUM || digit > MAX_NUM) {
            throw new IllegalArgumentException(Constant.INPUT_ERROR_INVALID_INPUT);
        }
    }

    private static void checkDuplicate(List<Integer> inputList) {
        boolean[] check = new boolean[DECIMAL_DIGIT];
        for (int digit: inputList) {
            if (check[digit]) {
                throw new IllegalArgumentException(Constant.INPUT_ERROR_DUPLICATE);
            }
            check[digit] = true;
        }
    }
}
