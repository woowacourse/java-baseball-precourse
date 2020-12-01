package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static utils.Constant.*;

public class Validator {

    public static String getValidateBall(String candidate) {
        checkInteger(candidate);
        checkIncorrectLength(candidate);
        checkContainZero(candidate);
        checkNumberDuplicate(candidate);
        return candidate;
    }

    private static void checkNumberDuplicate(String candidate) {
        HashSet<Character> hashSet = new HashSet<Character>();
        for (int i = 0; i < BALLS_LENGTH; i++) {
            hashSet.add(candidate.charAt(i));
        }
        if (hashSet.size() != BALLS_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_NUMBER_DUPLICATE);
        }
    }

    private static void checkInteger(String candidate) {
        try {
            Integer.parseInt(candidate);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_NOT_NUMBER);
        }
    }

    private static void checkContainZero(String candidate) {
        if (candidate.contains("0")) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_CONTAIN_ZERO);
        }
    }

    private static void checkIncorrectLength(String candidate) {
        if (candidate.length() != BALLS_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_INCORRECT_LENGTH);
        }
    }


}
