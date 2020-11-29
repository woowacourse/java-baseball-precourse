package utils;

import java.util.HashSet;
import java.util.Set;

public class Convertor {

    public Convertor() {}

    public static Set<Integer> stringToIntSet(String target) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < target.length(); i++) {
            result.add(Character.getNumericValue(target.charAt(i)));
        }
        return result;
    }
}
