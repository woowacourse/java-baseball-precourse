package utils;

import java.util.*;

public class Convertor {

    public Convertor() {
    }

    public static List<Integer> stringToIntList(String target) {
        Set<Integer> result = new LinkedHashSet<>();
        for (int i = 0; i < target.length(); i++) {
            result.add(Character.getNumericValue(target.charAt(i)));
        }
        return new ArrayList<>(result);
    }
}
