/*
 * @(#)Computer.java        0.2 2019/12/02
 *
 * Copyright (c) 2019 lxxjn0.
 */
package com.lxxjn0.baseball;

import java.util.ArrayList;
import java.util.Random;

/**
 * 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성하는 클래스.
 *
 * @version         0.2 2019/12/02
 * @author          JUNYOUNG LEE (lxxjn0)
 */
public class Computer {
    /** 생성해야 하는 수의 길이를 저장한 상수 */
    private static final int NUM_LEN = 3;
    /** 각 자리에 생성될 숫자 범위의 상한 상수 */
    private static final int MAX_NUM = 9;
    /** 각 자리에 생성될 숫자 범위의 하한 상수 */
    private static final int MIN_NUM = 1;
    /** 생성하는 숫자를 저장할 ArrayList */
    private ArrayList<Integer> numList;

    /**
     * Computer 클래스의 생성자.
     * 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 저장.
     */
    public Computer() {
        int tmp;

        numList = numGenerator();
    }

    /**
     * 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성하여 반환하는 메서드.
     * @return 1부터 9까지의 서로 다른 수로 이루어진 3자리 수 tmpList 반환.
     */
    private ArrayList<Integer> numGenerator() {
        ArrayList<Integer> tmpList = new ArrayList<Integer>();

        while(tmpList.size() < NUM_LEN) {
            int tmp = new Random().nextInt(MAX_NUM) + MIN_NUM;
            /* 이전에 생성된 수와 중복되지 않을 경우 tmpList에 추가 */
            if(!tmpList.contains(tmp)) {
                tmpList.add(tmp);
            }
        }
        return tmpList;
    }

    /**
     * numList getter
     * @return 조건에 맞게 생성된 3자리 수 numList 반환
     */
    public ArrayList<Integer> getNumList() {
        return numList;
    }
}
