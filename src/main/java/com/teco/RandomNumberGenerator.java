package com.teco;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 컴퓨터가 가지는 난수 발생기
 *
 * @author 김성훈
 * @version 1.0
 */
public class RandomNumberGenerator {
    private static final int RANDOM_NUMBER_MAX_RANGE = 9;
    private static final int RANDOM_NUMBER_MIN_RANGE = 1;

    private int generateRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_MAX_RANGE) + RANDOM_NUMBER_MIN_RANGE;
    }

    Set<Integer> makeThreeRandomNumbers() {
        Set<Integer> threeRandomNumberSet = new LinkedHashSet<>();
        for (int i = 0; i < 3; i++) {
            threeRandomNumberSet.add(new RandomNumber(generateRandomNumber()).getRandomNumber());
        }
        return threeRandomNumberSet;
    }
}
