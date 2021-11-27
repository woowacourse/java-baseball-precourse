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
            throw new IllegalArgumentException();
        }
    }

    public static void checkLength(String inputNumbers) {
        if (inputNumbers.length() != MessageList.SIZE_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicate(ArrayList<Integer> targetList) {
        Set<Integer> checkList = new HashSet<>(targetList);
        if (checkList.size() != MessageList.SIZE_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkRange(Integer targetNumber) {
        if (targetNumber.toString().contains(MessageList.FIND_ZERO)) {
            throw new IllegalArgumentException();
        }
        if (!(targetNumber >= MessageList.MIN_NUMBER) && (targetNumber <= MessageList.MAX_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }
}
