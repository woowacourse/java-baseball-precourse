/*
 * GenerateRandomNumber.java
 *
 * version 1.1
 *
 * 2020/11/28
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package baseball.domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private static int NUM_LEN = 3;

    private List<Integer> numberList = new ArrayList<>();

    public String getRandomNumber() {
        return generateRandomNumber(initNumberList());
    }

    private List<Integer> initNumberList() {
        for (int i = 1; i < 10; i ++) {
            numberList.add(i);
        }

        return numberList;
    }

    private String generateRandomNumber(List<Integer> numberList) {
        String randomNumber = "";
        int index = 0;
        int listSize = 0;

        for (int i = 0; i < NUM_LEN; i++) {
            listSize = numberList.size();
            index = RandomUtils.nextInt(0, listSize - 1);
            randomNumber += Integer.toString(numberList.remove(index));
        }

        return randomNumber;
    }

}
