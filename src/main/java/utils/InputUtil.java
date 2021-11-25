package utils;

import baseball.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputUtil {


    public static List<Integer> getPlayerAnswer() {
        String answerStr = Console.readLine();

        checkInputLength(answerStr);

        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < answerStr.length(); i++) {
            checkInvalidDigit(answerStr.charAt(i));
            inputList.add(Integer.parseInt(String.valueOf(answerStr.charAt(i))));
        }

        checkDuplicate(inputList);

        return inputList;
    }

    private static void checkInputLength(String answerStr) {
        if (answerStr.length() > 3) {
            throw new IllegalArgumentException(Message.INPUT_ERROR_LENGTH);
        }
    }

    private static void checkInvalidDigit(char digit) {
        if (digit < '1' || digit > '9') {
            throw new IllegalArgumentException(Message.INPUT_ERROR_INVALID_INPUT);
        }
    }

    private static void checkDuplicate(List<Integer> inputList) {
        boolean[] check = new boolean[10];
        for (int digit: inputList) {
            if (check[digit]) {
                throw new IllegalArgumentException(Message.INPUT_ERROR_DUPLICATE);
            }
            check[digit] = true;
        }
    }
}
