package domain;

import java.util.List;

public class BaseBall {
    public static final int MIN_DIGIT = 1;
    public static final int MAX_DIGIT = 9;
    public static final int BASEBALL_LENGTH = 3;
    private static final int ZERO = 0;
    private List<Integer> baseballNumber;

    public BaseBall(List<Integer> baseballNumber) {
        validateNumber(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    private void validateNumber(List<Integer> baseballNumber) throws IllegalStateException {
        if (!isCorrectForm(baseballNumber)) {
            throw new IllegalStateException("0을 제외한 "+BASEBALL_LENGTH + "자리 숫자를 입력해주세요.");
        }
    }

    private boolean isCorrectForm(List<Integer> baseballNumber) {
        return (baseballNumber.size() == BASEBALL_LENGTH) && !baseballNumber.contains(ZERO);
    }

    public boolean containsNumber(int number) {
        return baseballNumber.contains(number);
    }

    public boolean hasNumber(int index, int number) {
        return baseballNumber.get(index) == number;
    }

    public int getNumber(int index) {
        return baseballNumber.get(index);
    }

    public int size() {
        return baseballNumber.size();
    }
}
