/*
 * @(#)RandomNumbers.java
 *
 * v 0.0.0
 *
 * 2019.11.28
 *
 * Copyright 2019. DunDung all rights reserved.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbers {

    public static String createNumbers(int digit, int minValue, int maxValue) {
        List<Integer> availableNumberList = new ArrayList<>();
        for (int i=minValue; i<=maxValue; i++) {
            availableNumberList.add(i);
        }

        Collections.shuffle(availableNumberList);

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<digit; i++) {
           builder.append(availableNumberList.get(i));
        }

        return builder.toString();
    }
}
