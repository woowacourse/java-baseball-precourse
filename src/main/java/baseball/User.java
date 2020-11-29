package baseball;

public class User {
    private String number = "";

    private static final int START_CAHR_VAL = 49;
    private static final int END_CHAR_VAL = 57;
    private static final int SIZE = 3;

    public void makeNumber(String input) throws IllegalArgumentException {

        if (input.length() != SIZE) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < SIZE; i++) {
            char aChar = input.charAt(i);
            if (aChar < START_CAHR_VAL || aChar > END_CHAR_VAL) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < SIZE-1; i++) {
            char aChar = input.charAt(i);
            if (aChar == input.charAt(i + 1)) {
                throw new IllegalArgumentException();
            }
        }

        number = input;
    }

    public String getNumber() {
        return number;
    }
}
