package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.ValidateChecker.*;

/**
 * 인풋 값의 유효성을 판단하고 형 변환해주는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 11월 25일
 */
public class InputNumbersValidator {
    public static final int INVALID_NUMBER = 0;

    public List<Integer> makeInputNumbers(String inputData) {
        final List<Integer> inputNumbers = addDistinctNumbers(inputData);
        checkInvalidWithZero(inputNumbers);
        checkValidWithLengthThree(inputNumbers);
        return inputNumbers;
    }

    private List<Integer> addDistinctNumbers(String inputData) {
        final List<Integer> inputNumbers = new ArrayList<>();
        for (Character c : inputData.toCharArray()) {
            inputNumbers.add(checkDistinctNumber(inputNumbers, Character.getNumericValue(c)));
        }
        return inputNumbers;
    }

}
