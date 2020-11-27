package utils;

/**
 * @author yhh1056
 * @since 2020/11/27
 */
public class NumberUtils {

    private NumberUtils() {
    }

    public static boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static void checkNatureNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
