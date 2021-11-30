package baseball.util;

public class InputValidator {

    public InputValidator() {
    }

    public void validateInputAnswer(String input) {
        validateDigit(input);
        validateNumber(input);
        validateRange(input);
        validateDuplicateNumber(input);
    }

    private void validateDigit(String input) {
        if (input.length() != AnswerRange.DIGIT) {
            throw new IllegalArgumentException(MessageType.ERROR_NOT_THREE_DIGIT.getMessage());
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
}
