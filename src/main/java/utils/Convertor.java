package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Convertor {

    public Convertor() {}

    public static List<Integer> stringToIntList(String target) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < target.length(); i++) {
            result.add(Character.getNumericValue(target.charAt(i)));
        }
        return new ArrayList<>(result);
    }
}
