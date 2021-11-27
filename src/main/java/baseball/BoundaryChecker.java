package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import constant.MessageList;

public class BoundaryChecker {

    private BoundaryChecker() {
    }

    public static void convertInt(String inputNumbers) {
        try {
            Integer.parseInt(inputNumbers);
        } catch (Exception e) {
            throw new IllegalArgumentException("The input data is not a number.");
        }
    }

    public static void validateNumbers(String targetNumber) {
        if (targetNumber.length() != MessageList.SIZE_RANGE) {
            throw new IllegalArgumentException("It's not three numbers.");
        }
        if (targetNumber.contains(MessageList.FIND_ZERO)) {
            throw new IllegalArgumentException("The number contains zeros.");
        }
    }

    public static void checkDuplicate(ArrayList<Integer> targetList) {
        Set<Integer> checkList = new HashSet<>(targetList);
        if (checkList.size() != MessageList.SIZE_RANGE) {
            throw new IllegalArgumentException("Duplicate numbers are entered.");
        }
    }

    public static void validateRange(Integer targetNumber) {
        if (!(targetNumber >= MessageList.MIN_NUMBER) && (targetNumber <= MessageList.MAX_NUMBER)) {
            throw new IllegalArgumentException("You have entered a number in the wrong range.");
        }
    }
}
