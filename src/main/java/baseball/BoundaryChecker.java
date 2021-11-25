package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BoundaryChecker {
    private static final int MIN_NUMBER = 123;
    private static final int MAX_NUMBER = 987;
    private static final int SIZE_RANGE = 3;
    private static final String ZERO = "0";

    public BoundaryChecker() {
    }

    public void convertInt(String inputNumbers) {
        try {
            Integer.parseInt(inputNumbers);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void checkLength(String inputNumbers) {
        if (inputNumbers.length() != SIZE_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplicate(ArrayList<Integer> targetList) {
        Set<Integer> checkList = new HashSet<>(targetList);
        if (checkList.size() != SIZE_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    public void checkRange(Integer targetNumber) {
        if (targetNumber.toString().contains(ZERO)) {
            throw new IllegalArgumentException();
        }
        if (!(targetNumber >= MIN_NUMBER) && (targetNumber <= MAX_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }
}
