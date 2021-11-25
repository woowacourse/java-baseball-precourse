package baseball.utils;

public class Parser {

    public Parser() {
    }

    public int userInputParser(String input) {
        checkSize(input, 3);
        int parseInt = getParseInt(input);
        return parseInt;
    }

    private void checkSize(String input, int size) {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private int getParseInt(String input) {
        int parseInt = 0;
        for (int i = 0; i < input.length(); i++) {
            if ('0' > input.charAt(i) || input.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            parseInt *= 10;
            parseInt += Integer.parseInt(input, i);
        }
        return parseInt;
    }
}
