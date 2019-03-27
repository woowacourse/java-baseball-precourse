package com.nekisse.baseball;

import java.util.ArrayList;
import java.util.List;

public class InputUtils {

    public static List<Integer> convertInputToBaseBallNumbers(String input) {

        List<Integer> userBaseBallNumbers = new ArrayList<>();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            userBaseBallNumbers.add(Integer.parseInt(String.valueOf(aChar)));
        }
        return userBaseBallNumbers;
    }
}
