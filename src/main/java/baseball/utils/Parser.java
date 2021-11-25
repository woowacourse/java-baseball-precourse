package baseball.utils;

public class Parser {

    public Parser() {
    }

    public int[] userInputParser(String input) {
        checkSize(input, 3);
        int parseInt[] = getParseInt(input);
        return parseInt;
    }

    private void checkSize(String input, int size) {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private int[] getParseInt(String input) {
        int parseInt[] = new int[3];

        for (int i = 0; i < input.length(); i++) {
            if ('0' > input.charAt(i) || input.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            parseInt[i] = input.charAt(i) - '0';
        }
        return parseInt;
    }
}
