package baseball.modules;

public class IntegerArrayUtils {
    public static boolean isContains(final int[] array, final int value) {
        if (ExceptionChecker.isNull(array)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }

        return false;
    }
}
