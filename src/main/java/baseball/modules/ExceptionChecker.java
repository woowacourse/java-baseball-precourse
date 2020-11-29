package baseball.modules;

import java.util.HashSet;

/**
 * Check whether the input value is an exception.
 * 
 * @author Kim Hanseul
 */
public class ExceptionChecker {
    public static boolean isParsableToInteger(final String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    /**
     * Check if length of the input value is the same as the given length.
     * 
     * @param input input string
     * 
     * @param targetLength The value for compare with length of the input string
     */
    public static boolean isLengthFit(final String input, final int targetLength) {
        if (isNull(input)) {
            throw new IllegalArgumentException();
        }

        return input.length() == targetLength;
    }

    /** Check if input value contains the character 0. */
    public static boolean isContainsZero(final String input) {
        if (isNull(input)) {
            throw new IllegalArgumentException();
        }
        
        for (int i = 0; i < input.length(); i++) {
            if (Character.getNumericValue(input.charAt(i)) == 0) {
                return true;
            }
        }

        return false;
    }

    /** Check that each value in the array is not duplicated with other values ​​in the array. */
    public static boolean isArrayElementsAreUnique(final int[] input) {
        if (isNull(input)) {
            throw new IllegalArgumentException();
        }
        
        HashSet<Integer> shown = new HashSet<Integer>();

        for (int i = 0; i < input.length; i++) {
            if (shown.contains(input[i])) {
                return false;
            }

            shown.add(input[i]);
        }

        return true;
    }    

    /** Check if input value is 1 or 2 */
    public static boolean isOneOrTwo(final String input) {
        if (isNull(input)) {
            throw new IllegalArgumentException();
        }

        if (!isParsableToInteger(input)) {
            throw new IllegalArgumentException();
        }

        int inputInteger = Integer.parseInt(input);
        return inputInteger == 1 || inputInteger == 2;
    }

    public static boolean isNull(Object input) {
        return input == null;
    }
}
