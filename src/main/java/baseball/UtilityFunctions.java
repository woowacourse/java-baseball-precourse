package baseball;

import static baseball.Constants.GAME_MAX_BASEBALL_NUMBER;
import static baseball.Constants.GAME_MAX_BASEBALL_PITCH;
import static baseball.Constants.GAME_MIN_BASEBALL_NUMBER;

import java.util.HashSet;
import java.util.Set;

public class UtilityFunctions {

    private UtilityFunctions() {
    }

    // 입력받은 배열의 크기가 MAX_PITCH 값과 같은지 확인하는 메소드
    public static void validateSizeOfArray(int[] numberArray) {
        if (numberArray.length != GAME_MAX_BASEBALL_PITCH) {
            throw new IllegalArgumentException(
                ErrorMessages.ARRAY_INVALID_LENGTH.getMessage()
            );
        }
    }

    // 입력받은 배열 내에 중복된 값이 있는지 확인하는 메소드
    public static void validateDuplicateItemsInArray(int[] numberArray) {
        final Set<Integer> baseballNumberSet = new HashSet<>();

        for (int number : numberArray) {
            baseballNumberSet.add(number);
        }

        // 중복된 수가 입력받은 배열에 있을 경우, 배열과 셋의 길이가 다른 것을 이용
        if (baseballNumberSet.size() != numberArray.length) {
            throw new IllegalArgumentException(
                ErrorMessages.ARRAY_ITEM_DUPLICATED.getMessage()
            );
        }
    }

    // 입력받은 배열 내에 허용된 범위를 넘어가는 값이 있는지 확인하는 메소드
    public static void validateItemRangeInArray(int[] numberArray) {
        for (int number : numberArray) {
            if (number > GAME_MAX_BASEBALL_NUMBER || number < GAME_MIN_BASEBALL_NUMBER) {
                throw new IllegalArgumentException(
                    ErrorMessages.ARRAY_ITEM_OUT_OF_RANGE.getMessage()
                );
            }
        }
    }

    // 정답 추측 입력이 올바른지 확인하는 메소드
    public static void validateGuessInput(String guessStr) {
        // TODO 구현 진행
    }

    // guessStr을 int[]로 변환해주는 메소드
    public static int[] parseGuessStr(String guessStr) {
        int[] userGuessArr = new int[3];
        // TODO 구현 진행
        return userGuessArr;
    }
}
