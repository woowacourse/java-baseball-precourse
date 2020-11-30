package utils.validator;

import baseball.domain.Number;

public class NumberValidator implements Validator {
    @Override
    public void execute(String input) {
        isValidLength(input);
        isValidNumber(input);
    }

    private void isValidNumber(String input) {
        char character;

        for (int i=0; i<input.length(); i++) {
            character = input.charAt(i);
            if (character < 49 || character > 57) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void isValidLength(String input) {
        if (input.length() != Number.NUM_LENGTH){
            throw new IllegalArgumentException();
        }
    }
}
