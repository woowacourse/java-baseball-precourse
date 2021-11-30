package baseball.util;

public class InputValidator {

    public InputValidator() {
    }

    public void validateInputAnswer(String input) {
        validateDigit(input, AnswerRange.DIGIT);
        validateNumber(input);
        validateRange(input);
        validateDuplicateNumber(input);
    }

    public void validateInputReplay(String input) {
        validateDigit(input, 1);
        validateOneOrTwo(input);
    }

    private void validateDigit(String input, int digit) {
        if (input.length() != digit) {
            if (digit == 1) {
                throw new IllegalArgumentException(MessageType.ERROR_NOT_ONE_DIGIT.getMessage());
            } else {
                throw new IllegalArgumentException(MessageType.ERROR_NOT_THREE_DIGIT.getMessage());
            }
        }
    }

    private void validateNumber(String input) {
        String regex = "[0-9]+";

        if (!input.matches(regex)) {
            throw new IllegalArgumentException(MessageType.ERROR_NOT_NUMBER.getMessage());
        }
    }

    private void validateRange(String input) {
        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - '0';

            if (!(number >= AnswerRange.MIN && number <= AnswerRange.MAX)) {
                throw new IllegalArgumentException(MessageType.ERROR_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicateNumber(String input) {
        boolean[] duplicateCheck = new boolean[AnswerRange.MAX + 1];

        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - '0';

            if (duplicateCheck[number]) {
                throw new IllegalArgumentException(MessageType.ERROR_NOT_DUPLICATE.getMessage());
            }

            duplicateCheck[number] = true;
        }
    }

    private void validateOneOrTwo(String input) {
        int number = input.charAt(0) - '0';

        if (!(number == 1 || number == 2)) {
            throw new IllegalArgumentException(MessageType.ERROR_ONE_OR_TWO.getMessage());
        }
    }
}
