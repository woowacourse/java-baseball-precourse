package baseball;

import static baseball.Constants.GAME_MAX_BASEBALL_NUMBER;
import static baseball.Constants.GAME_MAX_BASEBALL_PITCH;
import static baseball.Constants.GAME_MIN_BASEBALL_NUMBER;

import java.util.HashSet;
import java.util.Set;

// 야구 게임에서 각 자리의 숫자를 도맡는 클래스
public class BaseballNumbers {

    // 각 투구에 해당하는 숫자를 저장해 둘 배열
    private final int[] numberArray;

    public BaseballNumbers(int[] numberArray) {
        validateSizeOfArray(numberArray);
        validateDuplicateItemsInArray(numberArray);
        validateItemRangeInArray(numberArray);
        this.numberArray = numberArray;
    }

    // 입력받은 배열의 크기가 GAME_MAX_BASEBALL_PITCH 값과 같은지 확인하는 메소드
    private void validateSizeOfArray(int[] numberArray) {
        if (numberArray.length != GAME_MAX_BASEBALL_PITCH) {
            throw new IllegalArgumentException(
                ErrorMessages.ARRAY_INVALID_LENGTH.getMessage()
            );
        }
    }

    // 입력받은 배열 내에 중복된 값이 있는지 확인하는 메소드
    private void validateDuplicateItemsInArray(int[] numberArray) {
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
    private void validateItemRangeInArray(int[] numberArray) {
        for (int number : numberArray) {
            if (number > GAME_MAX_BASEBALL_NUMBER || number < GAME_MIN_BASEBALL_NUMBER) {
                throw new IllegalArgumentException(
                    ErrorMessages.ARRAY_ITEM_OUT_OF_RANGE.getMessage()
                );
            }
        }
    }

    // 현재 객체가 index 위치에 지닌 값이 value와 같은지 판별하는 메소드
    private boolean hasValueAtIndex(final int index, final int value) {
        return this.numberArray[index] == value;
    }

    // 현재 객체가 index를 제외한 위치에 지닌 값이 value와 같은지 판별하는 메소드
    private boolean hasValueNotAtIndex(final int index, final int value) {
        for (int i = 0; i < this.numberArray.length; i++) {
            // i와 index가 같은 경우는 스트라이크를 판별할 때만 사용하므로 제외
            if (i == index) {
                continue;
            }
            if (this.numberArray[i] == value) {
                return true;
            }
        }
        return false;
    }

    // 자신과 friend 객체의 numberList를 비교하여 스트라이크 수를 계산하는 객체
    public int calculateStrikes(final BaseballNumbers friend) {
        int strikes = 0;
        for (int index = 0; index < this.numberArray.length; index++) {
            if (hasValueAtIndex(index, friend.numberArray[index])) {
                strikes++;
            }
        }
        return strikes;
    }

    // 자신과 friend 객체의 numberList를 비교하여 볼 수를 계산하는 객체
    public int calculateBalls(final BaseballNumbers friend) {
        int balls = 0;
        for (int index = 0; index < this.numberArray.length; index++) {
            if (hasValueNotAtIndex(index, friend.numberArray[index])) {
                balls++;
            }
        }
        return balls;
    }
}
