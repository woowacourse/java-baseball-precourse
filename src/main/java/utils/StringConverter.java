package utils;

import java.util.ArrayList;
import java.util.List;

public class StringConverter {
    private StringConverter() {
    }

    public static List<Integer> toIntList(String origin) {
        List<Integer> result = new ArrayList<>();
        for (int idx = 0; idx < origin.length(); idx++) {
            result.add(Character.getNumericValue(origin.charAt(idx)));
        }
        return result;
    }
}
