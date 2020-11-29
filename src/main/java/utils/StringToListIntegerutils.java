package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringToListIntegerutils {

    private StringToListIntegerutils() {
    }

    public static List<Integer> convertToList(String number) {
        List<String> stringNumber = new ArrayList<>(Arrays.asList(number.split("")));
        List<Integer> integerNumber = new ArrayList<>();

        for (String digit : stringNumber) {
            integerNumber.add(Integer.parseInt(digit));
        }

        return integerNumber;
    }
}
