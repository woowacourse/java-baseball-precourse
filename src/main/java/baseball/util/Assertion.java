package baseball.util;

public class Assertion {

    private Assertion() {}

    public static void throwExceptionIfFalse(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void throwExceptionIsNull(boolean condition) {
        if (condition) {
            throw new IllegalArgumentException("must not be null");
        }
    }

}
