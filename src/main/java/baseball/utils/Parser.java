package baseball.utils;

public class Parser {

    public int[] parseUserInput(String input, int size) {
        checkSize(input, size);
        int parseInt[] = getParseInt(input, size);
        return parseInt;
    }

    private void checkSize(String input, int size) throws IllegalArgumentException{
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private int[] getParseInt(String input, int size) throws IllegalArgumentException{
        int parseInt[] = new int[size];

        for (int i = 0; i < input.length(); i++) {
            if ('0' > input.charAt(i) || input.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            parseInt[i] = input.charAt(i) - '0';
        }
        return parseInt;
    }
}
