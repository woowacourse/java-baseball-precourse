package baseball;

public class User {
    private String number = "";

    private static final int START_CAHR_VAL = 49;
    private static final int END_CHAR_VAL = 57;
    private static final int SIZE = 3;

    public void makeNumber(String input) throws IllegalArgumentException {
        checkInputSize(input);
        checkNumber(input);
        checkDuplicate(input);

        number = input;
    }

    private void checkInputSize(String input) {
        if (input.length() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumber(String input) {
        for (int i = 0; i < SIZE; i++) {
            char aChar = input.charAt(i);
            isRightNumber(aChar);
        }
    }

    private void isRightNumber(char aChar) {
        if (aChar < START_CAHR_VAL || aChar > END_CHAR_VAL) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(String input) {
        for (int i = 0; i < SIZE-1; i++) {
            char aChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);
            isDuplicate(aChar, nextChar);
        }
    }

    private void isDuplicate(char aChar, char nextChar) {
        if (aChar == nextChar) {
            throw new IllegalArgumentException();
        }
    }

    public String getNumber() {
        return number;
    }
}
