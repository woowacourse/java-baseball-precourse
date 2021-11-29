package baseball.util;

public class Assertion {

    private Assertion() {}

    public static void throwExceptionIfFalse(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }

}
