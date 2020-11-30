package baseball;

import static baseball.UtilityFunctions.validateDuplicateItemsInArray;
import static baseball.UtilityFunctions.validateItemRangeInArray;
import static baseball.UtilityFunctions.validateSizeOfArray;

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
}
