/*
 * TargetNumberListGenerator.java
 * java-baseball-precourse
 *
 * Version 0.5
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
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 1;
    private static final int NUM_LEN = 3;

    private final ArrayList<Integer> targetNumberList;

    public TargetNumberListGenerator() {
        targetNumberList = setTargetNumberList();
    }

    public ArrayList<Integer> getTargetNumberList() {
        return targetNumberList;
    }

    private ArrayList<Integer> setTargetNumberList() {
        String targetNumberString;
        targetNumberString = generateRandomNumberString();
        return StringHandler.addToList(targetNumberString);
    }

    private String generateRandomNumberString() {
        String randomNumberString = "";
        int randomNumber = generateRandomNumber();
        randomNumberString += Integer.toString(randomNumber);
        while(randomNumberString.length() < NUM_LEN) {
            randomNumber = generateRandomNumber();
            if (randomNumberString.contains(Integer.toString(randomNumber))) {
                continue;
            }
            randomNumberString += Integer.toString(randomNumber);
        }
        return randomNumberString;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUM) + MIN_NUM;
    }
}