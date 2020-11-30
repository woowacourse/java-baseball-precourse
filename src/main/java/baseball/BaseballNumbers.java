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

    // 현재 객체가 index 위치에 지닌 값이 value와 같은지 판별하는 메소드
    private boolean isStrikeAtIndex(final int index, final int value) {
        return this.numberArray[index] == value;
    }

    // 현재 객체가 index를 제외한 위치에 지닌 값이 value와 같은지 판별하는 메소드
    private boolean isBallOutsideIndex(final int index, final int value) {
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
    public int getCountOfStrike(final BaseballNumbers friend) {
        int countOfStrike = 0;
        for (int index = 0; index < this.numberArray.length; index++) {
            if (isStrikeAtIndex(index, friend.numberArray[index])) {
                countOfStrike++;
            }
        }
        return countOfStrike;
    }

    // 자신과 friend 객체의 numberList를 비교하여 볼 수를 계산하는 객체
    public int getCountOfBall(final BaseballNumbers friend) {
        int countOfBall = 0;
        for (int index = 0; index < this.numberArray.length; index++) {
            if (isBallOutsideIndex(index, friend.numberArray[index])) {
                countOfBall++;
            }
        }
        return countOfBall;
    }
}
