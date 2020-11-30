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
        validateSize(numberArray);
        validateDuplicate(numberArray);
        validateNumberRange(numberArray);
        this.numberArray = numberArray;
    }

    // 입력받은 배열의 크기가 MAX_PITCH 값과 같은지 확인하는 메소드
    private void validateSize(int[] numberArray) {
        if (numberArray.length != GAME_MAX_BASEBALL_PITCH) {
            String exceptionMessage = "숫자는 " + GAME_MAX_BASEBALL_PITCH + "개만 입력해야 합니다";
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    // 입력받은 배열 내에 중복된 값이 있는지 확인하는 메소드
    private void validateDuplicate(int[] numberArray) {
        final Set<Integer> baseballNumberSet = new HashSet<>();

        for (int number : numberArray) {
            baseballNumberSet.add(number);
        }

        // 중복된 수가 입력받은 배열에 있을 경우, 배열과 셋의 길이가 다른 것을 이용
        if (baseballNumberSet.size() != numberArray.length) {
            throw new IllegalArgumentException("배열 내에 중복된 숫자가 있으면 안 됩니다");
        }
    }

    // 입력받은 배열 내에 허용된 범위를 넘어가는 값이 있는지 확인하는 메소드
    private void validateNumberRange(int[] numberArray) {
        for (int number : numberArray) {
            if (number > GAME_MAX_BASEBALL_NUMBER || number < GAME_MIN_BASEBALL_NUMBER) {
                throw new IllegalArgumentException("배열 내에 범위를 벗어난 숫자가 존재합니다");
            }
        }
    }
}
