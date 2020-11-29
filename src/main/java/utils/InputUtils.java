package utils;

import java.util.HashSet;
import java.util.Set;

public class InputUtils {
    private static final String PLAYER_INPUT_EXCEPTION_MESSAGE = "1부터 9까지 중 서로 다른 3자리의 숫자를 입력해주세요 :)";
    private static final String PLAYER_RESTART_EXCEPTION_MESSAGE = "1(새로 시작), 2(종료) 중 하나의 숫자를 입력하세요 :)";
    private static final int DIGIT = 3;

    private InputUtils() {}

    public static int digit() {
        return DIGIT;
    }

    public static void validateUserInputForNumbers(String input) {
        if (isLengthThree(input) && unique(input) && parsableToInt(input)) {
            return;
        }
        throwInputException(PLAYER_INPUT_EXCEPTION_MESSAGE);
    }

    public static void validateUserInputForRestart(String input) {
        if (oneOrTwo(input)) {
            return;
        }
        throwInputException(PLAYER_RESTART_EXCEPTION_MESSAGE);
    }


    private static boolean isLengthThree(String input) {
        return input.length() == 3;
    }

    private static boolean unique(String input) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < DIGIT; i++) {
            set.add(input.substring(i, i+1));
        }
        return set.size() == DIGIT;
    }

    private static boolean parsableToInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void throwInputException(String exceptionMessage) {
        throw new IllegalArgumentException(exceptionMessage);
    }

    private static boolean oneOrTwo(String input) {
        String[] oneOrTwo = {"1", "2"};
        for (String s : oneOrTwo) {
            if (s.equals(input)) {
                return true;
            }
        }
        return false;
    }
}
