package utils;

import java.util.Arrays;

public class InputConverter {
    public static int[] stringToArray(String input){
        return Arrays.asList(input.split(""))
                .stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
