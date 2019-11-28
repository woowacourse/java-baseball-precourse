/*
 * TargetNumberListGenerator.java
 * java-baseball-precourse
 *
 * Version 0.3
 *
 * Created by 김경준 on 27/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */

package domain;

import utils.StringHandler;

import java.util.ArrayList;
import java.util.Random;

public class TargetNumberListGenerator {
    private static final int MAX_NUM = 987;
    private static final int MIN_NUM = 123;
    private static final int BOUND_FROM_ZERO = MAX_NUM - MIN_NUM;

    private ArrayList<Integer> targetNumberList;

    private void setTargetNumberList() {
        String targetNumberString;
        do {
            targetNumberString = generateRandomNumberString();
        } while(StringHandler.isDuplicated(targetNumberString));
        targetNumberList = StringHandler.addToList(targetNumberString);
    }

    private String generateRandomNumberString() {
        return Integer.toString(generateRandomNumber());
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(BOUND_FROM_ZERO) + MIN_NUM + 1;
    }
}