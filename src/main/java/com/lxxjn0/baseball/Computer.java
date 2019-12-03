/*
 * @(#)Computer.java        0.5 2019/12/03
 *
 * Copyright (c) 2019 lxxjn0.
 */
package com.lxxjn0.baseball;

import java.util.ArrayList;
import java.util.Random;

/**
 * 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성하는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.5 2019/12/03
 */
public class Computer {
    /** 생성해야 하는 수의 길이에 해당하는 상수 */
    private static final int NUM_LEN_TO_GENERATE = 3;
    /** 각 자리에 생성될 숫자 범위의 상한 상수 */
    private static final int MAX_NUM = 9;
    /** 각 자리에 생성될 숫자 범위의 하한 상수 */
    private static final int MIN_NUM = 1;
    /** 생성하는 숫자를 저장할 ArrayList */
    private ArrayList<Integer> generatedNumber;

    /**
     * Computer 클래스의 생성자.
     * 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 저장.
     */
    public Computer() {
        generateRandomNumber();
    }

    /**
     * 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성하는 메서드.
     */
    private void generateRandomNumber() {
        generatedNumber = new ArrayList<>();

        while (generatedNumber.size() < NUM_LEN_TO_GENERATE) {
            int tmp = new Random().nextInt(MAX_NUM) + MIN_NUM;
            if (!generatedNumber.contains(tmp)) {
                generatedNumber.add(tmp);
            }
        }
    }

    /**
     * generatedNumber getter
     *
     * @return 조건에 맞게 생성된 3자리 수 generatedNumber 반환
     */
    public ArrayList<Integer> getGeneratedNumber() {
        return generatedNumber;
    }
}
