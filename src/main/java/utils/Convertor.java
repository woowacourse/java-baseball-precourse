package utils;

import java.util.ArrayList;
import java.util.List;


public class Convertor {

    public Convertor() {
    }

    public static List<Integer> stringToIntList(String target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            result.add(Character.getNumericValue(target.charAt(i)));
        }
        return result;
    }
}
