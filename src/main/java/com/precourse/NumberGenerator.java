/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package com.precourse;

import java.util.ArrayList;
import java.util.Random;

/**
 * 클래스 이름 : NumberGenerator.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * <p>
 * 날짜 : 2019.12.2 월요일
 */
public class NumberGenerator {
    /*
     * NumberGenerator 클래스에서는 플레이어가 맞춰야할 수를 생성한다.
     */

    private static final int NUMBER_LENGTH = 3;
    private static ArrayList<Integer> numberList = new ArrayList<>();

    /**
     * 맞춰야할 숫자 리스트를 생성하는 메서드
     */
    public static ArrayList<Integer> numberGenerator() {
        numberList = getRandomNonRepeatingIntegers(NUMBER_LENGTH, 1, 9);
        return numberList;
    }

    /**
     * 범위 내의 임의의 정수를 생성하는 메서드
     */
    public static int getRandomInt(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * 반복되지 않는 수를 생성하도록 하는 메서드
     */
    public static ArrayList<Integer> getRandomNonRepeatingIntegers(
            int size, int min, int max) {
        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() < size) {
            int random = getRandomInt(min, max);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        return numbers;
    }

}
