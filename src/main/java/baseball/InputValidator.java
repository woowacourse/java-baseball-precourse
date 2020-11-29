package baseball;

public class InputValidator {
    private static final String ZERO = "0";
    private static final String DIGIT_REGEX = "\\d+";
    private static final String RESTART = "1";
    private static final String QUIT = "2";
    private static final String NUMBER_EXCEPTION_MESSAGE = "숫자만 입력하세요.";
    private static final String WRONG_LENGTH_MESSAGE = "세 자리를 입력하세요.";
    private static final String NO_ZERO_MESSAGE = "0이 포함되지 않도록 입력하세요.";
    private static final String NO_DUPLICATION = "중복된 숫자가 없도록 입력하세요.";
    private static final String RESTART_OR_QUIT_EXCEPTION_MESSAGE = "1 또는 2를 입력하세요.";

    private static final int DIGIT = 3;
    private static final int NEXT = 1;
    private static final int NOT_EXIST = -1;

    public static void validateInputIsNumber(String input) {
        if (!input.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static void validateInputLengthEqualsDigit(String input) {
        if (input.length() != DIGIT) {
            throw new IllegalArgumentException(WRONG_LENGTH_MESSAGE);
        }
    }

    public static void validateZero(String input) {
        if (input.contains(ZERO)) {
            throw new IllegalArgumentException(NO_ZERO_MESSAGE);
        }
    }

    public static void validateDuplication(String input) {
        char inputCharacterElement;
        for (int i = 0; i < input.length(); i++) {
            inputCharacterElement = input.charAt(i);
            checkSameElement(isSameElement(input, Character.toString(inputCharacterElement), i));
        }
    }

    public static boolean isSameElement(String input, String inputCharacterElement, int nowIndex) {
        int nextIndex = nowIndex + NEXT;
        if (input.indexOf(inputCharacterElement, nextIndex) == NOT_EXIST) {
            return false;
        }
        return true;
    }

    public static void checkSameElement(boolean isSameElement) {
        if (isSameElement) {
            throw new IllegalArgumentException(NO_DUPLICATION);
        }
    }

    public static void validateRestartOrQuit(String restartOrQuit) {
        if (!restartOrQuit.equals(RESTART) && !restartOrQuit.equals(QUIT)) {
            throw new IllegalArgumentException(RESTART_OR_QUIT_EXCEPTION_MESSAGE);
        }
    }
}
