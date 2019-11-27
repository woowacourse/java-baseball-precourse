/*
 * TargetNumberListGenerator.java
 * java-baseball-precourse
 *
 * Version 0.2
 *
 * Created by 김경준 on 27/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */

package domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class TargetNumberListGenerator {
    private static final int MAX_NUM = 987;
    private static final int MIN_NUM = 123;
    private static final int BOUND_FROM_ZERO = MAX_NUM - MIN_NUM;
    private static final int NUM_LEN = 3;

    private ArrayList<Integer> targetNumberList = new ArrayList<>();

    private void setTargetNumberList() {
        String targetNumberString;
        do {
            targetNumberString = generateRandomNumberString();
        } while(isDuplicated(targetNumberString));
        addToList(targetNumberString);
    }

    private String generateRandomNumberString() {
        return Integer.toString(generateRandomNumber());
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(BOUND_FROM_ZERO) + MIN_NUM + 1;
    }

    private void addToList(String string) {
        for(int i = 0 ; i < string.length(); i++) {
            targetNumberList.add((int)string.charAt(i));
        }
    }

    private boolean isDuplicated(String string) {
        String[] strings = string.split("");
        Arrays.sort(strings);
        for(int i = 0; i < strings.length - 1; i++) {
            if(strings[i].equals(strings[i+1])) {
                return true;
            }
        }
        return false;
    }
}