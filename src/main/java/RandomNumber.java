/*
 * @(#)RandomNumber.java
 *
 * v 0.0.0
 *
 * 2019.11.29
 *
 * Copyright 2019. DunDung all rights reserved.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {

    public int[] create(int digit, int minValue, int maxValue) {
        List<Integer> availableNumberList = new ArrayList<>();
        int[] randomNumbers = new int[digit];

        for (int i = minValue; i <= maxValue; i++) {
            availableNumberList.add(i);
        }

        Collections.shuffle(availableNumberList);

        for (int i = 0; i < digit; i++) {
            randomNumbers[i] = availableNumberList.get(i);
        }

        return randomNumbers;
    }
}
