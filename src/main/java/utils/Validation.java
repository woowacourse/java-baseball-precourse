package utils;

import java.util.stream.Stream;

public class Validation {
    public static void validate(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException();
        }

        String[] inputDigitSet = Stream.of(input.split(""))
                .distinct()
                .toArray(String[]::new);

        if (inputDigitSet.length != 3){
            throw new IllegalArgumentException();
        }

    }
}

