package utils;

import baseball.constant.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringToListIntegerutils {

    private StringToListIntegerutils() {}

    public static List<Integer> convertToList(String number) {
        List<String> stringList = new ArrayList<String>(Arrays.asList(number.split("")));
        List<Integer> integerlist = new ArrayList<Integer>();

        for (String digit : stringList) {
            integerlist.add(Integer.parseInt(digit));
        }

        return integerlist;
    }
}
