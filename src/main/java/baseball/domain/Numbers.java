package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.RandomNumbers.LIST_SIZE;

public class Numbers {
    private static final int INVALID_NUMBER = 0;
    private final List<Integer> intNumberList = new ArrayList<>();

    public List<Integer> checkValidNumbers(String threeNumbers) {
        checkNothingIsSame(threeNumbers);
        isInvalidWithZero();
        isValidWithThreeLength();
        return intNumberList;
    }

    private void isInvalidWithZero() {
        if (intNumberList.stream().anyMatch(integer -> integer.equals(INVALID_NUMBER)))
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
    }

    private void isValidWithThreeLength() {
        if (intNumberList.size() != LIST_SIZE) throw new IllegalArgumentException("숫자는 3개를 입력해야 합니다.");
    }

    private void checkNothingIsSame(String threeNumbers) {
        char[] charNumberArray = threeNumbers.toCharArray();
        for (Character charNumber : charNumberArray) {
            if (intNumberList.contains((int) charNumber)) throw new IllegalArgumentException("서로 다른 세개의 숫자를 입력해야 합니다.");
            this.intNumberList.add(Character.getNumericValue(charNumber));
        }
    }
}
