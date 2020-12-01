package baseball.domain;

import java.util.List;

import static baseball.controller.GameController.EXIT_NUMBER;
import static baseball.controller.GameController.RESTART_NUMBER;
import static baseball.domain.InputNumbersValidator.INVALID_NUMBER;
import static baseball.domain.RandomNumbers.NUMBER_LIST_SIZE;

/**
 * 값의 유효성을 체크하고, 아니면 exception 발생시키는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 11월 30일
 */
public class ValidateChecker {
    public static boolean isRestartFlag(String userInput) {
        if (!RESTART_NUMBER.equals(userInput) && !EXIT_NUMBER.equals(userInput)) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
        return RESTART_NUMBER.equals(userInput);
    }

    public static int checkDistinctNumber(List<Integer> inputNumbers, int convertNumber) {
        if (inputNumbers.contains(convertNumber)) {
            throw new IllegalArgumentException("서로 다른 세개의 숫자를 입력해야 합니다.");
        }
        return convertNumber;
    }

    public static void checkInvalidWithZero(List<Integer> inputNumbers) {
        if (inputNumbers.stream().anyMatch(i -> i.equals(INVALID_NUMBER))) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }

    public static void checkValidWithLengthThree(List<Integer> inputNumbers) {
        if (inputNumbers.size() != NUMBER_LIST_SIZE) {
            throw new IllegalArgumentException("숫자는 3개를 입력해야 합니다.");
        }
    }
}
