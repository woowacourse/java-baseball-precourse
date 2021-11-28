package baseball;

public class InputValidator {

    public static final int NUMBER_LENGTH = 3;
    public static final int SELECTION_LENGTH = 1;

    public static void validateLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력 값의 자리수가 3이 아닙니다.");
        }
    }

    public static void validateNumbers(String input) {
        for (int i = 0 ; i < NUMBER_LENGTH ; i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("입력값에 숫자가 아닌 문자가 있습니다.");
            } else if (Character.getNumericValue(input.charAt(i)) == 0) {
                throw new IllegalArgumentException("입력값에 0이 포함되어 있습니다.");
            }
        }
    }

    public static void validateSelection(String input) {
        if (input.length() != SELECTION_LENGTH) {
            throw new IllegalArgumentException("입력값의 길이가 1이 아닙니다.");
        } else if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }


}
