package utils.validator;

public class NumberValidator implements Validator {
    @Override
    public void execute(String input) {
        char character;

        for (int i=0; i<input.length(); i++) {
            character = input.charAt(i);
            if (character < 48 || character > 57) {
                throw new IllegalArgumentException();
            }
        }
    }
}
