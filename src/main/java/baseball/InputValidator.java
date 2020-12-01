package baseball;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 입력한 값이 조건에 맞는지 검사하는 클래스
 */
public class InputValidator {

    public static final int THREE = 3;
    private static final String[] oneOrTwo = {"1", "2"};
    private static final int ONE = 49;
    private static final int NINE = 57;

    public String inputNumber(String input) {
        if (!isValid(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public boolean isValid(String input) {
        if (!isUnique(input)) {
            return false;
        }
        for (int i = 0, length = input.length(); i < length; i++) {
            char num = input.charAt(i);
            if (!isValidInteger(num)) {
                return false;
            }
        }
        return true;
    }

    public boolean oneOrTwo(String input) {
        if (Arrays.asList(oneOrTwo).contains(input)) {
            return input.equals("1");
        }
        throw new IllegalArgumentException();
    }

    private boolean isUnique(String input) {
        Set<String> set = new HashSet<>();
        for (int i = 0, length = input.length(); i < length; i++) {
            set.add(input.substring(i, i + 1));
        }
        return set.size() == THREE;
    }

    private boolean isValidInteger(char inputChar) {
        return inputChar >= ONE && inputChar <= NINE;
    }
}
