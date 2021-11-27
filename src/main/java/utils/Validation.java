package utils;

public class Validation {
    public static void validate(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException();
        }
    }
}

