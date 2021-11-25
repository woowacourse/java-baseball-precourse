package baseball;

import java.util.List;

/**
 * 사용자에게 입력받은 수가 올바른지 검증하는 클래스
 * 올바르지 않을 경우 예외를 발생시키고 종료시킨다.
 */
public class InputNumberValidator {
    static final int NUMBER_LENGTH = 3;
    static final int RANGE_START = 1;
    static final int RANGE_END = 9;

    private List<Integer> inputNumberList;

    public InputNumberValidator(List<Integer> inputNumberList) {
        this.inputNumberList = inputNumberList;
    }

    public boolean inputNumberExceptionCheck() {
        return lengthCheck() && rightRangeCheck() && distinctCheck();
    }

    public Boolean lengthCheck() {
        return inputNumberList.size() == NUMBER_LENGTH;
    }

    public Boolean rightRangeCheck() {
        return inputNumberList.stream()
                .filter(number -> RANGE_START <= number && number <= RANGE_END)
                .count() == NUMBER_LENGTH;
    }

    public Boolean distinctCheck() {
        return inputNumberList.stream()
                .distinct()
                .count() == NUMBER_LENGTH;
    }
}
